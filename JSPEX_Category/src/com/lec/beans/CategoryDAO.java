package com.lec.beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public CategoryDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() throws SQLException{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	public void closeWithConn() throws SQLException{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();

	}
	
	public CategoryDTO [] createArray(ResultSet rs) throws SQLException{
		CategoryDTO [] arr = null;
		
		ArrayList<CategoryDTO> list= new ArrayList<CategoryDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("ca_uid");
			String name = rs.getString("ca_name");
			int depth = rs.getInt("ca_depth");
			int parent= rs.getInt("ca_parent");
			int order= rs.getInt("ca_order");
			
			CategoryDTO dto = new CategoryDTO(uid, name, depth, parent, order);
			list.add(dto);
		} // ene while
		
		int size = list.size();
		
		if(size == 0) return null;
		arr = new CategoryDTO[size];
		list.toArray(arr);
		return arr;
		
	} // end createArray()
	
	public CategoryDTO [] selectByCategory(int depth, int parent) throws SQLException {
		CategoryDTO [] arr = null;
		
		try {
			pstmt =conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
			pstmt.setInt(1, depth);
			pstmt.setInt(2, parent);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
		
	}
	
	
	
} // end class
