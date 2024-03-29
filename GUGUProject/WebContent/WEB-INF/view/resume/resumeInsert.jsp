<%@page import="vo.ResumeVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId"); 
	MemberVO memberInfo = (MemberVO)request.getAttribute("memberInfo")==null ? null : (MemberVO)request.getAttribute("memberInfo");
	
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
		margin-left: 5%;
		margin-top: 3%;
	}
	.form-control, .form-select {
 		width: 230px; 
		height: 30px;
	}
	#licenseAdd, #careerAdd {
		float: right;
	}
	span {
		color: red;
	}
	#resumeTitle {
		width: 100%;
		height: 40px;
	}
</style>
<script type="text/javascript">
	//자격증 추가
	function licenseAddFn() {
		if($('input[name=licenseName]').length >= 5) {
			alert("자격증은 최대 5개까지만 입력이 가능합니다.");
			return;
		}		
		$("table tbody[id=lincesTbody]").append(
			'<tr>'
				+ '<th><span>*</span> 자격증명</th>'
				+ '<td> <input class="form-control" type="text" id="licenseName" name="licenseName" value=""> </td>'
				+ '<th><span>*</span> 취득일</th>'
				+ '<td> <input class="form-control" type="text" id="licenseGetDate" name="licenseGetDate" value=""> </td>'
				+ '<td> <button id="licenseDeleteBt" class="mb-2 mr-2 btn-transition btn btn-outline-danger"><i class="bi bi-trash"></i> 자격증 삭제</button></td>'
			+ '</tr>'
		);
	}
	
	//자격증 삭제
	//동적으로 생성된 태그 이벤트 추가
	$(document).on("click", "#licenseDeleteBt", function(){
		$(this).parents("tr").remove();
	});
	
	//경력 추가
	var trIndex = 0;
	function careerAddFn() {
		if($('input[name=companyName]').length >= 3) {
			alert("경력사항은 최대 3개까지만 입력이 가능합니다.");
			return;
		}
		//tr을 구분할 수 있는 클래스의 index 선언
		$("table tbody[id=careerTbody]").append(
			'<tr class="careerTr'+trIndex+'">'
				+ '<th><span>*</span> 회사명</th>'
				+ '<td> <input class="form-control" type="text" id="companyName" name="companyName" value=""> </td>'
				+ '<th><span>*</span> 부서명</th>'
				+ '<td> <input class="form-control" type="text" id="departName" name="departName" value=""> </td>'
				+ '<td> </td>'
			+ '</tr>'
			+ '<tr class="careerTr'+trIndex+'">'
				+ '<th><span>*</span> 입사일</th>' 
				+ '<td> <input class="form-control" type="date" id="careerStartDate" name="startDate" value=""> </td>'
				+ '<th><span>*</span> 퇴사일</th>'
				+ '<td> <input class="form-control" type="date" id="careerEndDate" name="endDate" value=""> </td>'
				+ '<td> </td>'
			+ '</tr>'
			+ '<tr class="careerTr'+trIndex+'">'
				+ '<th> 직무명</th>' 
				+ '<td> <input class="form-control" type="text" id="jobName" name="jobName" value=""> </td>'
				+ '<th> 직책명</th>'
				+ '<td> <input class="form-control" type="text" id="positionName" name="positionName" value=""> </td>'
				//현재 클래스의 index에 해당하는 값을 파라미터로 지정
				+ '<td> <button onclick="careerDeleteFn(' + trIndex + ')" class="mb-2 mr-2 btn-transition btn btn-outline-danger"><i class="bi bi-trash"></i> 경력 삭제</button> </td>'
			+ '</tr>'
		//다음 tr의 클래스를 구분할 수 있게 index 증가
		);
		trIndex++;
	}
	
	//경력 삭제
	function careerDeleteFn(trIndex) {
		$("#careerTbody tr.careerTr"+trIndex).remove();
	}
	
	//학교 구분 값에 따라 전공명과 학점의 속성 변경
	$(function(){
		$("#schoolSection").on("change", function(){
			var schoolSection = $(this).val();
			if(schoolSection=="초등학교" || schoolSection=="중학교" || schoolSection=="고등학교") {
				$("#schoolMajor").attr("readonly", "readonly");
				$("#schoolScore").attr("readonly", "readonly");
			}
			if(schoolSection=="대학교" || schoolSection=="대학원") {
				$("#schoolMajor").removeAttr("readonly");
				$("#schoolScore").removeAttr("readonly");
			}
		});
	});
	
	//오늘 날짜에 따라 졸업 여부 처리
	$(function(){
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth() + 1;
		var date = today.getDate();
		var currentDate = year + "-0" + month + "-" + date;
		$("#schoolEndDate").on("change", function(){
			if($(this).val() > currentDate) {
				$("#schoolEndY").attr("disabled", true);
				$("#schoolEndY").attr("checked", false);
			}else {
				$("#schoolEndY").attr("disabled", false);
			}
		});
	});
	
	//이력서 등록
	function licenseReg(){
		if($("#resumeTitle").val().trim()=="") {
			alert("제목을 입력해주세요.");
			$("#resumeTitle").focus();
			return;
		}
		
		if($("#schoolSection").val().trim()=="") {
			alert("학교 구분을 선택해주세요.");
			return;
		}
		
		if($("#schoolName").val().trim()=="") {
			alert("학교명을 입력해주세요.");
			$("#schoolName").focus();
			return;
		}	
		
		var schoolStartDate = $("#schoolStartDate").val().trim();
		if(schoolStartDate==""){
			alert("입학일를 입력해주세요.");
			$("#schoolStartDate").focus();
			return;
		}
		
		var schoolEndDate = $("#schoolEndDate").val().trim();
		if(schoolEndDate==""){
			alert("졸업일를 입력해주세요.");
			$("#schoolEndDate").focus();
			return;
		}

		//입학일와 졸업일 비교
		 var schoolStartArr = schoolStartDate.split('-');
		 var schoolEndArr = schoolEndDate.split('-');
		 var schoolStartDate = new Date(schoolStartArr[0], schoolStartArr[1], schoolStartArr[2]);
		 var schoolEndDate = new Date(schoolEndArr[0], schoolEndArr[1], schoolEndArr[2]);
		 if(schoolStartDate.getTime() > schoolEndDate.getTime()) {
			 alert("입학일는 졸업일보다 클 수가 없습니다.");
			 return false;
		 }
		
		if(!$('input[name="schoolEndYn"]').is(":checked")) {
			alert("졸업 여부를 선택해주세요.");
			return;
		}
		
		if($("#schoolSection").val()=="대학교" || $("#schoolSection").val()=="대학원") {
			if($("#schoolMajor").val()=="") {
				alert("전공명을 입력해주세요.");
				$("#schoolMajor").focus();
				return;
			}
			var schoolScore = $("#schoolScore").val().trim();
			if(schoolScore=="") {
				alert("학점을 입력해주세요.");
				$("#schoolScore").focus();
				return;
			}			
			//숫자 판별
			if(!$.isNumeric(schoolScore)) {
				alert("학점은 숫자만 입력이 가능합니다.");
				$("#schoolScore").focus();
				return;
			}
			//숫자 범위 체크
			if(schoolScore > 4.5){
				alert("학점은 최대 4.5점 입니다.");
				return;
			}
		}	
		
		//전송 처리
		resumeFm.submit();
		alert("<%= memberInfo.getMemberName() %>님, 이력서 등록에 성공하셨습니다!");
	}
