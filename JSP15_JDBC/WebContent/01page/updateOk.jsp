<%-- updateOk.jsp: 수정내용을 DBMS에 업데이트하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>   

<%	// parameter 받아오기
	request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭!(post 방식)
	// 'update.jsp'의 수정값을 받아옴.
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// * 이 단계에서 parameter 검증 필요
	
%>
 
<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery() 
	int cnt = 0;   // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%!
	// 쿼리문 준비
	final String SQL_WRITE_UPDATE = "UPDATE TEST_WRITE SET WR_SUBJECT = ?, WR_CONTENT = ? WHERE WR_UID = ?";

%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_UPDATE);
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setInt(3, uid);
		
		cnt = pstmt.executeUpdate();
		// executeUpdate()의 리턴 값
		// (1) 반영된 행(row)의 숫자: Data Manipulation Language(INSERT, DELETE, UPDATE) 
		// (2) 0 for SQL statements that return nothing
		
	} catch(Exception e){
		e.printStackTrace();
		// e.printStackTrace(): 에러 메세지의 발생 근원지를 찾아서 단계별로 에러 출력 (가장 상세한 예외 메세지 출력)
		// e.getMessage()
		// e.toString()
		// 예외 처리
	} finally {
		// 리소스 해제
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<% if(cnt == 0){ %> <%-- 반영된 행이 없다면 --%>
		<script>
			alert("수정 실패");
			history.back();
		</script>	
<% } else{ %>
		<script>
			alert("수정 성공");
			location.href= "view.jsp?uid=<%=uid%>";
		</script>
<% } %>






















