<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId"); 
	String introductionCode = request.getParameter("introductionCode")==null ? "" : request.getParameter("introductionCode");
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
		
		margin-top: 1%;
		width: 100%;
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
	small{
		text-align: right;
	}
	.card-title{
		font-size: 2em;
		text-align: center;
	}
</style>
<body>
	<div class="col-lg-12">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title col-lg-12" >자기소개서 작성</h3>
         		<form action="/GUGUProject/introduction/insert.do" method="post" name="frm">
	             <table class="mb-0 table table-hover">
	              	<tr>
	              		<th >제&nbsp;&nbsp;&nbsp;목</th>
	              		<td id="title"><input type="text" name="title" class="col-md-12 form-control" maxlength="30"></td>
	              	</tr>
	              	<tr>
	              		<th >등록자</th>
	              		<td id="writer"><input type="text" name="writer" class="col-md-2 form-control" maxlength="10"></td>
	              	</tr>
	              	<tr>
	              		<th >등록일</th>
	              		<td id="regDate" name="regDate" style="font-size: 1.5em"></td>
	              	</tr>
	              	<tr>
	              		<th>지원동기</th>
	              		<td colspan="2" style="text-align:justify;">
	              			<textarea id="reason" name="reason" rows="7" cols="" class="col-md-12 form-control" maxlength="1000"></textarea>
	              			<small id="reasenHelp" class="form-text text-muted"></small>
	              		</td>
	              	</tr>
	              	<tr>
	              		<th>성장배경</th>
	              		<td colspan="2" style="text-align: justify;">
	              			<textarea id="growth" name="growth" rows="7" cols="" class="col-md-12 form-control" maxlength="1000"></textarea>
	              			<small id="growthHelp" class="form-text text-muted"></small>
	              		</td>
	              	</tr>
	              	<tr>
	              		<th>경력사항</th>
	              		<td colspan="2" style="text-align: justify;">
	              			<textarea id="career" name="career" rows="7" cols="" class="col-md-12 form-control" maxlength="1000"></textarea>
	              			<small id="careerHelp" class="form-text text-muted"></small>
	              		</td>
	              	</tr>
				</table>
             </div>
             <div id="btns" div style="text-align: center;">
				<button type="button" id="introAddBtn" onclick="introAdd()" class="btn btn-primary">등록</button>
				<button type="button" id="introModifyBtn" onclick="introModify()" class="btn btn-primary">수정하기</button>
				<button type="button" id="goBack" onclick="history.go(-1)" class="btn btn-primary">뒤로가기</button>
				<button type="button" id="requireLoginBtn" onclick="goLogin()" class="btn btn-primary" style="width: 30%;">로그인 후에 이용 가능합니다</button>
			 </div>
			 </form>
          </div>
       </div>

		
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>

<script>
$("#introModifyBtn").hide();
$("#requireLoginBtn").hide();


// 글자 입력할때마다 글자수 세서 데이터 입력
$(function() {
    $('#reason').keyup(function (e){
        var content = $(this).val();
        $('#reasenHelp').html(content.length + '/1000');
	    if(content.length > 1000){
	    	alert("1000자를 초과하였습니다.");
	    }
    });
    $('#reason').keyup();
});
$(function() {
    $('#growth').keyup(function (e){
        var content = $(this).val();
        $('#growthHelp').html(content.length + '/1000');
        if(content.length > 1000){
	    	alert("1000자를 초과하였습니다.");
	    }
    });
    $('#growth').keyup();
});
$(function() {
    $('#career').keyup(function (e){
        var content = $(this).val();
        $('#careerHelp').html(content.length + '/1000');
        if(content.length > 1000){
	    	alert("1000자를 초과하였습니다.");
	    }
    });
    $('#career').keyup();
});

// 오늘 날짜 생성해서 데이터 넣어주기
var date = new Date();
var year = date.getFullYear(); //년도
var month = date.getMonth()+1; //월
var day = date.getDate(); //일
if ((day+"").length < 2) {       // 일이 한자리 수인 경우 앞에 0을 붙여주기 위해
    day = "0" + day;
}
if ((month+"").length < 2) {       // 일이 한자리 수인 경우 앞에 0을 붙여주기 위해
	month = "0" + month;
}
var getToday = year+"-"+month+"-"+day; // 오늘 날짜 (2017-02-07)
$('#regDate').text(getToday);

// 수정화면으로 들어왔을때 데이터 입력
<%if(!introductionCode.equals("")){%>
	$("#introAddBtn").hide();
	$("#introModifyBtn").show();

	$.ajax({
		url:"/GUGUProject/introduction/select.do?introductionCode=<%=introductionCode %>",
		type:"POST",
		dataType:"JSON",
		success: function (data) {
			$("input[name=title]").val(data.title);
			$("input[name=writer]").val(data.writer);
			//$("#regDate").text(data.regDate.substring(0,11));
			$("#reason").text(data.reason);
			$("#growth").text(data.growth);
			$("#career").text(data.career);
		},
		error: function (error) {
			alert("시스템 에러");
		}
	});
<%}%>

function introAdd(){
	if(frm.title.value=="" || frm.writer.value==""){
		alert("제목과 작성자는 필수 입력사항입니다.");
		frm.title.focus();
		return;
	}
	
// 	frm.location="url";
//  frm.action="";
	alert("등록 성공");
	frm.submit();
}

function introModify(){
	if(frm.title.value=="" || frm.writer.value==""){
		alert("제목과 작성자는 필수 입력사항입니다.");
		frm.title.focus();
		return;
	}
	
// 	frm.location="url";
	frm.action="/GUGUProject/introduction/update.do?introductionCode=<%=introductionCode%>";
	frm.submit();
}


	var memberId = "<%=memberId%>";
	if(memberId == ""){
		$("input").attr("readonly","readonly");
		$("textarea").attr("readonly","readonly");
		$("#introAddBtn").hide();
		$("#goBack").hide();
		$("#requireLoginBtn").show();
		
	}
	
	function goLogin() {
		window.parent.location.href="/GUGUProject/login.do";
	}

</script>

</body>
</html>