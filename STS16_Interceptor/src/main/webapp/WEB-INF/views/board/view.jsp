<%-- view.jsp: 개별 행의 내용을 보여주는 화면 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${empty view || fn:length(view) ==0 }">
	
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>
	
	</c:when>
	
	<c:otherwise>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 ${view[0].subject }</title> <!-- title에 글 제목 넣기 -->
</head>

<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("삭제하시겠습니까?"); // 삭제 컨펌 alert 띄움
	if(r){ // r이 true(확인)이면
		location.href = 'deleteOk.do?uid='+uid; //...으로 이동
	}
}
</script>

<body>
<h2>읽기  ${view[0].subject }</h2>
<br>
UID:  ${view[0].uid }<br>
작성자:  ${view[0].name }<br>
제목:  ${view[0].subject }<br>
등록일:  ${view[0].regDate }<br>
조회수:  ${view[0].viewCnt }<br>
내용: <br>
<hr>
<div>
	 ${view[0].content }
</div>
<hr>
<br>
<button onclick="location.href='update.do?uid=${view[0].uid }'">수정하기</button>
<button onclick="location.href='list.do'">목록보기</button>
<button onclick="chkDelete(${view[0].uid })">삭제하기</button>
<button onclick="location.href='write.do'">신규등록</button>


</body>
</html>

	</c:otherwise>
</c:choose>