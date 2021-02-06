<%@page import="vo.JobNewsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description" content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
</head>
<script type="text/javascript">

</script>
<head>
	<meta charset="UTF-8">
	<title>취업뉴스</title>
	<style type="text/css">
	
.header {
		width: 100%;	/*너비 최대화*/
 		height: 80px; 
	 	background-color: #b0e0e6;
	 	text-align: center;
	    border-radius: 60px;	/*--크기클수록모서리둥글게됨--*/
		display: inline-block;
		vertical-align: middle;
/* 		padding-bottom: 3px; */
	}

	
	.menubar a{
 		text-decoration: none;
		color: white;
	}
	
	#li1{
		display: inline; /*inline은 위아래 길이조정은o, 너비조절은x*/
		border: 2px solid mediumslateblue;
		background-color: lightpink;
		padding: 10px 20px;	/*=>칸 크기*/
/* 		margin-top: -40px; */
		
	}
	
/* 	.nav{ */
/* 		width: 15%;	 */
/* 		height: 450px; */
/* 		background-color: #ffe4e1; */
/* 		float:left; */
/* 		font-size:20px; */
/* 	    border-radius: 30px; */
/* 	    margin: 10px 0 10px 0;		 */
/* 	} */
	
	.nav-in{
		padding: 20px;
		margin: 10px;
	}
	iframe{
		width:68%;
		height:500px;
		border: 0;
	}

	
	.article{
		background-color: #f3d1b9;
		border-radius: 30px;
		padding: 20px;
		margin: 10px;
	}
	
	.right{
		width: 15%;	
		height: 500px;
		background-color: #ffe4e1;
		float:right;
		font-size:20px;
	    border-radius: 30px;	
	    margin: 10px 0 10px 0;				
	}
	#li2{
		background-color: lightpink;
		padding: 10px 20px;	/*=>칸 크기*/
/* 		margin-top: -40px; */
		display:grid;
		
	}
	
	#li3{
		text-align: left;
	}
	.footer{
		width: 100%;	
		height: 50px;
		background-color: #87cefa;
		text-align: center;	
		clear: both; /*float속성 중단할 때 사용..잊지말기!*/
	    border-radius: 30px;
		display: inline-block;
		vertical-align: middle;
	}

	.menu{
		width: 17%;
		float: left;
		font-size: 24px;
		margin-top: 20px;
	}		

	.menu a{
		color: white;
		text-decoration: auto;
	}
	
		
	.productBox {
	    height: 420px;
	    width: 20%;
	    border: 1px solid gray;
	    float: left;
	    margin: 0.5%;
	    text-align: center;
	    margin-top: 35px;
	    margin-right: 2%;
	}
	
	.imageBox {
		width: 250px;
		height: 200px;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	.noteBox {
		width: 250px;
		margin: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		text-align: left;
		font-size: 13px;
	}
	
	.noteBox_title {
		width: 250px;
		margin: auto;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	.ad{
		width: 15%;	
		height: 450px;
		background-color: #ffe4e1;
		float:right;
		font-size:20px;
	    border-radius: 30px;	
	    margin: 10px 0 10px 0;				
	}
	</style>
</head>
<!-- 	<div class="nav"> -->
<!-- 		<div class="nav-in">  -->
			<p style="font-size: 30px;font-weight: 700px; font-color:grey">
 				<a href ="/GUGUProject/jobnews/managerlist.do" style="text-decoration: auto;"></a>
 				<h2 style="text-align: center; font-weight: bold; margin-top: 3%;">취업뉴스 </h2>
			</p>

<!-- 	<span style="font-size: 30px;font-weight: 700; font-color:grey;"> -->
<!-- 		<a style="text-align: center; margin-top: 3%;" href ="/GUGUProject/jobnews/list.do" style="text-decoration: auto;">취업뉴스 -->
<!-- 		</a> -->
<!-- 	</span> -->
<br>
<nav>
  <div class="nav nav-tabs" id="nav-tab" role="tablist">
  <% 
	  String gubun=(String)request.getAttribute("GUBUN"); 
	  if(gubun==null) gubun="NEWS";
	  
  %>
    <a class="nav-item nav-link<%if(gubun.equals("NEWS")){ %> active<%} %>" id="nav-home-tab" data-toggle="tab" href="/GUGUProject/jobnews/list.do?GUBUN=NEWS" role="tab" aria-controls="nav-home" aria-selected="true">뉴스</a>
    <a class="nav-item nav-link<%if(gubun.equals("TIPS")){ %> active<%} %>" id="nav-profile-tab" data-toggle="tab" href="/GUGUProject/jobnews/list.do?GUBUN=TIPS" role="tab" aria-controls="nav-profile" aria-selected="false">취업팁</a>
    <a class="nav-item nav-link<%if(gubun.equals("SISA")){ %> active<%} %>" id="nav-contact-tab" data-toggle="tab" href="/GUGUProject/jobnews/list.do?GUBUN=SISA" role="tab" aria-controls="nav-contact" aria-selected="false">시사</a>
  </div>
</nav>
<div class="tab-content" id="nav-tabContent">
<div class="tab-pane fade show active" id="nav-news" role="tabpanel" aria-labelledby="nav-news-tab" style="margin-left: 6%;">

 
       <%
         List<JobNewsVO> jobnewsList = (List<JobNewsVO>)request.getAttribute("jobnewsList");
      
         for(JobNewsVO jv : jobnewsList){
       %>
       
        <div class="productBox">
			<img src="/GUGUProject/assets/img/jobnews/<%=jv.getJobNewsUrl() %>" class="imageBox">
			<div class="noteBox_title">
				<a href="/GUGUProject/jobnews/detail.do?jobNewsCode=<%=jv.getJobNewsCode()%>">
					<h3><%=jv.getJobNewsTitle()%></h3>
				</a>
			</div>
		</div>
       
      <%   
         }
      %>
		
  </div>
  </div>
<script type="text/javascript" src="./assets/scripts/jobnewsManagerList.js"></script>
</body>
</html>