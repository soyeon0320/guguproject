<%@page import="vo.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	CompanyVO vo = (CompanyVO)request.getAttribute("CompanyVO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 상세보기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron jumbotron-fluid" style="padding:3 %;">
  <div class="container">
    <h1><%=vo.getTitle()%></h1>      
  </div>
</div>
<div class="col-md-6" style="float: left; margin-left: 10%;">
    <div class="main-card mb-3 card">
        <div class="card-body">
            <div id="carouselExampleControls1" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="<%=request.getContextPath() %>/assets/img/companyImg/company01.png" alt="First slide" style="height: 650px">
                    </div>
<!--                     <div class="carousel-item"> -->
<%--                         <img class="d-block w-100" src="<%=request.getContextPath() %>/assets/img/companyImg/company02.png" alt="Second slide"> --%>
<!--                     </div> -->
                    <div class="carousel-item">
                        <img class="d-block w-100" src="<%=request.getContextPath() %>/assets/img/companyImg/company03.png" alt="Third slide" style="height: 650px">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls1" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls1" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="container">
	<div class="card border-secondary mb-3" style="max-width: 25rem;">
	  <div class="card-header"><%=vo.getName() %></div>
	  <div class="card-body text-secondary">
	    <p class="card-text"><%=vo.getCareer()%></p>
	    <p class="card-text"><%=vo.getBusiness()%></p>
	    <p class="card-text"><%=vo.getSalary()%></p>
	    <p class="card-text"><%=vo.getArea()%></p>
	    <p class="card-text"><%=vo.getEmployees()%></p>
	    <p class="card-text"><%=vo.getEstab()%></p>
	    <%
	    	String temp = "";
			if(vo.getRegdate() == null || vo.getLastdate() == null || vo.getHomepage()==null){
		%>
			<p class="card-text"><%=temp%></p>
		    <p class="card-text"><%=temp%></p>
		    <p class="card-text"><%=temp %></p>
		<%		
			}else{
		%>
	    <p class="card-text"><%=vo.getRegdate().substring(0,10)%></p>
	    <p class="card-text"><%=vo.getLastdate().substring(0,10)%></p>
	   	<a href="<%=vo.getHomepage()%>"><%=vo.getHomepage()%></a>   
		<%		
			}
	    %>
	  </div>
	</div>
</div>
<a href="modify.do?code=<%=vo.getCode()%>"><button type="button" class="btn btn-primary" style="margin-bottom: 2%;">수정 </button></a>
</body>
</html>