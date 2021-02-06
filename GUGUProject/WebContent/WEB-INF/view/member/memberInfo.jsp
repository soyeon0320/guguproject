<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	String memberId = (String) session.getAttribute("memberId");
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>회원정보 페이지</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- 부가적인 테마 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
	
</style>
<script type="text/javascript">
/**
 * BYW
 */
var params = {"memberId" : "<%=memberId %>"};

$.ajax({
	url:"getMemberInfo.do",
	type:"post",
	data: params,
	dataType: "JSON",
	success: function(data){
		//alert("회원정보 가져오기 성공");
		printData(data);
	},
	error: function(error){
		console.log(error);
		alert("회원정보 가져오기 실패");
	}
});

var gender = "";
function printData(data) {
	$("#memberId").text(data.memberId);
	$("#memberName").text(data.memberName);
	$("#memberGender").text(data.memberGender);
	$("#memberBirth").text(data.memberBirth.substring(0, 11));
	$("#memberEmail").text(data.memberEmail);
	$("#memberPhone").text(data.memberPhone);
	$("#memberAddr1").text(data.memberAddr1);
	$("#memberAddr2").text(data.memberAddr2);
	
	gender = data.memberGender;
	if(gender == "M"){
		$("#gender").html("남성");
	}else {
		$("#gender").html("여성");
	}
}

/**
 * KSY + BYW 
 */
function deleteFm() {
	if(confirm("정말 탈퇴하시겠습니까?\n(같은 아이디로 재가입 할 수 없으며 작성한 모든 문서에 대한 권한을 상실합니다!)")){
		$.ajax({
			url : "delete.do",
			type : "post",
			data : params,
			success:function(result){
				alert("회원 탈퇴에 성공하셨습니다!");
				window.parent.location.href= "<%= request.getContextPath() %>/index.do";
			},
			error:function(error){
				alert("회원 탈퇴에 실패하셨습니다.");
				console.log(error);
			}
		});
	}else{
		return;
	}
	
}


</script>
<body>
<div class="col-lg-12">
    	<div class="main-card mb-3 card" style="width:50%;">
         	<div class="card-body">
         		<h3 class="card-title">회 원 정 보</h3>
	             <table class="mb-0 table table-hover">
	              	<tr style="">
	              		<th>아이디</th>
	              		<td id="memberId"></td>
	              	</tr>
	              	<tr>
	              		<th>이름</th>
	              		<td id="memberName"></td>
	              	</tr>
	              	<tr>
	              		<th>성별</th>
	              			<td id="gender">남성</td>
	              	</tr>
	              	<tr>
	              		<th>연락처</th>
	              		<td id="memberPhone"></td>
	              	</tr>
	              	<tr>
	              		<th>이메일</th>
	              		<td id="memberEmail"></td>
	              	</tr>
	              	<tr>
	              		<th>주소</th>
	              		<td id="memberAddr1">&emsp;<span id="memberAddr2"></span></td>
	              	</tr>
	              	<tr>
	              		<th>생일</th>
	              		<td id="memberBirth"></td>
	              	</tr>
					<tr id="btns">
						<td colspan="2" style="text-align: center;">
							<a href="update.do?memberId=<%= memberId %>"><button class="mb-2 mr-2 btn-transition btn btn-outline-warning">
							<i class="bi bi-pencil-square"></i> 회원 수정</button></a>
							<button class="mb-2 mr-2 btn-transition btn btn-outline-danger" onclick="deleteFm()">
							<i class="bi bi-trash"></i> 회원 탈퇴</button>
						</td>
					</tr>
				</table>
             </div>
          </div>
       </div>
</body>
</html>