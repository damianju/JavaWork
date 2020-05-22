package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성
		WriteDTO [] arr = null;
		
		try {
			// 트랜젝션 수행
			arr= dao.select();
			
			// "list" 란 name으로 request 에 arr 값 전달
			// 즉 request 에 담아서 컨트롤러에 전달되는 셈.
			request.setAttribute("list", arr);
			
		} catch(SQLException e) { 
			// 만약 CP 사용한다면
			// NamingException 도 처리해야 함.
			
			e.printStackTrace();
		}
	}

}
