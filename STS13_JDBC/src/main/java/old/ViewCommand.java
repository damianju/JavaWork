package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import old.WriteDAO;
import old.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		// 매개변수 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(arr == null || arr.length == 0) {
			
			try {
				arr = dao.readByUid(uid);
				
				request.setAttribute("view", arr);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
