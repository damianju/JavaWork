package com.lec.sts16_interceptor.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;


import com.lec.sts16_interceptor.board.C;


public class BWriteDAO {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public BWriteDAO() {
		this.template = C.template;
	}
	
	
	// 전체 SELECT
	public List<BWriteDTO> select(){
		
		//"SELECT wr_uid uid, wr_subject subject, wr_content content, wr_name name, wr_viewcnt viewcnt, wr_regdate regDate FROM test_write ORDER BY wr_uid DESC"
		return template.query(C.SQL_WRITE_SELECT, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}
	
	
	public int insert(final BWriteDTO dto) {
		
		/*1. update() + PreparedStatementSetter() 
		 * return template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
		 * 
		 * @Override public void setValues(PreparedStatement ps) throws SQLException {
		 * ps.setString(1, dto.getSubject()); ps.setString(2, dto.getContent());
		 * ps.setString(3, dto.getName()); } });
		 */
		
		
		/* 2. update() + PreparedStatementCreator() */
		return
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
				
				return ps;
				
			}
		});
				
	} // end insert()
	
	
	/*
	 * public List<BWriteDTO> readByUid(final int uid){
	 * 
	 * return template.query(new PreparedStatementCreator() { PreparedStatement ps =
	 * null;
	 * 
	 * @Override public PreparedStatement createPreparedStatement(Connection con)
	 * throws SQLException { try {
	 * 
	 * con.setAutoCommit(false);
	 * 
	 * // 조회수 증가 ps =con.prepareStatement(C.SQL_WRITE_INC_VIEWCNT); ps.setInt(1,
	 * uid); ps.executeUpdate();
	 * 
	 * ps.close();
	 * 
	 * // 읽기 ps = con.prepareStatement(C.SQL_WRITE_SELECT_BY_UID); ps.setInt(1,
	 * uid); ps.executeQuery();
	 * 
	 * con.commit();
	 * 
	 * } catch(SQLException e) { con.rollback();
	 * 
	 * } return ps;
	 * 
	 * } }, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class)); } // end
	 * readByUid()
	 */	


	List<BWriteDTO> list= null;

	public List<BWriteDTO> readByUid(final int uid){

				
				// 조회수 증가
				
				template.update(C.SQL_WRITE_INC_VIEWCNT, new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, uid);
					}
				});
				
				// 읽기
				list=
				template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, uid);
					}
				}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
			

		return list;
		
	} // end readByUid()
	
	public List<BWriteDTO> selectByUid(final int uid){
		return template.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_SELECT_BY_UID);
				ps.setInt(1, uid);
				ps.executeQuery();
				return ps;
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	} // end selectByUid()
	
	public int update(final BWriteDTO dto) {
		// "UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_id = ?";
		return template.update(C.SQL_WRITE_UPDATE, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
			}
		});
	} // end update()
	
	public int deleteByUid(final int uid) {
		return 
		template.update(C.SQL_WRITE_DELETE_BY_ID, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
			}
		});
	}
	
} // end class
