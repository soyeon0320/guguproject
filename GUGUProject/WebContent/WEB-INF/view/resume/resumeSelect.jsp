<%@page import="vo.CareerVO"%>
<%@page import="vo.LicenseVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.ResumeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ResumeVO resumeVO = (ResumeVO)request.getAttribute("resumeVO");
	MemberVO memberVO = (MemberVO)request.getAttribute("memberVO");
	List<LicenseVO> licenseList = (List<LicenseVO>)request.getAttribute("licenseList");
	List<CareerVO> careerList = (List<CareerVO>)request.getAttribute("careerList");
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
<title>이력서 상세보기</title>
<body>
	<div class="col-lg-8">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title" style="font-size: 25px; text-align: center;"><%= resumeVO.getMemberId() %>님의 이력서</h3>
	             <table class="mb-0 table table-hover">
		             <tr>
		             	<td colspan="6" style="font-size: 20px; text-align: center;"><%= resumeVO.getTitle() %></td>
		             </tr>
	              	<tr>
						<th colspan="6" style="text-align: center; color: #007acc;">인적사항</th>
					</tr>
					<tr>	
						<th>이름</th>
						<td><%= memberVO.getMemberName()%></td>
						<th>성별</th>
						<% if(memberVO.getMemberGender().equals("M")) { %>
							<td colspan="2">남성</td>
						<% }else { %>
							<td colspan="2">여성</td>
						<% } %>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><%= memberVO.getMemberBirth().substring(0, 11) %></td>
						<th>연락처</th>
						<td colspan="2"><%= memberVO.getMemberPhone() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= memberVO.getMemberEmail() %></td>
						<th>주소</th>
						<td colspan="2"><%= memberVO.getMemberAddr1() %> <%= memberVO.getMemberAddr2() %></td>
					</tr>
					<tr>
						<th colspan="6" style="text-align: center; color: #007acc;">최종 학력</th>
					</tr>
					<tr>
						<th>학교구분</th>
						<td><%= resumeVO.getSchoolSection() %></td>
						<th>학교명</th>
						<td><%= resumeVO.getSchoolName() %></td>
						<th>전공명</th>
						<td><%= resumeVO.getSchoolMajor() %></td>
					</tr>
					<tr>
						<th>기간</th>
						<td><%= resumeVO.getSchoolStartDate().substring(0, 11) %> ~ <%= resumeVO.getSchoolEndDate().substring(0, 11) %></td>
						<th>학점</th>
						<td><%= resumeVO.getSchoolScore() %></td>
						<th>졸업여부</th>
						<td><%= resumeVO.getSchoolEndYn() %></td>
					</tr>
					<% if(licenseList.size() > 0) { %>
						<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">자격증</th>
						</tr>
						<% for(int idx=0; idx<licenseList.size(); idx++) { %>
							<tr>
								<th>자격증명</th>
								<td colspan="2"><%= licenseList.get(idx).getName() %></td>
								<th>취득일</th>
								<td colspan="2"><%= licenseList.get(idx).getGetDate().substring(0, 11) %></td>
							</tr>
						<% } %>
					<% } %>
					<% if(careerList.size() > 0) { %>
						<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">경력</th>
						</tr>
						<% for(int idx=0; idx<careerList.size(); idx++) { %>
							<tr>
								<th>회사명</th>
								<td colspan="2"><%= careerList.get(idx).getCompanyName() %></td>
								<th>부서명</th>
								<td colspan="2"><%= careerList.get(idx).getDepartName() %></td>			
							</tr>
							<tr>
								<th>입사일</th>
								<td colspan="2"><%= careerList.get(idx).getStartDate().substring(0, 11) %></td>
								<th>퇴사일</th>
								<td colspan="2"><%= careerList.get(idx).getEndDate().substring(0, 11) %></td>
							</tr>
							<tr>
								<th>직무명</th>
								<td colspan="2"><%= careerList.get(idx).getJobName() %></td>
								<th>직책명</th>
								<td colspan="2"><%= careerList.get(idx).getPositionName() %></td>
							</tr>
						<% } %>
					<% } %>
				</table>
             </div>
          </div>
       </div>
       <div class="row">
	       <div class="col-md-8" style="text-align: center;">
	      	 <a href="update.do?code=<%= resumeVO.getCode() %>"><button class="mb-2 mr-2 btn-transition btn btn-outline-warning"><i class="bi bi-pencil-square"></i> 이력서 수정</button></a>&emsp;
			 <a href="delete.do?code=<%= resumeVO.getCode() %>"><button class="mb-2 mr-2 btn-transition btn btn-outline-danger"><i class="bi bi-trash"></i> 이력서 삭제</button></a>&emsp;
			 <a href="list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info"><i class="bi bi-list-ol"></i> 이력서 목록</button></a>
			 <button type="button" onclick="addApply()"  class="mb-2 mr-2 btn-transition btn btn-outline-secondary">
			<i class="bi bi-arrow-90deg-left"></i> 관심목록 추가</button>
		   </div>
	   </div>
</body>
<script>
//BYW
function addApply() {
	var params = {
			resumeCode : "<%=resumeVO.getCode() %>", 
			resumeTitle : "<%=resumeVO.getTitle() %>",
			memberId : "<%=memberVO.getMemberId() %>"		
		};
//			alert(params.introTitle);
		
		$.ajax({
			url:"addResumeToApply.do",
			type:"post",
			data: params,
			success: function(data){
				alert("관심페이지에 추가되었습니다.");
				
			},
			error: function(error){
				alert("작업실패");
			}
			
		});
}

</script>
</html>