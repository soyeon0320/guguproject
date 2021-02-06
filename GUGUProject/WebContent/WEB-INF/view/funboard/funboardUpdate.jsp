<%@page import="vo.FunBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	FunBoardVO funBoardVO = (FunBoardVO)request.getAttribute("funBoardVO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		margin-left: 5%;
		margin-top: 3%;
	}
</style>
<body>
	<div class="col-lg-6">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         	<h3 class="card-title" style="font-size: 20px;">게시글 수정</h3>
         	<form action="update.do" method="post">
				<input type="hidden" name="funBoardCode" value="<%= funBoardVO.getCode() %>">
	             	<table class="mb-0 table table-hover">
		              	<tr>
							<th>제목</th>
							<td><input type="text" name="funBoardTitle" value="<%= funBoardVO.getTitle() %>" class="form-control" style="width: 70%;" placeholder="제목을 입력해주세요"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><input type="text" name="funBoardContent" value="<%= funBoardVO.getContent() %>" class="form-control" style="width: 70%; height: 200px;" placeholder="내용을 입력해주세요"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;">
								<button type="submit" class="mb-2 mr-2 btn-transition btn btn-outline-warning"><i class="bi bi-pencil-square"></i> 게시글 수정</button>
								<a href="list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info"><i class="bi bi-list-ol"></i> 게시글 목록</button></a>
							</td>
						</tr>
					</table>
				</form>
             </div>
          </div>
       </div>
</body>
</html>