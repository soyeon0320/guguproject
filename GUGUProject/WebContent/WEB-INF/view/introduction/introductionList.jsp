<%@page import="vo.MemberPagingVO"%>
<%@page import="vo.PagingVO"%>
<%@page import="vo.IntroductionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% List<IntroductionVO> introductionList = (List<IntroductionVO>)request.getAttribute("introductionList"); 
   MemberPagingVO pageVO = (MemberPagingVO)request.getAttribute("memberPageVO");	
   String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId");
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
		margin-left: 0%;
		margin-top: 1%;
	}
	.card-body{
		height: 650px;
		display: table-cell;
		
		vertical-align: middle;
	}
	.col-lg-12{
		padding-left: 0; padding-right: 0;
	}
	body::-webkit-scrollbar {
   		display: none; 
	}
	.card{
		text-align: center;
		display: table;
	}
	h1{
		font-size: 25px;
		display: table-row-group;
	}
</style>
<body>
	<div class="row">
	<div class="col-md-6">전체 <%=pageVO.getTotalCount()%>건&emsp;</div>
	<div class="col-md-6" style="text-align: right;">
	<% if (session.getAttribute("memberId") != null) {	%>
		<a href="/GUGUProject/introduction/insertForm.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary"><i class="bi bi-check2-square"></i> 자기소개서 작성</button></a>
	<%	} %>
	</div>
	</div>
	<div class="col-lg-12">
		<div class="main-card mb-3 card col-lg-12" >
			<div class="col-lg-12" style="margin-top: 50px;"></div> <!-- 여백추가 div -->
			<h1 class="card-title" style="font-size: 25px;">작성된 자기소개서 목록</h1>
			<div class="card-body">
				<table class="mb-0 table table-hover">
					<thead style="font-size: 15px;">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
		<% if (introductionList.size() > 0) {
			// 게시판 목록 번호 생성 => 전체 게시글 수 - 현재페이지번호-1 * 10 = 시작번호 => 제목 로우 하나 생성할때마다 1씩 마이너스
			int rowNum = pageVO.getTotalCount() - (pageVO.getCurrentPageNo()-1)*10;
				for (int idx = 0; idx < introductionList.size(); idx++) { %>
					<tbody>
						<tr>
							<td scope="row"><%=rowNum%></td>
							<td style="text-align: left;"><a href="/GUGUProject/introduction/select.do?introductionCode=<%=introductionList.get(idx).getCode()%>">
							<%=introductionList.get(idx).getTitle()%></a>
							</td>
							<td><%=introductionList.get(idx).getWriter()%></td>
							<td><%=introductionList.get(idx).getRegDate().substring(0, 11)%></td>
						</tr>
					</tbody>
					<%rowNum--; } %>
		<% } else { %>
			<tr>
				<td>게시글이 없습니다.</td>
			</tr>
		<% } %>
			</table>
			<div style="text-align: center; display: inline-block;">
				<ul class="pagination" >
					<% if(pageVO.getTotalCount() > 0){//1 %>
						<% if(pageVO.getFirstPageNo() > pageVO.getPageSize()) {//2 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pageVO.getFirstPageNo()-1 %>">[&lt;]</a></li>
						<% }//2 %>
						<% for(int pNo=pageVO.getFirstPageNo(); pNo<=pageVO.getLastPageNo(); pNo++){//3 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pNo %>"><%= pNo %></a></li>
						<% }//3 %>
						<% if(pageVO.getLastPageNo() < pageVO.getTotalPageCount()){//4 %>
								<li class="page-item"><a href="list.do?pageNo=<%= pageVO.getFirstPageNo() + pageVO.getPageSize() %>">[&gt;]</a></li>
						<% }//4 %>
				</ul>
					<% }//1 %>
			</div>
			<div>
				<button type="button" class="btn btn-primary">자기소개서 작성 서비스는 로그인 후에 이용 가능합니다.</button>
			</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var memberId = "<%=memberId%>";
	if(memberId != ""){
		$("button[type=button]").parent().remove();
	}
</script>


</html>