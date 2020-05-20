<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.text.*"%>
<%@ page import= "java.util.*" %>
<% 
	String cookieName1= "num1";
	String cookieValue1= "" + (int)(Math.random()*10); // 0<= x <1
	Cookie cookie = new Cookie(cookieName1, cookieValue1); // 이름-값으로 쿠키 생성
	cookie.setMaxAge(2*3); // 쿠키 파기(expiry) 시간 설정 (생성 시점으로 부터 2*30 초 후)
	response.addCookie(cookie); // response에 쿠키 정보 추가

	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30);
	response.addCookie(cookie2);
%>

<script>
	alert("<%= cookieName1 %> 쿠키 생성");
	location.href = "cookieList.jsp";
</script>