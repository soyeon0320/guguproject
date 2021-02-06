<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/GUGUProject/plugins/css/all.min.css">
<link rel="stylesheet" href="/GUGUProject/dist/css/adminlte.min.css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description" content="This is an example dashboard created using build-in elements and components.">
<meta name="msapplication-tap-highlight" content="no">
<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<style type="text/css">
	body {
		margin-left: 0%;
		margin-top: 3%;
	}
	button {
		margin: 2%;
		width: 15%;
	}
	th{
		width: 15%;
/* 		text-align: center; */
		font-size: 1.2em;
		padding-left: 30px;
		}
	td{
/* 		padding-left:50px; */
	} 
	
	small{
		text-align: right;
	}
	.card-title{
		font-size: 2em;
 		text-align: center; 
	}
	<!--jobnewsHandler의 겟파라미터변수명과 각 name이 같아야함-->
</style>
<title>채용설명회 등록</title>
<body>
	<div class="col-lg-12">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title col-lg-12" >취업뉴스 등록</h3>
				<form action="/GUGUProject/jobnews/insert.do" method="post" name="frm">
<!-- 					<table class="col-md-6" > -->
						<table class="mb-0 table table-hover">
						<tr>
							<th>구분</th>
							<td>
								<select name="jobnewsGubun">
									<option value="NEWS">뉴스</option>
									<option value="TIPS">취업팁</option>
									<option value="SISA">시사</option>
								</select>
							</td>
							</tr>
						<tr>
						<th>뉴스제목</th>
						<td id="Title"><input type="text" name="jobnewsTitle" class="col-md-15 form-control" ></td>
						</tr>
					<tr>
					<th>기자명</th>
					<td id="Editor"><input type="text" name="jobnewsEditor" class="col-md-5 form-control" ></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td id="regDate"><input type="text" name="jobnewsRegDate" class="col-md-5 form-control"></td>
				</tr>
				<tr>
					<th>출처</th>
					<td id="Copyright"><input type="text" name="jobnewsCopyright" class="col-md-5 form-control"></td>
				</tr>			
				<tr>
					<th>이미지</th>
						<form method="post" action="upload" enctype="multipart/form-data">
				    <td><input type="file" name="jobnewsUrl"></td>
					</form>
				</tr>			
				<tr>
					<th>내용</th>
					<td colspan="2" style="text-align: justify;">
	           			<textarea id="growth" name="jobnewsContent" rows="12" cols="20" class="col-md-12 form-control" maxlength="4000"></textarea>
	           		</td>
				</tr>
					
	<!-- 				<label for="contents"></label> -->
	<!-- 				<form action="/action_page.php"></form> -->
					
	<!-- 				<td><input type="text" name="jobnewsContent"></td> -->
	<!-- 			</tr> -->
				
			</table>
			</form>
			<button type="submit" id="newsAddBtn" onclick="newsAdd()" class="btn btn-primary">등록</button>
		</div>
		</div>
		</div>		
		</form>
		<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
		<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
		<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
		<script src="/GUGUProject/plugins/js/demo.js"></script>
		
		<script>
		function newsAdd(){
			if(frm.jobnewsTitle.value=="" || frm.jobnewsEditor.value==""){
				alert("제목과 작성자(기자명)는 필수 입력사항입니다.");
				frm.jobnewsTitle.focus();
				return;
			}
			
	//	 	frm.location="url";
		//  frm.action="";
			alert("등록 성공");
			frm.submit();
		}
		
		</script>
	</body>
	</html>