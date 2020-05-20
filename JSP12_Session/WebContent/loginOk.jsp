<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
	
	
%>

<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String sessionName = "userid";
	String sessionValue = userid;
	
	// id/ pw 일치하면 로그인 성공 + 세션 성공
	if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
		out.println("<script>");
		out.println("alert('로그인 성공')");
		out.println("</script>");
		
		session.setAttribute(sessionName, sessionValue);
	} else{
		out.println("<script>");
		out.println("alert('로그인 실패')");
		out.println("</script>");
		
		// 혹시 있으면(?) 세션 삭제
		session.removeAttribute(sessionName);
	

	} // end if
%>

<script>
	location.href = "login.jsp";
</script>