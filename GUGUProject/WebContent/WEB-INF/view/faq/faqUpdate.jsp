<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.FaqVO"%>
<%@page import="java.util.List"%>
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	List<FaqVO> list = (List<FaqVO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAQ 수정</title>
<style>
.container{width: 30%;}
.input-group-addon{width: 100px;}
.buttonAll{margin: 4% 0% 0% 30%;}
.sub_title{ text-align: center; margin-bottom: 3%; margin-top:3%;}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script type="text/javascript">
	function updateCheck(){
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
<h2 class="sub_title">FAQ 수정</h2>
<%
	for(int index = 0; index < list.size(); index++){
%>
<div class="container">

		<div class="container" role="main">
		<div class="mb-3">
			<label for="content">질문</label>
			<input type="text" class="form-control" name="question" id="question" value="<%=list.get(index).getQuestion() %>">
		</div>
		<div class="mb-3">
			<label for="content">작성자</label>
			<input type="text" class="form-control" name="adminId" id="adminid"  value="<%=list.get(index).getAdminId() %>">
		</div>
		
		<div class="mb-3">
			<label for="content">답변</label>
			<textarea class="form-control" rows="5" name="answer" id="answer">
			<%=list.get(index).getAnswer() %>
			
			</textarea>
		</div>
      <input value="<%=list.get(index).getCode() %>" type="hidden" class="form-control" name="code">
		
	</div>
    <div class="buttonAll">
	     <input type="button" class="btn btn-primary" style="margin-right: 5%;" value="수정" onclick="updateCheck();">
	     <input type="button" class="btn btn-primary" style="margin-right: 2%;" value="취소(목록으로 돌아가기)" onclick="returnFalse();">
	</div>
</div>
<%
	}
%>
</form>
</body>
</html>