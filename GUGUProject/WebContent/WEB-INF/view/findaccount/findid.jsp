<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원ID 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.warp{margin-top: 10%; float: none;}
input, button{margin-bottom: 5%;}
#inputKey{margin-top: 5%;}
</style>
</head>
<body>
	<div class="warp container col-xs-5">
		<form class="findPw" method="post" action="findIdGo.do">
		  <div>
			<blockquote class="quote-info">
	     	  <h5>GuGuSystem</h5>
	 			<p class=>아이디 찾기 페이지</p>
			</blockquote>
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" id="inputName" name="memberName" placeholder="회원 이름 입력" autofocus>
		    <input type="text" class="form-control" id="inputPhone" name="memberPhone" placeholder="핸드폰번호 입력">
		    <small id="pheonHelp" class="form-text text-muted">회원 가입시 등록한 핸드폰 번호를 입력하세요</small>
		    <input id="inputKey" type="hidden" class="form-control"  name="memberPhone" placeholder="인증번호 입력">
		    <small id="numHelp" class="form-text text-muted">핸드폰으로 전송된 6자리 번호를 입력하세요</small>
		  </div>
		  <button id="getKey" type="button" class="btn btn-primary btn-block" onclick="goGetKey();">인증번호 받기</button>
		  <button id="checkKey" type="button" class="btn btn-primary btn-block" onclick="goCheckKey();">인증번호 확인</button>
<!-- 		  <input id="next" type=text class="btn btn-primary btn-block" value="다음"> -->
		</form>
	</div>
<script type="text/javascript">
	
	$("#numHelp").hide();
	$("#checkKey").hide();
	$("#next").hide();
	
	var authenicKey = "";
	var memberId = "";
	
	function goGetKey() {
		var params = {
			phoneNum : $("#inputPhone").val(), 
			memberName : $("#inputName").val()		
		};
		//alert(params);
		
		$.ajax({
			url:"getAuthenticationkey.do",
			type:"post",
			data: params,
			dataType: "JSON",
			success: function(data){
				var msg = data.msg;
				if(msg == "success"){
					alert("인증번호가 전송되었습니다.");
					editPage(); // 페이지 모양 바꾸기
					//alert(data.msg);
					
					authenicKey = data.key;
					memberId = data.memberId;
					
				}else{
					alert("입력한 회원정보가 존재하지 않습니다!");
				};
			},
			error: function(error){
				console.log(error);
				alert("작업실패");
			}
			
		});
	}
	
	function editPage() {
		
		$("#getKey").hide();
		$("#numHelp").show();
		$("#checkKey").show();
		$("#inputKey").attr("type", "text");
	}
	
	function goCheckKey() {
		
		if($('#inputKey').val() == authenicKey){
			alert("인증번호가 확인되었습니다.");
			window.location.href = "findIdResult.do?memberId=" + memberId;
			
		}else{
			alert("인증번호가 일치하지 않습니다!");
		}
		
	}
	
</script>
</html>