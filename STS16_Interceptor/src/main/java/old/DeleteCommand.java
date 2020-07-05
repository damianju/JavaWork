package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import old.WriteDAO;
import old.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		// 매개변수 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));

		if(uid != 0) {
			
			try {
				cnt = dao.deleteByUid(uid);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}//end if
		

		request.setAttribute("delete", cnt);
		
	} // end execute()

} // end command
