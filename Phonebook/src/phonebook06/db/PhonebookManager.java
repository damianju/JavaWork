package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// abc
// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {

	// DB 를 위한 변수들 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// singleton 적용
	private PhonebookManager() {
		// JDBC 프로그래밍
		try {
			// 클래스 로딩
			Class.forName(DRIVER);
			// 연결 Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			// Statement (필요하다면) 생성

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstatnce() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증: 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력 오류:", Pb.ERR_EMTRY_STRING);
		}

		int cnt = 0;

		// SQL_INSERT 사용하여 INSERT
		// PreparedStatment 사용..
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	} // end insert()

	@Override
	public PhonebookModel[] selectAll() {

		List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
		

		// SQL_SELECT_ALL
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			//DateFormat inpuFormatter = null;
			
			while (rs.next()) {
				int uid = rs.getInt(COL_LABEL_UID);
				String name = rs.getString(COL_LABEL_NAME);
				String phoneNum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				//Date date = rs.getDate(COL_LABEL_REGDATE);	
				Date d = rs.getDate(COL_LABEL_REGDATE);	
				Time t = rs.getTime(COL_LABEL_REGDATE);
				//Time t = rs.getTimeStamp(COL_LABEL_REGDATE);
				
				String input = new SimpleDateFormat("yyyy/MM/dd").format(d) + " "+ new SimpleDateFormat("hh:mm:ss").format(t);
				DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				java.util.Date date = inputFormatter.parse(input);
				
				PhonebookModel list = new PhonebookModel(uid, name, phoneNum, memo, date);
				pbList.add(list);
			}
			pstmt.close();
			// 아래와 같이 한줄로 가능! toArray() : List<> --> 배열로 변환
			// return pbList.toArray(new PhonebookModel[pbList.size()]);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return pbList.toArray(new PhonebookModel[pbList.size()]);
	} // end selecAll()

	// 시간은 파싱으로 고친다
	// 특정 uid 의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		PhonebookModel pb = new PhonebookModel();
	
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			if (rs.next() == true) return pb;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null; // 못 찾으면 null 리턴
	} // end method

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류:" + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류: ", Pb.ERR_EMTRY_STRING);

		int cnt = 0;
		
		// SQL_UPDATE_BY_UID
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류:" + uid, Pb.ERR_UID);

		int cnt = 0;

		// SQL_DELETE_BY_UID
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 현재 데이터 중 가장 큰 Uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션
		// MAX()

		return maxUid;
	}

	@Override
	public void close() throws IOException {

		try {
			// ResultSet
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			// Connection
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// TODO
		// Statement
		// 들 close();

	} // end close()
} // end PhonebookManager

// 예외 클래서 정의
// 예외 발생하면 '에러 코드' + '에러 메세지'를 부여하여 관리하는 게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
} // end PhonebookException
