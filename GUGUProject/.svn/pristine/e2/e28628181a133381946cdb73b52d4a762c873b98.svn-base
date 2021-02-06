<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.MemberVO"%>
<%
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	String memberId = session.getAttribute("memberId") == null ? "" : (String) session.getAttribute("memberId");
	String memberName = session.getAttribute("memberName") == null ? "" : (String) session.getAttribute("memberName");

	String rememberId = "";
	
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("memberId")) {
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
<title>로그인</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="Inline validation is very easy to implement using the Architect Framework.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
	

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<style>
.input-group{width: 40%;margin: 2%;}
.logIn{margin-left: 35%; margin-top: 5%;}
.buttonTwo{width: 40%;margin: 2%;}
.rememberId{padding-left: 2%; font-weight:bold;}
label{width:40%;}
.checkbox{border-bottom: 1px solid grey; padding-bottom: 5%;  margin-top: 5%;}
.divBottom{text-align: center;}
#bar{margin: 2%}
#memId{ width: 40%; margin-left: 2%;}
</style>
<script type="text/javascript">
	function goHome() {
		window.location.href = "index.do";
	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<%
		if (memberId != "") {
	%>
	<div class="logIn">
		<div class="buttonTwo">
			<blockquote class="quote-info">
				<h5>GuGuSystem</h5>
				<p class=><%=memberName%>님 환영합니다!
				</p>
			</blockquote>
			<button type="button" onclick="goHome()" class="btn btn-primary btn-block">홈으로</button>
		</div>
	</div>
	<%
		} else if (msg.equals("fail")) {
	%>
	<script>
		alert("입력한 회원정보가 맞지않습니다.");
	</script>

<form class="logIn" method="post" action="<%= request.getContextPath() %>/goLogin.do">
	<div class="input-group">
		<blockquote class="quote-info">
     	  <h5>GuGuSystem</h5>
 			<p class=>로그인 페이지</p>
		</blockquote>
	</div>
	<%
		if (!rememberId.equals("")) { // 쿠키에서 꺼내온 rememberId가 있으면 아이디 인풋에 값 넣기
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" value="<%=rememberId%>" required="true">
	<%
		} else { // 없으면 그냥 빈칸
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" required="true">
	<%
		}
	%>

	<div class="input-group">
		<input id="password" type="password" class="form-control" name="password" placeholder="Password" required="ture">
	</div>
		
	<div class="buttonTwo">
		<input type="submit" class="btn btn-primary btn-block" value="로그인">
		<div class="checkbox">
		<%if(rememberId.equals("")){%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}else{%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId" checked="checked">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}%>
			<br>
			</div>
				<div class="divBottom">
					<a href="" onclick="openFindId()">아이디 찾기</a><span id="bar">|</span>
					<a href="" onclick="openFindPw()">비밀번호 찾기</a><span id="bar">|</span>
					<a href="">회원가입</a><span id="bar">|</span>
					<a href="index.do">홈으로</a>
				</div>
			</div>
</form>
	<%
		} else if (msg.equals("")) {
	%>
	
<form class="logIn" method="post" action="<%= request.getContextPath() %>/goLogin.do">
	<div class="input-group">
		<blockquote class="quote-info">
     	  <h5>GuGuSystem</h5>
 			<p class=>로그인 페이지</p>
		</blockquote>
	</div>
	<%
		if (!rememberId.equals("")) { // 쿠키에서 꺼내온 rememberId가 있으면 아이디 인풋에 값 넣기
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" value="<%=rememberId%>" required="true">
	<%
		} else { // 없으면 그냥 빈칸
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" required="true">
	<%
		}
	%>

	<div class="input-group">
		<input id="password" type="password" class="form-control" name="password" placeholder="Password" required="true">
	</div>
		
	<div class="buttonTwo">
		<input type="submit" class="btn btn-primary btn-block" value="로그인">
		<div class="checkbox">
		<%if(rememberId.equals("")){%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}else{%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId" checked="checked">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}%>
			<br>
		</div>
		<div class="divBottom">
			<a href="" onclick="openFindId()">아이디 찾기</a><span id="bar">|</span>
			<a href="" onclick="openFindPw()">비밀번호 찾기</a><span id="bar">|</span>
<!-- 오잉?		<a href="member/member.do">회원가입</a> -->
<!-- 			<a href="">회원가입</a> -->

			<a href="member/member.do">회원가입</a><span id="bar">|</span>
			<a href="index.do">홈으로</a>
		</div>
	</div>
</form>
	<%
		}else if (msg.equals("quit")) { 
	%>
	<script>
		alert("탈퇴한 회원입니다.");
	</script>

<form class="logIn" method="post" action="<%= request.getContextPath() %>/goLogin.do">
	<div class="input-group">
		<blockquote class="quote-info">
     	  <h5>GuGuSystem</h5>
 			<p class=>로그인 페이지</p>
		</blockquote>
	</div>
	<%
		if (!rememberId.equals("")) { // 쿠키에서 꺼내온 rememberId가 있으면 아이디 인풋에 값 넣기
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" value="<%=rememberId%>" required="true">
	<%
		} else { // 없으면 그냥 빈칸
	%><input id="memId" type="text" class="form-control"
		name="memId" placeholder="ID" required="true">
	<%
		}
	%>

	<div class="input-group">
		<input id="password" type="password" class="form-control" name="password" placeholder="Password" required="ture">
	</div>
		
	<div class="buttonTwo">
		<input type="submit" class="btn btn-primary btn-block" value="로그인">
		<div class="checkbox">
		<%if(rememberId.equals("")){%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}else{%>
			<label>
				<input type="checkbox" name="rememberId" value="rememberId" checked="checked">
				<span class="rememberId">아이디 저장</span>
			</label>
		<%}%>
			<br>
			</div>
				<div class="divBottom">
					<a href="" onclick="openFindId()">아이디 찾기</a><span id="bar">|</span>
					<a href="" onclick="openFindPw()">비밀번호 찾기</a><span id="bar">|</span>
					<a href="">회원가입</a><span id="bar">|</span>
					<a href="index.do">홈으로</a>
				</div>
			</div>
</form>
	<%
		} // else if 닫기
	%>
<script type="text/javascript">

var popupWidth = 700;
var popupHeight = 630;

var popupX = (window.screen.width-popupWidth)/2;
var popupY = (window.screen.height-popupHeight)/2;

function openFindId() {
	window.open("openFindId.do", '', 'width='+popupWidth+', height='+popupHeight+', left='+popupX+', top='+popupY+'');
	return false;
}

function openFindPw() {
	window.open("opneFindPw.do", '', 'width='+popupWidth+', height='+popupHeight+', left='+popupX+', top='+popupY+'');
	return false;
}

</script>
<script type="text/javascript" src="./assets/scripts/main.js"></script>
</body>
</html>
