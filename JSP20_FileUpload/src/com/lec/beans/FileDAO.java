package com.lec.beans;

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

public class FileDAO {
	Connection conn = null; // DB 연결을 위한 받기 객체
	Statement stmt = null; // SQL 문을 수행하고 그 결과를 리턴하기 위한 객체
	PreparedStatement pstmt = null; // 강화된 statement(precompiled SQL문, for multiple time)
	ResultSet rs = null;   // SELECT 결과, executeQuery() // 쿼리 수행결과를 테이블로 담는 객체 (행 단위로 커서 이동)
	
	// DAO 객체가 생성될때 Connection 도 생성된다.
	public FileDAO() {
		
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
	
	// ResultSet ==> DTO 배열로 리턴
	public FileDTO[] createArray(ResultSet rs) throws SQLException {
		FileDTO [] arr = null;
		List<FileDTO> list = new ArrayList<FileDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("bf_uid");
			String source = rs.getString("bf_source");
			String file = rs.getString("bf_file");
			
			FileDTO dto = new FileDTO(uid, source, file);
			list.add(dto);
		} // end while
		
		arr = new FileDTO[list.size()];
		list.toArray(arr);
		
		
		
		
		return arr;
	}
	
	// 특정 글 (wr_uid) 의 첨부파일(들) SELECT
	public FileDTO [] selectFilesByWrUid(int wrUid) throws SQLException{
		
		FileDTO[] arr = null;
		
		try {
			// "SELECT bf_uid, bf_source, bf_file FROM test_file WHERE wr_uid = ? ORDER BY bf_uid DESC"
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
		
	} // end selectFilesByWrUid
	
	
	// 특정 파일 (bf_uid) 의 첨부파일 하나 SELECT
	public FileDTO [] selectByUid(int uid) throws SQLException{
		
		FileDTO[] arr = null;
		
		try {
			// "SELECT bf_uid, bf_source, bf_file FROM test_file WHERE bf_uid = ?"
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
		
	} // end selectFilesByWrUid
	
} // end DAO










