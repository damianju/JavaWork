package com.lec.sts13_jdbc.board;

import org.springframework.jdbc.core.JdbcTemplate;

public class C {
	
	// 스프링 컨테이너에 생성된 JdbcTemplate 을 받아와서
	// 언제, 어느곳에서든지 가져다 쓸수 있도록 public static 설정
	public static JdbcTemplate template;
	
	// 게시글 관련 쿼리문
	
	
	
	
	public static final String SQL_WRITE_INSERT = 
			"INSERT INTO test_write"
			+ "(wr_uid, wr_subject, wr_content, wr_name, wr_regdate) "
			+ "VALUES"
			+ "(test_write_seq.nextval, ?, ?, ?, SYSDATE)";
	
	public static final String SQL_WRITE_SELECT = 
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewcnt, "
			+ "wr_regdate regdate FROM test_write ORDER BY wr_uid DESC";
	
	public static final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewcnt, "
			+ "wr_regdate regdate FROM test_write WHERE wr_uid=?";


	
	/*
	 * public static final String SQL_WRITE_SELECT =
	 * "SELECT * FROM test_write ORDER BY wr_id DESC";
	 * 
	 * public static final String SQL_WRITE_SELECT_BY_ID =
	 * "SELECT * FROM test_write WHERE wr_id=?";
	 */
	
	public static final String SQL_WRITE_INC_VIEWCNT = 
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";
	
	public static final String SQL_WRITE_DELETE_BY_ID = 
			"DELETE FROM test_write WHERE wr_uid = ?";

	public static final String SQL_WRITE_UPDATE =
			"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";



}
