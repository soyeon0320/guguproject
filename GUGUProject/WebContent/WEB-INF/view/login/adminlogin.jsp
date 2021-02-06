<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.MemberVO"%>
<%
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	String adminId = session.getAttribute("adminId") == null ? "" : (String) session.getAttribute("adminId");
	String adminName = session.getAttribute("adminName") == null ? "" : (String) session.getAttribute("adminName");

	String rememberId = "";

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("adminId")) {
				rememberId = cookie.getValue();
			}
		}
	}
%>
<!doctype html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>관리자 로그인</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="Inline validation is very easy to implement using the Architect Framework.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.input-group{width: 40%;margin: 2%;}
.logIn{margin-left: 35%; margin-top: 5%;}
.buttonTwo{width: 40%;margin: 2%;}
.rememberId{padding-left: 2%; font-weight:bold;}
label{width:40%;}
.checkbox{border-bottom: 1px solid grey; padding-bottom: 5%;  margin-top: 5%;}
.divBottom{text-align: center;}
#bar{margin: 2%}
</style>
<style type="text/css">
</style>
</head>
<body>
	<%
		if (adminId != "") {
	%>
<div class="logIn">
	<div class="buttonTwo">
		<blockquote class="quote-info">
			<h5>GuGuSystem</h5>
			<p class=><%=adminName%>님 환영합니다!
			</p>
		</blockquote>
		<button type="button" onclick="goHome()" class="btn btn-primary btn-block">홈으로</button>
	</div>
</div>
	<%
		} else if (msg.equals("fail")) {
	%>
<script>
	alert("입력한 관리자정보가 맞지않습니다.");
</script>

<form class="logIn" method="post" action="goAdminLogin.do">
	<div class="buttonTwo">
		<blockquote class="quote-warning">
			<p>관리자 로그인 페이지입니다.</p>
		</blockquote>
	</div>
   	<div class="input-group">
   	<%
   		if(!rememberId.equals("")){
   			%><input id="adminId" type="text" class="form-control" name="adminId" placeholder="ID" value="<%=rememberId%>" required="true"> <%
   		}else{
   			%><input id="adminId" type="text" class="form-control" name="adminId" placeholder="ID" required="true"><%
   		}
   	%>
	</div>
	
	<div class="input-group">
		<input id="password" type="password" class="form-control" name="adminPw" placeholder="Password" required="true">
	</div>
		
	<div class="buttonTwo">
		<input type="submit" class="btn btn-primary btn-block" value="로그인">
		<div class="checkbox">
			<label>
				<input type="checkbox" name="rememberId" value="rememberId" >
				<span class="rememberId">아이디 저장</span>
			</label>
			<br>
		</div>
		<div class="divBottom">
			<a href="index.do">홈으로</a>
		</div>
	</div>
</form>
	<%
		} else if (msg.equals("")) {
	%>
<form class="logIn" method="post" action="goAdminLogin.do">
	<div class="buttonTwo">
		<blockquote class="quote-warning">
			<p>관리자 로그인 페이지입니다.</p>
		</blockquote>
	</div>
   	<div class="input-group">
   	<%
   		if(!rememberId.equals("")){
   			%><input id="adminId" type="text" class="form-control" name="adminId" placeholder="ID" value="<%=rememberId%>" required="true"> <%
   		}else{
   			%><input id="adminId" type="text" class="form-control" name="adminId" placeholder="ID" required="true"><%
   		}
   	%>
	</div>
	
	<div class="input-group">
		<input id="password" type="password" class="form-control" name="adminPw" placeholder="Password" required="true">
	</div>
		
	<div class="buttonTwo">
		<input type="submit" class="btn btn-primary btn-block" value="로그인">
		<div class="checkbox">
			<label>
				<input type="checkbox" name="rememberId" value="rememberId">
				<span class="rememberId">아이디 저장</span>
			</label>
			<br>
		</div>
		<div class="divBottom">
			<a href="index.do">홈으로</a>
		</div>
	</div>
</form>
	<%
		} // else if 닫기
	%>
</body>
<script type="text/javascript" src="./assets/scripts/main.js"></script>
<%if(rememberId.equals("")){ %>
	<script>
		$("input[type=checkbox]").removeAttr("checked");
	</script>
<%}else{%>
	<script>
		$("input[type=checkbox]").attr("checked", "checked");
	</script>
<%} %>	

<script type="text/javascript">
	function goHome() {
		window.location.href = "index.do";
	}
</script>
</html>
