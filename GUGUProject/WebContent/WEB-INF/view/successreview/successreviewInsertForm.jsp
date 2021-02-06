<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId"); 
	String successReviewCode = request.getParameter("successReviewCode")==null ? "" : request.getParameter("successReviewCode");
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
		width: 20%;
	}
	th{
		width: 15%;
		text-align: center;
		font-size: 1.2em;
	}
	small{
		text-align: right;
		font-size: 0.5em;
	}
	.card-title{
		font-size: 2em;
		text-align: center;
	}
</style>
<body>
	<div class="col-lg-12" >
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title col-lg-12" >취업후기 작성</h3>
         		<form action="/GUGUProject/successReview/insert.do" method="post" name="frm">
	             <table class="mb-0 table table-hover">
	              	<tr>
	              		<th style="">제   목</th>
	              		<td id="title"><input type="text" name="title" class="col-md-12 form-control" maxlength="30"></td>
	              	</tr>
	              	<tr>
	              		<th >작성자</th>
	              		<td id="regName"><input type="text" name="regName" class="col-md-2 form-control" maxlength="10"></td>
	              	</tr>
	              	<tr>
	              		<th >등록일</th>
	              		<td id="regDate" name="regDate" style="font-size: 1.5em"></td>
	              	</tr>
	              		<th>내   용</th>
	              		<td colspan="2" style="text-align: justify; font-size: 3em;">
	              			<textarea id="content" name="content" rows="17" cols="" class="col-md-12 form-control" maxlength="1300"></textarea>
	              			<input type="hidden" name="imgSrc" value="">
	              			<small id="contentHelp" class="form-text text-muted">최대 1300자 까지 입력가능합니다.</small>
	              		</td>
	              	</tr>
				</table>
             </div>
             <div id="btns" div style="text-align: center;">
				<button type="button" id="SRAddBtn" onclick="SRAdd()" class="btn btn-primary">등록</button>
				<button type="button" onclick="history.go(-1)" class="btn btn-primary">뒤로가기</button>
<!-- 				<button type="button" id="SRModifyBtn" onclick="SRModify()" class="btn btn-primary">수정하기</button> -->
			 </div>
			 </form>
          </div>
       </div>

		
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>

<script>
// 글자수 세기
$(function() {
    $('#content').keyup(function (e){
        var content = $(this).val();
        $('#contentHelp').html(content.length + '/1300');
	    if(content.length > 1300){
	    	alert("1300자를 초과하였습니다.");
	    }
    });
    $('#content').keyup();
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
<%if(!successReviewCode.equals("")){%>
	$("#SRAddBtn").html("수정하기").attr("onclick", "SRModify()");
	

	$.ajax({
		url:"/GUGUProject/successReview/select.do?successReviewCode=<%=successReviewCode %>",
		type:"POST",
		dataType:"JSON",
		success: function (data) {
			$("input[name=title]").val(data.title);
			$("input[name=regName]").val(data.regName);
			//$("#regDate").text(data.regDate.substring(0,11));
			$("#content").text(data.content);
			
		},
		error: function (error) {
			alert("시스템 에러");
		}
	});
<%}%>

function SRAdd(){
	if(frm.title.value=="" || frm.regName.value==""){
		alert("제목과 작성자는 필수 입력사항입니다.");
		frm.title.focus();
		return;
	}
	
// 	frm.location="url";
//  frm.action="";
	alert("등록 성공");
	frm.submit();
}

function SRModify(){
	if(frm.title.value=="" || frm.regName.value==""){
		alert("제목과 작성자는 필수 입력사항입니다.");
		frm.title.focus();
		return;
	}
	
// 	frm.location="url";
	frm.action="/GUGUProject/successReview/update.do?successReviewCode=<%=successReviewCode%>";
	frm.submit();
}

</script>

</body>
</html>