<%@page import="vo.JobfairVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JobfairVO jobfairVO = 
			(JobfairVO) request.getAttribute("jobfairVO");


// 	String memAddr = jobfairVO.getMemAddr()
// 			.replaceAll(System.lineSeparator(), "<br>");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채용설명회 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>분류:</td>
			<td><%=jobfairVO.getJobfairGroup() %></td>
		</tr>
		<tr>
			<td>설명회명:</td>
			<td><%=jobfairVO.getJobfairTitle() %></td>
		</tr>
		<tr>
			<td>일시:</td>
			<td><%=jobfairVO.getJobfairStartdate() %></td>
		</tr>
		<tr>
			<td>장소:</td>
			<td><%=jobfairVO.getJobfairPlace() %></td>
		</tr>
		
		
		<tr>
			<td colspan="2">
				<a href="list.do">[목록]</a>
				<a href="update.do?memId=<%=jobfairVO.getJobfairTitle()%>">[수정]</a>
				<a href="delete.do?memId=<%=jobfairVO.getJobfairTitle()%>">[삭제]</a>
			</td>
		</tr>
	
	</table>
</body>
</html>