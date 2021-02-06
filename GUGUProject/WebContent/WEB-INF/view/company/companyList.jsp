<%@page import="vo.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	List<CompanyVO> list = (List<CompanyVO>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>기업 목록</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
    	.bs-example{margin: 20px;}
	</style>
</head>
<body>
<div class="row" style="padding: 5%;">
<%
	for(int index = 0 ; index < list.size(); index++){
%> 
	<div class="col-lg-3 col-md-6 col-sm-12 mb-4">
		<div class="card card-small card-post h-100">
<!-- 			<div class="card-post__image" style="background-image: url('images/content-management/7.jpeg');"></div> -->
				<div class="card-body">
	  				<h5 class="card-title">
	    			<a class="text-fiord-blue" href="memberSelect.do?code=<%=list.get(index).getCode()%>"><%=list.get(index).getTitle() %></a></h5>
					<p class="card-text"><%=list.get(index).getCareer() %></p>
				</div>
			<div class="card-footer text-muted border-top py-3">
  				<span class="d-inline-block"><%=list.get(index).getName() %></span>
			</div>
		</div>
	</div>
<%} %>    
</div>
</body>
</html>
