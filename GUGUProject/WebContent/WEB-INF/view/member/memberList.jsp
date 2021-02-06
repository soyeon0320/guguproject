<%@page import="vo.PagingVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
	PagingVO pageVO = (PagingVO)request.getAttribute("pageVO");
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<style type="text/css">
	body {
		margin-left: 5%;
		margin-top: 3%;
	}
</style>
<body>
	<div class="row">
		<div class="col-md-6">전체 <%=pageVO.getTotalCount()%>건&emsp;</div>
	</div>
	<div class="col-lg-6">
		<div class="main-card mb-3 card" style="text-align: center;">
			<div class="card-body">
				<h1 class="card-title" style="font-size: 25px;">회원 목록</h1>
				<table class="mb-0 table table-hover">
					<thead style="font-size: 15px;">
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>연락처</th>
							<th>이메일</th>
						</tr>
					</thead>
		<% if (memberList.size() > 0) {
				for (int idx = 0; idx < memberList.size(); idx++) { %>
					<tbody>
						<tr>
							<td scope="row"><%=idx + 1%></td>
							<td scope="row"><a href="select.do?memberId=<%= memberList.get(idx).getMemberId() %>">
								<%= memberList.get(idx).getMemberId() %>
							</a></td>
							<td scope="row"><%= memberList.get(idx).getMemberName() %></td>
							<td scope="row"><%= memberList.get(idx).getMemberPhone() %></td>
							<td scope="row"><%= memberList.get(idx).getMemberEmail() %></td>
						</tr>
					</tbody>
					<% } %>
		<% } else { %>
			<tr>
				<td>회원이 존재하지 않습니다.</td>
			</tr>
		<% } %>
			</table>
			<br>
			<div style="text-align: center;">
				<ul class="pagination" style="margin-left: 300px;">
					<% if(pageVO.getTotalCount() > 0){//1 %>
						<% if(pageVO.getFirstPageNo() > pageVO.getPageSize()) {//2 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pageVO.getFirstPageNo()-1 %>">[&lt;]</a></li>
						<% }//2 %>
						<% for(int pNo=pageVO.getFirstPageNo(); pNo<=pageVO.getLastPageNo(); pNo++){//3 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pNo %>"><%= pNo %></a></li>
						<% }//3 %>
						<% if(pageVO.getLastPageNo() < pageVO.getTotalPageCount()){//4 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pageVO.getFirstPageNo() + pageVO.getPageSize() %>">[&gt;]</a></li>
						<% }//4 %>
				</ul>
					<% }//1 %>
			</div>
			</div>
		</div>
	</div>
</body>
</html>