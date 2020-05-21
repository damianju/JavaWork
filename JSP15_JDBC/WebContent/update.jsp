<%-- update.jsp: 수정화면을 구성하고 수정내용을 request하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>    
<%@ page import = "java.text.SimpleDateFormat" %>

<% 
	// parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// *이 단계에서 parameter 검증 필요(이번 예제에서는 생략)
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
	final String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM TEST_WRITE WHERE WR_UID=?";  // 글 읽어오기
	
%>

<%
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>


<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		// a ResultSet object that contains the data produced by the query; never null
		
		// 한 개의 레코드만 select 된다.
		if(rs.next()){
			//Moves the cursor forward one row from its current position.
			//A ResultSet cursor is initially positioned before the first row;
			//true if the new current row is valid; false if there are no more rows
			subject = rs.getString("WR_SUBJECT");
			//Retrieves the value of the designated column in the current row of this ResultSet object as a String in the Java 
			content = rs.getString("WR_CONTENT");
			if(content == null) content = ""; // null 처리
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			regdate = "";
			if(d != null){
			 	regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " 
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
		} else{
			// wr_uid 값의 레코드가 없다는 뜻
%>
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>
		
<% 		
		return; // 더이당 JSP 프로세싱 하지 않고 종료
		}
	} catch(Exception e){
		e.printStackTrace();
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



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정화면 <%= subject %></title>
</head>
<script>
function chkSubmit(){
	frm=document.forms['frm']; // 변수 정의: 현재 문서(document)의 'frm'이라는 form을 frm으로 정의
	var subject= frm['subject'].value.trim();
	
	if(subject==""){ // 프런트엔드 변수 검즘 (제목은 필수), required로도 처리 가능
		alert("제목은 반드시 작성해야 합니다");
		frm['subject'].focus(); // cursor 포커스 옮겨주기
		return false; // submit 실패
	}
	return true; // submit 성공
}

</script>
<body>
<h2>수정</h2>
<form name="frm" action="updateOk.jsp" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%= uid %>"/> <!-- parameter 넘길 때 자주 사용 -->
작성자: <%= name %><br> <%-- 작성자 이름 변경 불가 --%>
제목: 
<input type="text" name="subject" value="<%= subject %>"/><br>
내용: <br>
<textarea name="content"><%= content %></textarea>
<br>
<input type="submit" value="수정"/>

</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp'">목록보기</button>

</body>
</html>