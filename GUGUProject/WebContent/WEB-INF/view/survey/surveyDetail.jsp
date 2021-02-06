<%@page import="vo.SurveyVO"%>
<%@page import="vo.SurveyQuestionVO"%>
<%@page import="vo.QuestionItemVO"%>
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
<title>설문조사</title>

<script type="text/javascript"> 
	window.onload = function() { var header = document.getElementById('submit'); // submit 객체에 onclick 이벤트 속성을 연결 
		submit.onclick = function() { alert('설문 제출이 완료되었습니다.'); // 이벤트를 제거, 한번만 실행이 됨 
			submit.onclick = location.href='/GUGUProject/survey/list.do';
		} 
	};
</script>
</head>
<body>
  <div class="col-lg-11">
   <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title"></h5>
     <h3>설문조사
     </h3>
     <%
		SurveyVO sv = (SurveyVO)((List<SurveyVO>)request.getAttribute("surveyList")).get(0);

     	String surveyCode = sv.getSurveyCode();
     	String surveyStartdate = sv.getSurveyStartdate();
     	String surveyEnddate = sv.getSurveyEnddate();
     	String surveyTitle = sv.getSurveyTitle();
     	String surveyExplain = sv.getSurveyExplain();
     	
     	List<SurveyQuestionVO> sqList = sv.getQuestionList();

     
     %>     
	<form action="/GUGUProject/survey/detail.do?surveyState=END" method="post" >
		<input type="hidden" name="surveyCode" value="<%=surveyCode%>">
		<input type="hidden" name="sqSize" value="<%=sqList.size()%>">
	   	<table class="mb-0 table table-hover">
	    	<tr>
	     		<td>제목</td>
	     		<td><%=surveyTitle %></td>
	     	</tr>
	    	<tr>
	     		<td>설문기간</td>
	     		<td><%=surveyStartdate %> ~ <%=surveyEnddate %></td>
	     	</tr>
	    	<tr>
	     		<td>개요</td>
	     		<td><%=surveyExplain %></td>
	     	</tr>
		</table>     
	    
	    <table>
	    <!-- 퀴즈(문항) -->
	    <%
	    	int i=0;
	    	for(SurveyQuestionVO sq : sqList){
	    		
	    		String sqCode = sq.getSqCode();
	    		String sqTitle = sq.getSqTitle();
	    		String sqNo = sq.getSqNo();
	    		
	         	List<QuestionItemVO> siList = sq.getQuestionItemList();
	    	
	    %>	
	    	<tr>
	    		<td><%=sqNo%></td>
	    		<td><%=sqTitle%></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2">
	    		<%
	    			for(QuestionItemVO si : siList){
	    				String qiNo = si.getQiNo();
	    				String qiContent = si.getQiContent();
	    		%>
		    		<input type="radio" name="answer<%=i%>" value="<%=sqCode %>;<%=qiNo%>">
		    		<%= qiContent%>
	    			<br><!-- 선택지 세로로 출력됨 -->
	    		<%
	    			}
	    			i++;
	    		%>
	    		<br><!-- 각 질문당 한 줄씩 띄우기 -->
	    		</td>
	    	</tr>
	    <%
	    	}
	    %>	    	
	    </table>
	    	<p id="submit">
	    	<button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"
       				 onclick=";">설문제출</button>
       		</p>
<!-- 	    		<a href="GUGUProject/survey/list.do"> -->
<!-- 	    			<input type="submit" value="설문제출"> -->
<!-- 	    		</a> -->
	    	
	</form>
    
    </div>
  </div>
 </div>
</body>
</html>
