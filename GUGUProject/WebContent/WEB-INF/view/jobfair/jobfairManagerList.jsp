<%@page import="vo.PagingVO"%>
<%@page import="vo.JobfairVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	PagingVO pageVO = (PagingVO)request.getAttribute("pageVO");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description" content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채용설명회 관리자페이지</title>
<style>

.top-notice-box { 
    padding: 22px 0;
/*     padding-top: 5px;  */
    background-color: #e8f4ff; 
    border-left: 1px solid #e0e0e0; 
    border-right: 1px solid #e0e0e0;
    text-align: center; 
 }
 

</style>
</head>
<script type="text/javascript">
	function button_delete(){
		if (confirm("정말 삭제하시겠습니까?") == true){    //확인
			
	 	    //document.form.submit();
		}else{   //취소
	
	    return document.form.submit();
	}
}
</script>
<body> 
   <div class="col-lg-15">
   <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title"></h5>
     <h3 style="text-align: center; font-weight: bold;">채용설명회 일정
     </h3>
     <div class="col-md-6">전체 <%=pageVO.getTotalCount()%>건</div>
   <button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"
    	onclick="location.href='/GUGUProject/jobfair/insert.do';">글 등록</button>
   <div class="top-notice-box">
                <p style="font-size:15px">최근 코로나바이러스감염증-19로 인하여 일정이 갑작스레 취소, 변경될 수 있습니다.    이점 양해 바랍니다!</p>
   </div>
   <table class="mb-0 table table-hover"> 
   	<thead>
      <tr>
      	
         <th>번호</th>
         <th>분류</th>
         <th>기업명</th>
         <th>설명회명</th>
         <th>일시</th>
         <th>장소</th>
         <th>삭제</th>         
      </tr>
      </thead>
     <%
         List<JobfairVO> jobList = (List<JobfairVO>)request.getAttribute("jobfairList");
         if(jobList!=null && !jobList.isEmpty()){ //'<td colspan="4">내용이 없습니다.</td>뿌려주기 위함'
      %>
	     	 <% 
	     	 
				int rowNum = pageVO.getTotalCount() - (pageVO.getCurrentPageNo()-1)*10;
	     	 	if (jobList.size() > 0) {
	     			for (int idx = 0; idx < jobList.size(); idx++) {
				// 게시판 목록 번호 생성 => 전체 게시글 수 - 현재페이지번호-1 * 10 = 시작번호 => 제목 로우 하나 생성할때마다 1씩 마이너스
			%>
			<tbody>
	         <tr>
	         	<td scope="row"><%=rowNum%></td>
<%-- 	         	<td scope="row"><%=idx + 1%></td> --%>
	            <td><%= jobList.get(idx).getJobfairGroup() %></td>
	            <td><%= jobList.get(idx).getCompanyName() %></td>
<%-- 	            <td><a href="/GUGUProject/jobfair/update.do?jobfairCode=<%=jobList.get(idx).getJobfairTitle()%>"></a></td> --%>
	            <td><a href="/GUGUProject/jobfair/update.do?jobfairCode=<%=jobList.get(idx).getJobfairCode()%>">
	            <%=jobList.get(idx).getJobfairTitle()%>
	            </a></td>
	            <td><%= jobList.get(idx).getJobfairStartdate().substring(0,16) %>~<%= jobList.get(idx).getJobfairEnddate().substring(0,16)%></td>
	            <td><%= jobList.get(idx).getJobfairPlace() %></td>
				<td><button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary"
       				onclick="button_delete() ; location.href='/GUGUProject/jobfair/delete.do?jobfairCode=<%=jobList.get(idx).getJobfairCode()%>';">삭제</button></td>
	          </tr>
	         </tbody>
	         	<%
	         	rowNum--;
	     			}
	     			
	     		%>
		      <%
		      	} 
		      %>

	<% } else {%>
		         <tr>
		            <td colspan="4">내용이 없습니다.</td>
		         </tr>
	      <% } %>
			
			</table>
			<div style="text-align: center;">
				<ul class="pagination" style="margin-left: 50%;">
					<% if(pageVO.getTotalCount() > 0){//1 %>
						<% if(pageVO.getFirstPageNo() > pageVO.getPageSize()) {//2 %>
								<li class="page-item"><a href="managerlist.do?pageNo=<%= pageVO.getFirstPageNo()-1 %>">[&lt;]</a></li>
						<% }//2 %>
						<% for(int pNo=pageVO.getFirstPageNo(); pNo<=pageVO.getLastPageNo(); pNo++){//3 %>
								<li class="page-item"><a href="managerlist.do?pageNo=<%= pNo %>"><%= pNo %></a></li>
						<% }//3 %>
						<% if(pageVO.getLastPageNo() < pageVO.getTotalPageCount()){//4 %>
								<li class="page-item"><a href="managerlist.do?pageNo=<%= pageVO.getFirstPageNo() + pageVO.getPageSize() %>">[&gt;]</a></li>
						<% }//4 %>
				</ul>
					<% }//1 %>
			</div>
      </div>
      </div>
      </div>
</body>
</html>