package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		// 첨부파일 정보도 update 화면에 보여주어야 한다.
		FileDAO fileDao = new FileDAO();
		FileDTO [] fileArr = null;
		
		// 매개변수 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			arr = dao.selectByUid(uid); // 읽기 only
			request.setAttribute("update", arr);
			
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFilesByWrUid(uid);
				request.setAttribute("file", fileArr);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
