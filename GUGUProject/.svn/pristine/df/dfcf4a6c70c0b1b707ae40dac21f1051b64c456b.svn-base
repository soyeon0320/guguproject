<%@page import="vo.CompanyVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CompanyVO vo = (CompanyVO)request.getAttribute("CompanyVO");
	
	SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String strToday = sdf.format(new java.util.Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 수정</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function insertCheck(){
		if(frm.title.value==""){
			alert("제목을 입력하세요.");
			frm.title.focus();
			return;
		}else if(frm.name.value==""){
			alert("기업명을 입력하세요.");
			frm.name.focus();
			return;
		}else if(frm.career.value==""){
			alert("경력을 입력하세요.");
			frm.career.focus();
			return;
		}else if(frm.educstion.value==""){
			alert("학력을 입력하세요.");
			frm.educstion.focus();
			return;
		}else if(frm.employment.value==""){
			alert("고용형태를 입력하세요.");
			frm.employment.focus();
			return;
		}else if(frm.salary.value==""){
			alert("급여를 입력하세요.");
			frm.salary.focus();
			return;
		}else if(frm.area.value==""){
			alert("지역을 입력하세요.");
			frm.area.focus();
			return;
		}else if(frm.business.value==""){
			alert("산업/업종을 입력하세요.");
			frm.business.focus();
			return;
		}else if(frm.employees.value==""){
			alert("사원 수를 입력하세요.");
			frm.employees.focus();
			return;
		}else if(frm.estab.value==""){
			alert("기업 형태를 입력하세요.");
			frm.estab.focus();
			return;
		}else if(frm.regdate.value==""){
			alert("등록일을 확인해주세요.");
			frm.regdate.focus();
			return;
		}else if(frm.lastdate.value==""){
			alert("종료일을 입력하세요.");
			frm.lastdate.focus();
			return;
		}
		frm.submit();
	}
</script>
<body>
<form name=frm method="post">
	<div class="tab-content">
	    <div class="row">
	        <div class="col-md-6" style="margin-left: 5%; margin-top: 2%;">
	            <div class="main-card mb-3 card">
	                <div class="card-body">
	                	<h3 class="card-title" style="text-align: center;">기업 등록</h3>
	                        <div class="position-relative form-group">
	                		<input type="hidden" value="<%=vo.getCode() %>>" name="code">
	                        	<label>제목</label>
	                        	<input name="title" id="title" type="text" class="form-control" maxlength="330" value="<%=vo.getTitle() %>">
	                        </div>
	             
	                        <div class="position-relative form-group">
								<label>기업명</label>
		                        <input name="name" id="name" type="text" class="form-control" maxlength="330" value="<%=vo.getName() %>">
	                        </div>
	                        
	                        <div class="position-relative form-group" style="width: 45%; float: left;">
								<label>경력</label>
		                        <input name="career" id="career" type="text" class="form-control" maxlength="330" value="<%=vo.getCareer() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: right;">
								<label>학력</label>
		                        <input name="educstion" id="educstion" type="text" class="form-control" maxlength="330" value="<%=vo.getEducstion() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: left;">
								<label>고용형태</label>
		                        <input name="employment" id="employment" type="text" class="form-control" maxlength="330"  value="<%=vo.getEmployment()%>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: right;">
								<label>급여</label>
		                        <input name="salary" id="salary" type="text" class="form-control" maxlength="330" value="<%=vo.getSalary() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: left;" >
								<label>지역</label>
		                        <input name="area" id="area" type="text" class="form-control" maxlength="330" value="<%=vo.getArea() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: right;">
								<label>산업(업종)</label>
		                        <input name="business" id="business" type="text" class="form-control" maxlength="330" value="<%=vo.getBusiness()%>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%;float: left;">
								<label>사원수</label>
		                        <input name="employees" id="employees" type="text" class="form-control" maxlength="3800" value="<%=vo.getEmployees() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 45%; float: right;">
								<label>기업형태</label>
		                        <input name="estab" id="estab" type="text" class="form-control" maxlength="330" value="<%=vo.getEstab() %>">
	                        </div>
	             
	                        <div class="position-relative form-group" style="width: 100%;">
								<label style="margin-left: 2%">홈페이지</label>
		                        <input name="homepage" id="hemepage" type="text" class="form-control" maxlength="650" value="<%=vo.getHomepage() %>">
	                        </div>
	                        
	                        <div class="position-relative form-group" style="width: 45%; float: left;">
								<label>등록일</label>
		                        <input name="regdate" id="regdate" type="text" class="form-control" value=<%=strToday %> readonly="readonly">
	                        </div>
	                        <div class="position-relative form-group" style="width: 45%; float: right; margin-bottom: 2%; margin-top: 4%;">
								<label>마감일</label>
		                       	<input type="datetime-local" name="lastdate" id="lastdate" value="<%=vo.getLastdate()  %>"><br>
	                        </div>
	                        <input type="button" class=" mt-1 btn btn-primary" onclick="insertCheck()" value="등록" style="width: 100%;">
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
 </form>
</body>
</html>