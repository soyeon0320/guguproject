<%@page import="vo.SurveyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description" content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 관리자 페이지</title>
</head>
<body>
  <div class="col-lg-13">
   <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title"></h5>
     <h1 class="card-title" style="font-size: 2em; text-align: center;"  >설문조사</h1>
   <br>
   <button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"
    	onclick="location.href='/GUGUProject/survey/insert.do';">추가</button>
   	<table class="mb-0 table table-hover">
    <thead>
    	<th>시작일</th>
        <th>종료일</th>
        <th>Title</th>
        <th>시행여부</th>
        <th>수정</th>
     </tr>
     </thead>
     <tbody>
      <%
		 List<SurveyVO> surveyList = (List<SurveyVO>)request.getAttribute("surveyList");
		 if(surveyList!=null && !surveyList.isEmpty()){ //'<td colspan="4">내용이 없습니다.</td>뿌려주기 위함'
		 for(SurveyVO job : surveyList){
     	%>
      <tr>
            <td><%= job.getSurveyStartdate().substring(0,11) %></td>
            <td><%= job.getSurveyEnddate().substring(0,11) %></td>
            <td><%= job.getSurveyTitle() %></td>
            <td><%= job.getSurveyIng() %></td>
         <td>
       				<button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"
       				 onclick="location.href='/GUGUProject/survey/update.do';">수정</button>
       			<%
       			%>
            </td>
       </tr>
      		 <%      
		 	}
		 }else{
		      %>
		         <tr>
		            <td colspan="4">내용이 없습니다.</td>
		         </tr>
		      <%   
		         }
		      %>                                                  
                    </tbody>
                   </table>
                  </div>
                 </div>
               </div>
</body>
</html>
