<%@page import="vo.NotisVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NotisVO> list = (List<NotisVO>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<title>관리자 FAQ</title>
</head>
<body>
	<div class="col-lg-6" style="margin-top: 3%;">
		<div class="main-card mb-3 card" id="tableTag" style="width:205%;">
				<h2 style="text-align: center;">공지사항</h2>
			<div class="card-body">
					<a href="notisAdminInsert.do"><button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-info" value="글쓰기" onclick="insertCheck()">글쓰기</button></a>
<!-- 					<input class="mb-2 mr-2 btn-transition btn btn-outline-info" value="선택 삭제" onclick="deleteCheck();"> -->
				<table class="mb-0 table table-hover">
					<thead>
						<tr>
							<th style="width: 3%">번호</th>
							<th style="width: 18%">제목</th>
							<th>내용</th>
							<th style="width: 6%">등록일</th>
							<th>작성자</th>
							<th style="width: 5%;"></th>
						</tr>
					</thead>
					<%
						int count = 1;
						for (int index = 0; index < list.size(); index++) {
					%>
					<tbody>
						<tr>
<!-- 							<td> -->
<%-- 					    		<input type="checkbox" onclick="checkBox(this)" id="code" value="<%=list.get(index).getCode()%>"> --%>
<!-- 					    	</td> -->
							<td><%=count%></td>
							<td><a href="update.do?code=<%=list.get(index).getCode()%>"><%=list.get(index).getTitle()%></a></td>
							<td><%=list.get(index).getContent()%></td>
							<td><%=list.get(index).getRegDate().substring(0, 10)%></td>
							<td><%=list.get(index).getAdminId()%></td>
							<td><a href="delete.do?code=<%=list.get(index).getCode()%>">삭제</a></td>
						</tr>
					</tbody>
					<%
						count++;
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>