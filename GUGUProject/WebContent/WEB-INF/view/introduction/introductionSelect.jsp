<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId"); 
	String introductionCode = request.getParameter("introductionCode")==null ? "" : request.getParameter("introductionCode"); 
	String msg = request.getParameter("msg")==null ? "" : request.getParameter("msg"); 
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<style type="text/css">
	body {
		margin-left: 0%;
		margin-top: 0%;
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
	.card-body{
		height: 100%;
		
	}
	.col-lg-12{
		padding-left: 0; padding-right: 0;
	}

	.card-title{
		font-size: 2em;
		margin-left: 15%; 		
	}
</style>
<body>
		<div class="col-md-12" style="text-align: right;">
			<a href="/GUGUProject/introduction/list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary"><i class="bi bi-check2-square"></i> 목록으로</button></a>
		</div>
	<div class="col-lg-12">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title" style="font-size: 20px;">자기소개서 세부 내용</h3>
         		<div style="white-space: pre-wrap;">
	             <table class="mb-0 table table-hover">
	              	<tr>
	              		<th >제목</th>
	              		<td id="title" name="title"></td>
	              	</tr>
	              	<tr>
	              		<th >등록자</th>
	              		<td id="writer"></td>
	              	</tr>
	              	<tr>
	              		<th >등록일</th>
	              		<td id="regDate"></td>
	              	</tr>
	              	<tr>
	              		<th>지원동기</th>
	              		<td id="reason" colspan="2" style="text-align:justify;">
	              	</tr>
	              	<tr>
	              		<th>성장배경</th>
	              		<td id="growth" colspan="2" style="text-align: justify;">
	              		</td>
	              	</tr>
	              	<tr>
	              		<th>경력사항</th>
	              		<td id="career" colspan="2" style="text-align: justify;">
	              		</td>
	              	</tr>
				</table>
				</div>
             </div>
             <div id="btns" div style="text-align: center;">
				<a href="/GUGUProject/introduction/insertForm.do?from=modify&code=<%=introductionCode %>"><button type="button" class="btn btn-success">수정</button></a>
				<button type="button" class="btn btn-warning" onclick="deleteIntro()">삭제</button>
				<button type="button" class="btn btn-primary" onclick="addApply()">관심추가</button>
			 </div>
          </div>
       </div>

		
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>

<script>
	$.ajax({
		url:"/GUGUProject/introduction/select.do?introductionCode=<%=introductionCode %>",
		type:"POST",
		dataType:"JSON",
		success: function (data) {
			$("#title").text(data.title);
			$("#writer").text(data.writer);
			$("#regDate").text(data.regDate.substring(0,11));
			$("#reason").text(data.reason);
			$("#growth").text(data.growth);
			$("#career").text(data.career);
		},
		error: function (error) {
			alert("시스템 에러");
		}
	});

	var memberId = "<%=memberId%>";
	if(memberId != ""){
		$("#btns").show();
	}else{
		$("#btns").hide();
	}
	
	var msg = "<%=msg%>";
	if(msg == "success"){
		alert("자기소개서 수정 성공");
	}
	
	function deleteIntro(event) {
		if(confirm("정말 삭제하시겠습니까?")){
			alert("삭제되었습니다");
			location.href ='/GUGUProject/introduction/delete.do?introductionCode=<%=introductionCode %>';
		}else{
			return;
		}
	}
	
	function addApply() {
		var params = {
				introCode : "<%=introductionCode %>", 
				introTitle : $("td[name=title]").text(),
				memberId : "<%=memberId %>"		
			};
// 			alert(params.introTitle);
			
			$.ajax({
				url:"addIntroToApply.do",
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

</body>
</html>