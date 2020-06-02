package com.lec.beans;

import java.nio.file.FileSystemNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import common.D;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체

// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능

public class WriteDAO {
	Connection conn = null; // DB 연결을 위한 받기 객체
	Statement stmt = null; // SQL 문을 수행하고 그 결과를 리턴하기 위한 객체
	PreparedStatement pstmt = null; // 강화된 statement(precompiled SQL문, for multiple time)
	ResultSet rs = null;   // SELECT 결과, executeQuery() // 쿼리 수행결과를 테이블로 담는 객체 (행 단위로 커서 이동)
	
	// DAO 객체가 생성될때 Connection 도 생성된다.
	public WriteDAO() {
		
		try {
			Class.forName(D.DRIVER);
			// DriverManager: JDBC 드라이버를 관리하기 위한 기본 서비스 
			// getConnection: 해당 DB URL에 연결 시도
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}		
		
	} // 생성자

	// DB 자원 반납 메소드
	public void close() throws SQLException {
		// 오픈한 반대로 반납. 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	// 새글 작성 <-- DTO
	public int insert(WriteDTO dto) throws SQLException {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();
		
		// 아래 중복정의(overload)된 메소드를 이용하여 cnt 값 받아옴
		int cnt = this.insert(subject, content, name);
		return cnt;
	}
	
	// 새글 작성 <-- 제목, 내용, 작성자 (Overloading)
	public int insert(String subject, String content, String name) throws SQLException {
		int cnt = 0;
		
		try {	
			// prepareStatement(): 매개변수 SQL문을 DB에 보내기 위한 prepareStatement 객체 생성
			// "INSERT INTO test_write (wr_uid, wr_subject, wr_content, wr_name) VALUES(test_write_seq.nextval, ?, ?, ?)"
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
			// driver가 Java string 값을 VARCHAR로 변환하여 보내기 위해 세팅
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			
			// DML(INSERT, UPDATE, DELETE) 쿼리문 수행
			// 리턴값: 업데이트 된 행(row) 숫자 (없으면 0)
			cnt = pstmt.executeUpdate();
		} finally {
			close();			
		}

		return cnt;
	}
	
	// 새글 작성 <-- 제목, 내용, 작성자
	// 		 <-- 첨부파일(들)
	public int insert(String subject, String content, String name,
			//  이미 파일은 저장되어 있다 (cos 라이브러리)
			List<String> originalFileNames  // 원본 파일명(들)
			, List<String> fileSystemNames // 저장된 파일명(들)
			) throws SQLException {
		int cnt = 0;
		int uid = 0; // INSERT 된 글의 wr_uid 값
		 
		try {	
			// 자동생성된 컬럼의 이름(들)이 담긴 배열 준비 (auto-generated keys)
			String [] generatedCols = {"wr_uid"};
			
			
			// Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
			// prepareStatement(): 매개변수 SQL문을 DB에 보내기 위한 prepareStatement 객체 생성
			// "INSERT INTO test_write (wr_uid, wr_subject, wr_content, wr_name) VALUES(test_write_seq.nextval, ?, ?, ?)"
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT, generatedCols);
			// driver가 Java string 값을 VARCHAR로 변환하여 보내기 위해 세팅
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			
			// DML(INSERT, UPDATE, DELETE) 쿼리문 수행
			// 리턴값: 업데이트 된 행(row) 숫자 (없으면 0)
			cnt = pstmt.executeUpdate();
			
			// auto-generated keys 값 뽑아오기
			rs= pstmt.getGeneratedKeys();
			if(rs.next()) {
				uid = rs.getInt(1); // 첫번째 컬럼
			}
			
			pstmt.close();
			// 첨부파일(들) 정보 테이블에 INSERT 하기
			// "INSERT INTO test_file(bf_uid, bf_source, bf_file, wr_uid) VALUES(test_file_seq.nextval, ?, ?, ?)"
			pstmt = conn.prepareStatement(D.SQL_FILE_INSERT);
			for(int i = 0; i <originalFileNames.size(); i++) {
				pstmt.setString(1, originalFileNames.get(i));
				pstmt.setString(2, fileSystemNames.get(i));
				pstmt.setInt(3, uid);
				pstmt.executeUpdate();
			} // end for
		} finally {
			close();			
		}

		return cnt;
	}
	
