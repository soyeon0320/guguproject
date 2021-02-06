<%@page import="vo.PagingVO"%>
<%@page import="vo.ResumeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<ResumeVO> resumeList = (List<ResumeVO>)request.getAttribute("resumeList");
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId");
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
<link rel="stylesheet" href="../assets/css/new_main.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<style type="text/css">
	body {
		margin-left: 1%;
		margin-top: 5%;
	}
</style>
<body>
	<div class="row">
	<div class="col-md-12" style="text-align: right;">
		<% if (session.getAttribute("memberId") != null) {	%>
			<a href="insert.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary">
			<i class="bi bi-check2-square"></i> 이력서 등록</button></a>
		<%	} %>
	</div>
	</div>
	<% if(resumeList.size() > 0) { %>
	 	<div class="col-lg-12">
	        <div class="main-card mb-3 card" style="text-align: center;">
	            <div class="card-body"><h5 class="card-title" style="font-size: 25px;">이력서 목록</h5>
	                <table class="mb-0 table table-hover">
	                    <thead style="font-size: 15px;">
	                    <tr>
	                        <th>번호</th>
	                        <th>제목</th>
	                        <th>등록일</th>
	                    </tr>
	                    </thead>
					 	<% for(int idx=0; idx<resumeList.size(); idx++) { %>
						<% if(memberId.equals(resumeList.get(idx).getMemberId())) { %>
	                    <tbody>
						 	<tr>
						 		<td><%= idx+1 %></td>
						 		<td><a href="select.do?code=<%= resumeList.get(idx).getCode() %>"><%= resumeList.get(idx).getTitle() %></a></td>
						 		<td><%= resumeList.get(idx).getRegDate().substring(0, 11) %></td>
						 	</tr>
					 	</tbody>
						 	<% } %>
	   					<% } %>
	   					<% }else { %>
	   					<tr>
    						<td>이력서가 존재하지 않습니다.</td>
    					</tr>
   						<% } %>
	                </table>
	            <br>
			<div style="text-align: center;">
				<ul class="pagination" style="margin-left: 50%;">
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
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>
</html>