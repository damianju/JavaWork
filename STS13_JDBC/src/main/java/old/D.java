package old;

// DB, SQL 관련 상수 정의 클래스 (-> Data Access Object 에서 사용)
/*
 * DB 접속 정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라미터 등에서 관리하는 것이 좋다.
 */
public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	public static final String USERID = "scott0316";  // DB 접속 계정 정보
	public static final String USERPW = "tiger0316";
	
	// list 구성: 테이블(test_write)에서 내림차순(DESC)로 모든 내용 추출하여 보여줌
	public static final String SQL_WRITE_SELECT = 
			"SELECT * FROM test_write ORDER BY wr_uid DESC"; 
	
	// 쓰기(Create):테이블(test_write)의 특정 칼럼(wr_uid, wr_subject, wr_content, wr_name)에 값을 삽입(등록)함
	public static final String SQL_WRITE_INSERT = "INSERT INTO test_write " +
		"(wr_uid, wr_subject, wr_content, wr_name) " +
		"VALUES(test_write_seq.nextval, ?, ?, ?)";

	// 조회수 증가: 테이블(test_write)에서 조건(uid)에 맞는 행(row)의 특정 값(wr_viewcnt)을 업데이트함
	public static final String SQL_WRITE_INC_VIEWCNT =  // 조회수 증가
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

	// 읽기(Read): 테이블(test_write)에서 조건(uid)에 맞는 행(row) 보여주기
	public static final String SQL_WRITE_SELECT_BY_UID =  // 글 읽어 오기
			"SELECT * FROM test_write WHERE wr_uid = ?";
	
	// 수정(Update): 테이블(test_write)에서 조건(uid)에 맞는 행(row)의 특정 값(wr_subject, wr_content)을 수정(업데이트)함
	public static final String SQL_WRITE_UPDATE = 
			"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";
	
	// 삭제(Delete): 테이블(test_write)에서 조건(uid)에 맞는 행(row)을 삭제함
	public static final String SQL_WRITE_DELETE_BY_UID = 
			"DELETE FROM test_write WHERE wr_uid = ?";

}




























