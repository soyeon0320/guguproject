<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.FaqVO"%>
<%@page import="java.util.List"%>
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	List<FaqVO> list = (List<FaqVO>)request.getAttribute("list");
	String msg = request.getParameter("msg") == null? "" : request.getParameter("msg"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description" content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<style type="text/css">
*{clear: both;}
#tableTag{width: 1000px; margin-top: 2%;}
#title{font-size: 40px; margin-left: 40%; margin-top: 3%;}
body{margin-left: 1%; margin-top: 3%;}
</style>
</head>
<body>
	<div class="col-lg-12">
	   <h2 style="text-align: center;">FAQ</h2>
	  <div class="main-card mb-3 card">
	   <div class="card-body">
	  	 <table class="mb-0 table table-hover">
	  	 	<% 
			   int count=1;
			   for(int index=0; index<list.size(); index++){ 
			%> 	
	  	 		<tr>
	  	 			<th>Q</th>
	  	 			<td><%=list.get(index).getQuestion() %></td>
	  	 		</tr>
	  	 		<tr>
	  	 			<th></th>
		  	 		<td><%=list.get(index).getAnswer() %></td>
	  	 		</tr>
		  	 	<%} %>
	  	 </table>
		</div>
	</div>
</div>
	  
	  
	  
	  
	  


</body>
</html>