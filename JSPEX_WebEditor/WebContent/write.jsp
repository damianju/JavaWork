<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>
<script src = "ckeditor/ckeditor.js"></script>
</head>
<script>
function chkSubmit(){// 폼 검증
	frm = document.forms["frm"];
	
	var name = frm["name"].value.trim();
	var subject = frm["subject"].value.trim();
	
	if(name == ""){
		alert("작성자 란은 반드시 입력해야 합니다");
		frm["name"].focus();
		return false;
	}
	if(subject==""){
		alert("제목은 반드시 입력해야 합니다");
		frm["subject"].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>글작성</h2>
<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
작성자:
<input type="text" name="name"/><br>
제목:
<input type="text" name="subject"/><br>
내용:<br>
<textarea name="content" id="editor1"></textarea>
<script>
	CKEDITOR.replace('editor1', {
		allowedContent: true,  // HTML 태그 자동삭제 방지 설정
		width: '640px',  // 최초 너비, 높이 지정 가능
		height: '400px',
		filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.do'
	});
</script>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.do'">목록으로</button>
</body>

</html>