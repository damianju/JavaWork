// Controller: command와 view를 골라 줌

package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.Command;
import com.command.write.DeleteCommand;
import com.command.write.ListCommand;
import com.command.write.SelectCommand;
import com.command.write.UpdateCommand;
import com.command.write.ViewCommand;
import com.command.write.WriteCommand;

@WebServlet("*.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		
	}

	protected void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출");
		
		request.setCharacterEncoding("utf-8");
		
		// 컨트롤러는 다음 두 개를 선택해야 한다.
		
		String viewPage = null; // 어떠한 뷰?--> 페이지
		Command command = null; // 어떠한 커맨드?--> 어떤한 로직 수행
		
		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI(); // JSP18_MVC/list.do
		String conPath = request.getContextPath(); // JSP18_MVC
		String com = uri.substring(conPath.length()); // /list.do
		// String.substring(int beginIndex): 해당 스트링의 앞에서부터 index만큼 삭제
		
		//테스트 출력
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath);
		System.out.println("com: "+com);
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행학 결과를 내보낼 view를 결정한다.
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case "/write.do":
			viewPage = "write.jsp";
			break;
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";
			break;
		case "/view.do":
			command =new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
			break;
		case "/update.do":
			command =new SelectCommand();
			command.execute(request, response);
			viewPage = "update.jsp";
			break;
		case "/updateOk.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;
		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;
			
			
			
		} // end switch
		
		// request를 위에서 결정된 view에 forward 해줌
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
