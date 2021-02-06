<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String adminId = (String)session.getAttribute("adminId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<title>FAQ 등록</title>
<script type="text/javascript">
	function insertCheck(){
		if(frm.question.value == ""){
			alert("질문을 입력하세요.");
			frm.question.focus();
			return;
		}else if(frm.answer.value == ""){
			alert("답변을 입력하세요.");
			frm.answer.focus();
			return;
		}
		frm.submit();
	}
	
	function returnFalse(){
		frm.action = "faqList.do";
		frm.submit();
	}
</script>
</head>
<body>
<form name="frm" method="post">
	<div class="container" role="main" style=" width: 45%; float: left; margin-top: 2%; margin-left: 3%;">
		<h2 style="text-align: center; margin-top:2%; margin-bottom: 4% ">FAQ 등록</h2>
		<div class="mb-3">
			<input type="text" class="form-control" name="question" id="question" placeholder="질문을 입력해 주세요">
		</div>
		<div class="mb-3">
			<input type="text" class="form-control" name="adminId" id="adminid" value="<%= adminId%>">
		</div>
		
		<div class="mb-3">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" name="answer" id="answer" placeholder="답변을 입력해 주세요" ></textarea>
		</div>
		
	     <input type="button" class="btn btn-primary" style="margin-right: 2%;" value="등록" onclick="insertCheck();">
	     <input type="button" class="btn btn-primary" style="margin-right: 2%;" value="취소(목록으로 돌아가기)" onclick="returnFalse();">
	</div>
</form>
</body>
</html>