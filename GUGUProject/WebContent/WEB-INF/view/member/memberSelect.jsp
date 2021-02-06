<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MemberVO memberVO = (MemberVO)request.getAttribute("memberVO");
%>
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
		margin-left: 1%;
		margin-top: 3%;
	}
	button {
		margin: 2%;
		width: 15%;
	}
	th{
		width: 15%;
		text-align: center;
		font-size: 1.2em;
	}
	tr{
		height: 70px;
	}
	.card-body{
		height: 100%;
		width: 50%; 
	}
	body::-webkit-scrollbar {
   		display: none; 
	}
	.col-lg-12{
		padding-left: 0; padding-right: 0;
	}

	.card-title{
		height: 100px;
		font-size: 2em;
 		padding-top: 30px; 
		text-align: center; 
/* 		vertical-align: middle; */
	}
	#btns{
		height:150px;
	}
	.card-body{
		height: 100%;
		width: 100%; 
	}
	
</style>
<body>
	<div class="col-lg-6"  style="width: 100%;">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title"><%= memberVO.getMemberName() %>님의 회원 정보</h3>
	             <table class="mb-0 table table-hover">
	              	<tr>
	              		<th>아이디</th>
	              		<td><%= memberVO.getMemberId() %></td>
	              	</tr>
	              	<tr>
	              		<th>성별</th>
	              		<td><%= memberVO.getMemberGender() %></td>
	              	</tr>
	              	<tr>
	              		<th>연락처</th>
	              		<td><%= memberVO.getMemberPhone() %></td>
	              	</tr>
	              	<tr>
	              		<th>이메일</th>
	              		<td><%= memberVO.getMemberEmail() %></td>
	              	</tr>
	              	<tr>
	            	  		<th>주소</th>
	              		<td><%= memberVO.getMemberAddr1() %> <%= memberVO.getMemberAddr2() %></td>
	              	</tr>
	              	<tr>
	              		<th>생일</th>
	              		<td><%= memberVO.getMemberBirth().substring(0, 11) %></td>
	              	</tr>
	              	<tr>
	              		<th style="width: 25%">회원탈퇴여부</th>
	              		<td id="tdState"><%= memberVO.getMemberQuit() %></td>
	              	</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
							<a href="list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info"><i class="bi bi-list-ol"></i> 회원 목록</button></a>
							<button id="toggleState" class="mb-2 mr-2 btn-transition btn btn-outline-warning" onclick="goMemberDelete()"><i class="bi bi-arrow-90deg-left"></i> 휴면회원전환</button></a>
						</td>
					</tr>
				</table>
             </div>
          </div>
       </div>
</body>
<script>
var params = {"memberId" : "<%= memberVO.getMemberId() %>"};

function goMemberDelete() {
	if(confirm("휴면회원으로 등록하시겠습니까?")){
		$.ajax({
			url : "deleteFromAdmin.do",
			type : "post",
			data : params,
			success:function(result){
				alert("휴면회원으로 전환되었습니다.");
				$("#toggleState").attr("onclick", "forgiveThisMember()");
				$("#toggleState").html("<i class='bi bi-list-ol'></i>휴면회원복구");
				$("#tdState").text("Y");
				
			},
			error:function(error){
				alert("작업실패");
				console.log(error);
			}
		});
	}else{
		return;
	}
}
function forgiveThisMember() {
	if(confirm("회원계정을 복구하시겠습니까?")){
		$.ajax({
			url : "forgiveMember.do",
			type : "post",
			data : params,
			success:function(result){
				alert("복구되었습니다.");
				$("#toggleState").attr("onclick", "goMemberDelete()");
				$("#toggleState").html("<i class='bi bi-list-ol'></i>휴면회원전환");
				$("#tdState").text("N");
			},
			error:function(error){
				alert("작업실패");
				console.log(error);
			}
		});
	}else{
		return;
	}
}


<%if(memberVO.getMemberQuit().equals("Y")){%>
	$("#toggleState").attr("onclick", "forgiveThisMember()");
	$("#toggleState").html("<i class='bi bi-list-ol'></i>휴면회원복구");

<%}%>
</script>

</html>