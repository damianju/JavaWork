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
import com.command.write.FileUploadCommand;
import com.command.write.ListCommand;
import com.command.write.SelectCommand;
import com.command.write.UpdateCommand;
import com.command.write.ViewCommand;
import com.command.write.WriteCommand;

@WebServlet("*.do")
public class WriteController extends HttpServlet {
	// 직렬화: 자바 시스템 내부(JVM 메모리)에서 사용되는 객체 데이터를 외부의 자바 시스템에서 사용할 수 있도록 바이트(byte) 형태로 변환
	// 직렬화 사용 고유 아이디 (선언하지 않으면 디폴트값 설정됨)
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
		
		// POST 방식에서 폼 태크 입력 값이 JSP 파일로 전송 될 때 한글이 깨지지 않도록 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 컨트롤러는 다음 두 개를 선택해야 한다.
		String viewPage = null; // 어떠한 뷰?--> 페이지
		Command command = null; // 어떠한 커맨드?--> 어떠한 로직 수행
		
		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI(); // JSP18_MVC/list.do
		String conPath = request.getContextPath(); // JSP18_MVC
		String com = uri.substring(conPath.length()); // /list.do
		// String.substring(int beginIndex): 해당 스트링의 앞에서부터 index만큼 삭제
		
		//테스트 출력
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath);
		System.out.println("com: "+com);
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행할 결과를 내보낼 view를 결정한다.
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "/list.jsp";
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
			
		// 웹에디터용 파일 업로드 처리
		case "/fileUpload.do":
			new FileUploadCommand().execute(request, response);
			break;
			
			
		} // end switch
		
		// request를 위에서 결정된 viewPage에 forward 해줌
		if(viewPage != null) {
			// RequestDispatcher: client 로부터 request을 받아 서버의 다른 resource(servlet, HTML file, or JSP file)로 넘겨주는 클래스
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} // end if
	}
} // end class

// getRequestDispatcher()
	// 매개변수: path name("/"로 시작함).
	// 리턴값: RequestDispatcher 객체 (resource wrapper) or null
