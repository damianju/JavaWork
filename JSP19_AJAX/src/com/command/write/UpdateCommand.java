package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		// 매개변수 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		if(uid != 0 && subject !=null && subject.trim().length()>0) {
			
			try {
				cnt = dao.update(uid, subject, content);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}//end if
		
		
		request.setAttribute("updateOk", cnt);
		
	} // end execute()

} // end command
