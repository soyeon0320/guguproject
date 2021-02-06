<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = request.getParameter("memberId") == null ? "" : (String) request.getParameter("memberId");  
%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
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
<div class="warp container col-xs-5">
	<form>
		  <div>
			<blockquote class="quote-info">
	     	  <h5>GuGuSystem</h5>
	 			<p class=>아이디 찾기 페이지<br><br>회원 아이디는 <br>[ <%=memberId %> ]입니다.</p>
			</blockquote>
		  </div>
		  <button type="submit" class="btn btn-primary btn-block" onclick="closeWindow();">닫기</button>
		</form>
</div>
</body>
<script type="text/javascript">
	function closeWindow() {
		window.close();
	}
</script>
</html>