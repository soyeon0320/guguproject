<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
String pageinfo = request.getParameter("pageinfo") == null ? "" : request.getParameter("pageinfo");
String memberId = request.getParameter("memberId") == null ? "" : request.getParameter("memberId");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원비밀번호 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.warp{margin-top: 10%; float: none;}
#inputId{margin-bottom: 5%;}

</style>
</head>
<body>
<%if(memberId.equals("")){
	%>
	<div class="warp container col-xs-6">
		<form class="findPw" method="post" action="findPwGowithId.do">
		  <div>
			<blockquote class="quote-info">
	     	  <h5>GuGuSystem</h5>
	 			<p class=>비밀번호 찾기 페이지</p>
			</blockquote>
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" id="inputId" name="memberId" placeholder="회원 아이디 입력" autofocus>
		    <small id="emailHelp" class="form-text text-muted">비밀번호를 찾으려하는 회원의 아이디를 입력하세요</small>
		  </div>
		  <button type="submit" class="btn btn-primary btn-block">다음</button>
		</form>
	</div>
	<%
}else if(pageinfo.equals("email") && msg.equals("fail2")){
	%>
	<div class="warp container col-xs-6">
		<form class="findPw" method="post" action="findPwGowithEmail.do">
	  	<div>
			<blockquote class="quote-info">
     	  		<h5>GuGuSystem</h5>
 				<p class=>비밀번호 찾기 페이지</p>
 				<p class=><%=memberId %> 님의 비밀번호 찾기</p>
			</blockquote>
	  	</div>
	  		<div class="form-group">
	    		<input type="email" class="form-control" id="inputId" name="memberEmail" placeholder="회원 이메일 입력" autofocus>
				<input type="hidden" name="memberId" value="<%=memberId %>">
	    		<small id="emailHelp" class="form-text text-muted">회원가입시 작성한 이메일을 입력하세요</small>
	  		</div>
	  		<button type="submit" class="btn btn-primary btn-block">다음</button>
		</form>
	</div>
	<%
}else{
	%>
	<div class="warp container col-xs-6">
		<form class="findPw" method="post" action="findPwGowithEmail.do">
	  	<div>
			<blockquote class="quote-info">
     	  		<h5>GuGuSystem</h5>
 				<p class=>비밀번호 찾기 페이지</p>
 				<p class=><%=memberId %> 님의 비밀번호 찾기</p>
			</blockquote>
	  	</div>
	  		<div class="form-group">
	    		<input type="email" class="form-control" id="inputId" name="memberEmail" placeholder="회원 이메일 입력" autofocus>
	    		<input type="hidden" name="memberId" value="<%=memberId %>">
	    		<small id="emailHelp" class="form-text text-muted">회원가입시 작성한 이메일을 입력하세요</small>
	  		</div>
	  		<button type="submit" class="btn btn-primary btn-block">다음</button>
		</form>
	</div>
	<%
}
%>
</body>
<script type="text/javascript">
<%if(msg.equals("fail")){
	%>alert("존재하지 않는 회원입니다!")<%
}%>
<%if(msg.equals("fail2")){
	%>alert("회원 이메일이 일치하지 않습니다!")<%
}%>
</script>
</html>