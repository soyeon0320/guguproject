<%@page import="vo.JobNewsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <% 

  	JobNewsVO jv=(JobNewsVO)request.getAttribute("jobnewsVo"); 	 

  	String jobnewsTitle = jv.getJobNewsTitle();  
	String jobnewsContent = jv.getJobNewsContent();  
	String jobnewsUrl = jv.getJobNewsUrl();  
	String jobnewsCopyright = jv.getJobNewsCopyright();  
	String jobnewsEditor = jv.getJobNewsEditor();  
	String jobnewsRegDate = jv.getJobNewsRegDate();  
	
  %>
  <title><%=jobnewsTitle %></title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/blog-post.css" rel="stylesheet">

	<style>
		.img-fluid{
			align: center;
		} 
	</style>

</head>

<body>
<!-- Post Content Column -->
      <div class="detailnews">

        <!-- Title -->
        <h1 class="mt-4"><%=jobnewsTitle %></h1>

        <!-- Author -->
        <p class="lead">
          by
          <a><%=jobnewsEditor %></a>
        </p>

        <hr>

        <!-- Date/Time -->
        <p><%=jobnewsRegDate %></p>

        <hr>

        <!-- Preview Image -->
        <img class="img-fluid" src="/GUGUProject/assets/img/jobnews/<%=jobnewsUrl %>" alt="">

        <hr>

        <!-- Post Content -->
        <p class="lead"><%=jobnewsContent %></p>

        <p><%=jobnewsCopyright %></p>

        <hr>

		</div>
</body>

</html>
      