	// ResultSet --> DTO 배열로 리턴
	public WriteDTO [] createArray(ResultSet rs) throws SQLException {
		WriteDTO [] arr = null;  // DTO 배열
		
		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();
		
		// next(): 커서를 첫 행부터 다음 행으로 옮김
			// 리턴값: true - 다음 행이 있음, false - 다음 행이 없음
		while(rs.next()) {
			//getInt(), getString(), getDate(), getTime() : 현재 선택(cursor)된 행의 해당 컬럼(매개변수)에서 값을 검색하여 해당 Java 값(int, String, Date, Time)로 반환해 리턴
				// 매개변수: 컬럼 라벨
				// 리턴값: 해당 컬럼 값 (없으면 int -> 0, String, Date, Time -> null)
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			String regDate = "";
			if(d != null){
				// SimpleDateFormat(): 주어진 Date 형식으로 값을 변환하는 생성자
					// 매개변수: Date 형식
				// format(): Date, Time -> String 변환 
				regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			} // end if
			
			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewCnt);
			dto.setRegDate(regDate);
			
			// add(): Appends the specified element to the end of this list.
			// 매개변수: element
			// 리턴값: true
			list.add(dto);
			
		} // end while
		
		// size()
			// 리턴값: list의 element 갯수
		int size = list.size();
		
		// list에 add된 게 없으면 null 리턴
		if(size == 0) return null;
		
		arr = new WriteDTO[size];
		// toArray()
			// 매개변수: list의 elements를 담을 array
			// 리턴값: list의 elements를 순서대로 담은 array
		list.toArray(arr);  // List -> 배열		
		return arr;
	} // end createArray()
	
	// 전체 SELECT
	public WriteDTO [] select() throws SQLException {
		WriteDTO [] arr = null;
		
		try {
			// "SELECT * FROM test_write ORDER BY wr_uid DESC"
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			// executeQuery(): 쿼리문 수행
				// 리턴값: 수행한 결과를 담은 ResultSet
			rs = pstmt.executeQuery();
			// 쿼리 수행 -> ResultSet -> WriteDTO 생성(한 row씩) -> ArrayList에 담기(한 row씩) -> Array 변환
			arr = createArray(rs);
		} finally {
			close();
		}		
		
		return arr;
	} // end select()
	
	// 특정 uid 의 글 내용 읽기, 조회수 증가
	// viewCnt 도 1 증가 해야 하고, 글 읽어와야 한다 --> 트랜잭션 처리
	public WriteDTO [] readByUid(int uid) throws SQLException{
		int cnt = 0;
		WriteDTO [] arr = null;
		
		try {
			// 트랜잭션 처리
			// Auto-commit 비활성화
			conn.setAutoCommit(false);
			
			// 쿼리들 수행
			
			// 조회수 증가
			// "UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			
			// 읽기(read)
			// "SELECT * FROM test_write WHERE wr_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			arr = createArray(rs);
			// Makes all changes made since the previous commit/rollback permanent 
			conn.commit();
			
		} catch(SQLException e) {
			// Undoes all changes made in the current transaction
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return arr;
	} // end readByUid()
	
	
	// 특정 uid 의 글 만 SELECT (조회수 증가 없슴!) --> 수정을 위한 메소드
	public WriteDTO [] selectByUid(int uid) throws SQLException {
		WriteDTO [] arr = null;
		
		try {
			// "SELECT * FROM test_write WHERE wr_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}
	
	
	// 특정 uid 의 글 수정 (제목, 내용)
	public int update(int uid, String subject, String content) throws SQLException {
		int cnt = 0;
		try {
			// "UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		
		return cnt;
	} // end update()
	
	// 특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		try {
			// "DELETE FROM test_write WHERE wr_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		return cnt;
	} // end deleteByUid()
	
	
	
	
	
	
} // end DAO










