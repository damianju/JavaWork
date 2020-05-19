package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConPath")
public class ContextPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextPath() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL: Uniform Resource Locator
		StringBuffer url = request.getRequestURL();
		// URI: Uniform Resource Identifier
		String uri = request.getRequestURI();
		// Context Path
		String conPath = request.getContextPath();
		// domain 추출하기
		String url_domain = request.getScheme() + "://" + request.getServerName()+":"+ request.getServerPort();
		// 물리적인 servletContextName, contest path가 아님
		ServletContext context = request.getServletContext();
		String servletContextName = context.getServletContextName();
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset='utf-8'");
		
		out.println("<hr>");
		out.println("URL: "+ url + "<br>");
		out.println("URI: "+ uri + "<br>");
		out.println("ContextPath: "+ conPath + "<br>");
		out.println("URL_domain: "+url_domain + "<br>");
		out.println("Servlet ContextName: "+servletContextName+ "<br>");
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
