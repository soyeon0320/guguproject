<%@page import="vo.BoardManagerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<BoardManagerVO> list = (List<BoardManagerVO>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<title>검색 결과</title>
</head>
<body>
<div class="col-lg-8">
	<div class="main-card mb-3 card">
	    <div class="card-body"><h5 class="card-title">기업 목록</h5>
	        <table class="mb-0 table table-hover">
	            <thead>
	            <tr>
	                <th>글 번호</th>
	                <th>기업명</th>
	                <th>제목</th>
	                <th>고용형태</th>
	                <th>급여</th>
	            </tr>
	            </thead>
	            
		<% for(int index = 0; index < list.size(); index++){%>
	            <tbody>
	            <tr>
	            	<th><%=index+1 %></th>
	                <th><%=list.get(index).getName() %></th>
	                <td><%=list.get(index).getTitle() %></td>
	                <td><%=list.get(index).getEmployment() %></td>
	                <td><%=list.get(index).getSalary() %></td>
	            </tr>
	            </tbody>
		<%} %>
	         </table>
	     </div>
	</div>
</div>
</body>
</html>