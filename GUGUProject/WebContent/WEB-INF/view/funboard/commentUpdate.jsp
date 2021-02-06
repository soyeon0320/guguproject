<%@page import="vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String commentCode = (String)request.getAttribute("commentCode");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<h3>댓글 수정</h3>
	<form id="cmntUpdateFm" action="commentUpdate.do" method="post">
		<input type="hidden" name="commentCode" value="<%= commentCode %>">
		<input type="text" name="content" value="">
		<input type="submit" value="댓글 등록">
	</form>
</body>
</html>