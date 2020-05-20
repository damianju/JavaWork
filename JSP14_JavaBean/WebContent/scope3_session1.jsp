<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope ="session"/>
<jsp:setProperty name="cnt" property="count"/>
<%-- cnt.setCount(Integer.parseInt(request.getParameter("count")))--%>

<h3>session1<br>cnt의 getCount 호출</h3>

<jsp:getProperty name="cnt" property="count"/><br>
<%-- cnt.getCount() --%>

<a href="scope3_session2.jsp">session2로 이동 </a>
<!--  100을 넣으면 200이 됨 session에 기존의 빈이 살아있기 때문에 -->

