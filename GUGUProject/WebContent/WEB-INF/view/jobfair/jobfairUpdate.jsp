<%@page import="vo.JobfairVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JobfairVO jobfairVo = (JobfairVO)request.getAttribute("jobfairVo");
	System.out.println(jobfairVo.getJobfairCode());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/GUGUProject/plugins/css/all.min.css">
	<link rel="stylesheet" href="/GUGUProject/dist/css/adminlte.min.css">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<%
//         JobfairVO jobfairVo = (JobfairVO)request.getAttribute("jobfairVo");
// 		String jobfairCode = jobfairVo.getJobfairCode()	;
// 		String jobfairGroup = jobfairVo.getJobfairGroup();	
// 		String jobfairTitle = jobfairVo.getJobfairTitle();
// 		String jobfairStartdate = jobfairVo.getJobfairStartdate();
// 		String jobfairEnddate = jobfairVo.getJobfairEnddate();
// 		String jobfairPlace = jobfairVo.getJobfairPlace();
// 		String companyName = jobfairVo.getCompanyName();
%>
<title>채용설명회 수정</title>
<body>
	<div class="col-lg-12">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title col-lg-12" >취업뉴스 수정</h3>
				<form action="/GUGUProject/jobfair/update.do" method="post" name="frm">
					<table class="mb-0 table table-hover">
						<tr>
				<th>분류</th>
				<td>
					<input type="hidden" name="jobfairCode" value="<%=jobfairVo.getJobfairCode()%>">
					<select name="jobfairGroup">
						<option value="설명회" <%if(jobfairVo.getJobfairGroup().equals("설명회")){ %>selected<%} %>>설명회</option>
						<option value="잡페어" <%if(jobfairVo.getJobfairGroup().equals("잡페어")){ %>selected<%} %>>잡페어</option>
						<option value="상담회" <%if(jobfairVo.getJobfairGroup().equals("상담회")){ %>selected<%} %>>상담회</option>
					</select>
				
				</td>
			</tr>
			<tr>
				<th>설명회명</th>
				<td id="Title"><input type="text" name="jobfairTitle" class="col-md-15 form-control" value="<%=jobfairVo.getJobfairTitle() %>"></td>
			</tr>
			<tr>
				<th>일시</th>
				<td id="Startdate"><input type="text" name="jobfairStartdate" class="col-md-5 form-control" value="<%=jobfairVo.getJobfairStartdate() %>">
				~
				<input type="text" name="jobfairEnddate" class="col-md-5 form-control" value="<%=jobfairVo.getJobfairEnddate() %>"></td>
			</tr>
			<tr>
				<th>장소</th>
				<td id="Place"><input type="text" name="jobfairPlace" class="col-md-5 form-control" value="<%=jobfairVo.getJobfairPlace() %>"></td>
			</tr>			<tr>
				<th>기업명</th>
				<td id="Company"><input type="text" name="companyName" class="col-md-5 form-control" value="<%=jobfairVo.getCompanyName() %>"></td>
			</tr>
			
		</table>
		</form>
			<button type="submit" id="jobfairUpdateBtn" onclick="jobfairUpdate()" class="btn btn-primary">수정완료</button>
				</div>
			</div>
		</div>
			<script>
				function jobfairUpdate(){
				if(frm.jobfairTitle.value=="" || frm.companyName.value==""){
					alert("설명회명과 기업이름은 필수 입력사항입니다.");
					frm.jobfairTitle.focus();
					return;
				}
					
			//	 	frm.location="url";
				//  frm.action="";
					alert("수정 완료");
					frm.submit();
				}
		
			</script>
</body>
</html>