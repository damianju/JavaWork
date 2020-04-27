package phonebook06.db;

// Controller 인터페이스
// 동작 정의하기 전에 '동작 설계'
public interface Pb {

	public static final String VERSION = "전화번호부 6.0";

	public abstract int insert(String name, String phoneNum, String memo); /* 1 */

	public abstract PhonebookModel[] selectAll(); /* 2 */

	public abstract PhonebookModel selectByUid(int uid); /* 3 */

	public abstract int updateByUid(int uid, String name, String phonNum, String memo); /* 4 */

	public abstract int deleteByUid(int uid); /* 5 */

	// public static final int QUERY_FAIL = 0;

	// 에러코드 상수
	public static final int ERR_GENERIC = 0; // 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1; // 인덱스 범위 벗어남
	public static final int ERR_EMTRY_STRING = 2; // 입력문자열이 empty (혹은 null)인 경우
	public static final int ERR_UID = 3; // uid가 없는 경우
	
	// 에러문자열
	public static final String[] ERR_STR= {
		"일반 오류",// 0
		"인덱스 오류",// 1
		"문자열 오류",// 2
		"UID 오류",// 3
		};


	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";
	
	public static final String TBL_NAME = "phonebook";
	
	public static final String COL_LABEL_UID = "pb_uid";
	public static final String COL_LABEL_NAME = "pb_name";
	public static final String COL_LABEL_PHONENUM = "pb_phonenum";
	public static final String COL_LABEL_MEMO = "pb_memo";
	public static final String COL_LABEL_REGDATE = "pb_regdate";
	public static final String SEQ_NAME = "phonebook_seq";

	// 쿼리 문자열
	// preparedstatement 방식
	public static final String SQL_COUNT_ALL = "SELECT COUNT(*) cnt FROM " + TBL_NAME;
	public static final String SQL_SELECT_ALL = "SELECT * FROM "+ TBL_NAME + " ORDER BY "+ COL_LABEL_UID + " DESC";
	public static final String SQL_INSERT = "INSERT INTO "+TBL_NAME + "(pb_uid, pb_name, pb_phonenum, pb_memo) " + "VALUES("+ SEQ_NAME+".nextval, ?, ?, ?)";
	public static final String SQL_UPDATE_BY_UID = "UPDATE "+ TBL_NAME +" SET "+ COL_LABEL_NAME +" = ?, "+ COL_LABEL_PHONENUM +" = ?, "+ COL_LABEL_MEMO +" = ? " + "WHERE "+ COL_LABEL_UID +" = ?";
	public static final String SQL_SELECT_BY_UID = "SELECT " + COL_LABEL_UID + " FROM " + TBL_NAME + " WHERE "+ COL_LABEL_UID + " = ?";
	public static final String SQL_DELETE_BY_UID = "DELETE FROM "+ TBL_NAME + " WHERE "+COL_LABEL_UID + " = ?";
	
	// TODO : 추가로 필요한 쿼리문
	
} // end class


