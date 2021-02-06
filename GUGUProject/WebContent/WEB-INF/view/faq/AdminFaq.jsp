<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.FaqVO"%>
<%@page import="java.util.List"%>
<%-- <%@ include file="../header.jsp"%> --%>
<%
	List<FaqVO> list = (List<FaqVO>)request.getAttribute("list");
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
<style type="text/css">
#tableTag{width: 200%;}
</style>
<script type="text/javascript">
// 	function checkBox(code){
// 		arr = [code.value];
// 		alert(arr);
// 	}

	function insertCheck(){
// 		alert("등록 시작");
		location.href="insertFaq.do";
	}
</script>
</head>
<body>
	<div class="card-body"><h1 style="text-align: center;">관리자 FAQ</h1>
<div class="col-lg-6">
<div>
	<input type="hidden" value= arr name="arr">
	<input class="mb-2 mr-2 btn-transition btn btn-outline-info" value="글쓰기" onclick="insertCheck()">
<!-- 	<a href="faqDelete.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info">선택 삭제</button></a> -->
</div>    
      <div class="main-card mb-3 card" id="tableTag">
             <table class="mb-0 table table-hover">
                <thead>
                <tr>
					<tr style="text-align: center;">
						<th scope="col" style="width: 5%;">번호</th>
						<th scope="col" style="width: 20%;">질문</th>
						<th scope="col" style="width: 60%;">답변</th>
						<th scope="col" style="width: 6%;">작성자</th>
						<th scope="col" style="width: 6%;"></th>
					</tr>
				 </thead>
                <tbody>

     		<% 
			   int count=1;
			   for(int index=0; index<list.size(); index++){ 
				   //onclick="checkBox(this)"
			%>   
       			<tr>
<%-- 					<td><input type="checkbox" value="<%=list.get(index).getCode()%>" name="dateBox"></td> --%>
			 		<td  style="text-align: center;"><%=count %></td>
					<td rowspan="1"><a href="update.do?code=<%=list.get(index).getCode() %>"><%=list.get(index).getQuestion() %></a></td>
					<td><%=list.get(index).getAnswer() %></td>
					<td><%=list.get(index).getAdminId() %></td>
					<td><a href="faqDelete.do?code=<%=list.get(index).getCode()%>">삭제</a></td>
                   </tr>
        	<% count++; } %> 
            	</tbody>
			</table>
        </div>
    </div>
</div>
</body>
</html>