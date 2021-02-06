<%@page import="vo.NotisVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	List<NotisVO> list = (List<NotisVO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<title>공지사항</title>
<style>
.container{width: 30%;}
.input-group-addon{width: 100px;}
.buttonAll{margin: 4% 0% 0% 30%;}
.sub_title{ text-align: center; margin-bottom: 3%; margin-top:3%;}
</style>
<script type="text/javascript">
	function insertCheck(){
// 		alert("수정 합니다.");
		frm.submit();
	}
</script>
</head>
<body>
<form name="frm" method="post">
<div class="col-lg-6" style="margin-top: 5%; margin-left: 20%;">
    <div class="main-card mb-3 card">
        <div class="card-body"><h1 class="card-title">공지사항 수정</h1>
            <%
            	for(int index=0; index<list.size(); index++){
            %>
            <table class="mb-0 table table-hover">
                <tr>
                    <th style="width: 10%;">제목</th>
                    <td><input type="text" name="title" value="<%=list.get(index).getTitle()%>" style="width: 100%"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea rows="1" cols="1" name="content" style="width: 100%; height: 400px;"><%=list.get(index).getContent() %></textarea></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="adminId" readonly="readonly" value="<%=list.get(index).getAdminId()%>" style="width: 25%"></td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td><input type="text" name="regDate" readonly="readonly" value="<%=list.get(index).getRegDate().substring(0,10)%>" style="width: 25%"></td>
                </tr>
            </table>
        <%} %>
        </div>
    </div>
	<div class="buttonAll">
		<input type="button" class="btn btn-primary" style="margin-right: 5%;" value="수정" onclick="insertCheck();">
	</div>
</div>
</form>
</body>
</html>