<%@page import="vo.NotisVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NotisVO> list = (List<NotisVO>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<title>관리자 FAQ</title>
<style type="text/css">
#tableTag{
	margin-left: 1%;
	margin-top: 2%;
}

</style>
</head>
<body>

<div class="col-lg-12">
	<div class="main-card mb-3 card" id="tableTag">
		<div class="card-body">
			<h1 class="card-title" style="font-size: 25px; text-align: center;">공지사항</h1>
			<table class="mb-0 table table-hover">
				<thead>
					<tr>
						<th style="width: 3%">번호</th>
						<th style="width: 18%">제목</th>
						<th>내용</th>
						<th style="width: 6%">등록일</th>
						<th>작성자</th>
					</tr>
				</thead>

				<%
					int count = 1;
					for(int index = 0; index < list.size(); index++){
				%>
						<input type="hidden" value="<%=list.get(index).getCode()%>">
				<tbody>
					<tr>
						<td scope="col" style="text-align: center;"><%=count %></td>
						<td scope="col"><%=list.get(index).getTitle() %></td>
						<td scope="col"><%=list.get(index).getContent() %></td>
						<td scope="col"><%=list.get(index).getRegDate().substring(0, 10) %></td>
						<td scope="col"><%=list.get(index).getAdminId() %></td>
					</tr>
				</tbody>
				<% count++; } %>
			</table>
		</div>
	</div>
</div>
</body>
</html>