</script>
<body>
	<div class="col-lg-8">
    	<div class="main-card mb-2 card">
         	<div class="card-body">
         		<h3 class="card-title" style="font-size: 25px; text-align: center;">이력서 등록</h3>
         		<div style="text-align: right;">
         			<button class="mb-2 mr-2 btn-transition btn btn-outline-success" onclick="licenseAddFn()" name="licenseAdd">
					<i class="bi bi-pencil"></i> 자격증 추가</button>
					<button class="mb-2 mr-2 btn-transition btn btn-outline-success" onclick="careerAddFn()" name="careerAdd">
					<i class="bi bi-pencil"></i> 경력 추가</button>
				</div>
				<form name="resumeFm" action="insert.do" method="post">
				<input type="hidden" id="memberId" name="memberId" value="<%= memberInfo.getMemberId() %>">
		             <table class="mb-0 table table-hover" id="resumeTable">
		             	<tr>
							<th colspan="6" style="text-align: center; color: #007acc;"><span>*</span> 제목</th>
						</tr>
						<tr>
							<td colspan="6">
								<input class="form-control" type="text" id="resumeTitle" name="title" value="">
							</td>
						</tr>
					 	<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">인적사항</th>
						</tr>
							<tr>
							<th>이름</th>
							<td>
							<input type="hidden" id="memberName" name="memberName" value="<%= memberInfo.getMemberName() %>">
							<%= memberInfo.getMemberName() %>
							</td>
							<th>성별</th>
							<td colspan="2">
							<input type="hidden" id="memberGender" name="memberGender" value="<%= memberInfo.getMemberGender() %>">
							<%= memberInfo.getMemberGender() %>
							</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>
							<input type="hidden" id="memberBirth" name="memberBirth" value="<%= memberInfo.getMemberBirth().substring(0, 11) %>">
							<%= memberInfo.getMemberBirth().substring(0, 11) %>
							</td>
							<th>연락처</th>
							<td colspan="2">
							<input type="hidden" id="memberPhone" name="memberPhone" value="<%= memberInfo.getMemberPhone() %>">
							<%= memberInfo.getMemberPhone() %>
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
							<input type="hidden" id="memberEmail" name="memberEmail" value="<%= memberInfo.getMemberEmail() %>">
							<%= memberInfo.getMemberEmail() %>
							</td>
							<th>주소</th>
							<td colspan="2">
							<input type="hidden" id="memberAddr1" name="memberAddr1" value="<%= memberInfo.getMemberAddr1() %>">
							<input type="hidden" id="memberAddr2" name="memberAddr2" value="<%= memberInfo.getMemberAddr2() %>">
							<%= memberInfo.getMemberAddr1() %> <%= memberInfo.getMemberAddr2() %>
							</td>
						</tr>
						<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">최종 학력</th>
						</tr>
						<tr>
							<th><span>*</span> 학교구분</th>
							<td>
							<select class="form-select form-select-sm" id="schoolSection" name="schoolSection">
							    <option selected value="">---선택---</option>
							    <option value="초등학교">초등학교</option>
							    <option value="중학교">중학교</option>
							    <option value="고등학교">고등학교</option>
							    <option value="대학교">대학교</option>
							    <option value="대학원">대학원</option>
							</select>
							</td>
							<th><span>*</span> 학교명</th>
							<td colspan="2">
								<input class="form-control" type="text" id="schoolName" name="schoolName" value="">
							</td>
						</tr>
						<tr>
							<th><span>*</span> 기간</th>
							<td>
	 							<input class="form-control" type="date" id="schoolStartDate" name="schoolStartDate" value="" style="width: 180px; display: inline-block;"> ~ 
	 							<input class="form-control" type="date" id="schoolEndDate" name="schoolEndDate" value="" style="width: 180px; display: inline-block;"> 
							</td>
							<th><span>*</span> 졸업여부</th>
							<td colspan="2">
								<label for="schoolEndY">
								<input type="radio" id="schoolEndY" name="schoolEndYn" value="Y" > Y&emsp;
								</label>
								<label for="schoolEndN">
								<input type="radio" id="schoolEndN" name="schoolEndYn" value="N"> N 
								</label>
							</td>
						</tr>
						<tr>
							<th>전공명</th>
							<td>
								<input class="form-control" type="text" id="schoolMajor" name="schoolMajor" value="">
							</td>
							<th>학점</th>
							<td colspan="2">
								<input class="form-control" type="text" id="schoolScore" name="schoolScore" value="" style="width: 70px;">
							</td>
						</tr>
						<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">자격증</th>
						</tr>
						<tbody id="lincesTbody">
							
						</tbody>
						<tr>
							<th colspan="6" style="text-align: center; color: #007acc;">경력</th>
						</tr>
						<tbody id="careerTbody">
							
	 					</tbody>
	 					<tr>
	 						<td colspan="8" style="text-align: center;">
	 							<button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary" onclick="licenseReg()">
								<i class="bi bi-check2-square"></i> 이력서 등록</button>
								<a href="list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info">
								<i class="bi bi-list-ol"></i> 이력서 목록</button></a>
	 						</td>
	 					</tr>
					</table>
				</form>
             </div>
          </div>
       </div>
</body>
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>
</html>