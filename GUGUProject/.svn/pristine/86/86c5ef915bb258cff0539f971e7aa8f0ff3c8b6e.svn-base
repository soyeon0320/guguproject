<%@page import="vo.ApplyVO"%>
<%@page import="vo.MemberPagingVO"%>
<%@page import="vo.PagingVO"%>
<%@page import="vo.IntroductionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<ApplyVO> avList = (List<ApplyVO>) request.getAttribute("avList");
// 	System.out.println(avList.get(0).getIntroTitle());
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
	h4{
		margin-top: 10px;
		padding-left: 50px;
		text-align: left;
	}
	#btns{
		margin-top: 20px;
	}
	button {
		width: 20%;
		margin: 1%;
	}
	th,td{
		width: 25%;
	}
</style>
<body>
	<div class="row">
	
	</div>
	</div>
	<div class="col-lg-12">
		<div class="main-card mb-3 card col-lg-12" >
			<div class="col-lg-12" style="margin-top: 50px;"></div> <!-- 여백추가 div -->
<!-- 			<h1 class="card-title" style="font-size: 25px;">찜페이지</h1> -->
			<div class="card-body">
				<h4>이력서</h4>
				<hr color="blue">
				<table class="mb-0 table table-hover">
					<thead style="font-size: 15px;">
						<tr>
							<th>구분</th>
							<th>제목</th>
							<th>작성일</th>
							<th>목록에서제거</th>
						</tr>
					</thead>
					<%if(avList.size() > 0){
						for(int i = 0; i < avList.size(); i++){
							if(avList.get(i).getCareerTitle()==null) continue;%>
							<tr class="resumeIdx<%=i%>">
								<td><input type="radio" name="chk_career" value="<%=avList.get(i).getCareerCode() %>"></td>
								<input type="hidden" name="getResumeCode" value=<%=avList.get(i).getCareerCode() %>>
								<td><%=avList.get(i).getCareerTitle() %></td>
								<td><%=avList.get(i).getCareerDate().substring(0, 11) %></td>
								<td><button class="btn btn-danger" onclick="resumeDelete(<%=i%>,<%=avList.get(i).getCareerCode() %>)">삭제</button></td>
							</tr>
					    <%}
					}else{%>
						<tr>
							<td colspan="3">추가한 항목이 없습니다.</td>
						</tr>
					<%}%>
				</table>
				<h4>자기소개서</h4>
				<hr color="blue">
				<table class="mb-0 table table-hover">
					<thead style="font-size: 15px;">
						<tr>
							<th>구분</th>
							<th>제목</th>
							<th>작성일</th>
							<th>목록에서제거</th>
						</tr>
					</thead>
					<%if(avList.size() > 0){
						for(int i = 0; i < avList.size(); i++){
							if(avList.get(i).getIntroTitle() == null) continue;%>
							<tr class="introIdx<%=i%>">
								<td><input type="radio" name="chk_intro" value="<%=avList.get(i).getIntroCode() %>"></td>
								<input type="hidden" name="getIntroCode" value=<%=avList.get(i).getIntroCode() %>>
								<td><%=avList.get(i).getIntroTitle() %></td>
								<td><%=avList.get(i).getIntroDate().substring(0, 11) %></td>
								<td><button class="btn btn-danger" onclick="introDelete(<%=i%>,'<%=avList.get(i).getIntroCode() %>')">삭제</button></td>
							</tr>
					    <%}
					  }else{%>
							<tr>
								<td colspan="3">추가한 항목이 없습니다.</td>
							</tr>
					<%}%>
				</table>
				<h4>관심기업</h4>
				<hr color="blue">
				<table class="mb-0 table table-hover">
					<thead style="font-size: 15px;">
						<tr>
							<th>구분</th>
							<th>회사명</th>
							<th>모집마감일</th>
							<th>목록에서제거</th>
						</tr>
					</thead>
					<tr>
						<td><input type="radio" name="chk_company" value="test"></td>
						<td>대덕인재IT사업부</td>
						<td>2021-02-15</td>
						<td><button id="deletebtn1" class="btn btn-danger">삭제</button></td>
					</tr>
					<tr>
						<td><input type="radio" name="chk_company" value="test"></td>
						<td>마이크로소프트</td>
						<td>2021-03-01</td>
						<td><button id="deletebtn2" class="btn btn-danger" onclick="companyDelete()">삭제</button></td>
					</tr>
				</table>
		
			<div id="btns">
				<button type="button" class="btn btn-primary" onclick="download()">PDF 다운로드</button>
				<button type="button" class="btn btn-primary" onclick="resumeSubmit()">바로 지원하기</button>
			</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function download() {
	if(!$("input:radio[name=chk_career]:checked").val() || !$("input:radio[name=chk_intro]:checked").val()){
		alert("이력서와 자기소개서를 각각 하나씩 선택해주십시오!");
		return;
	}
	
	
	var params = {
			resumeCode : $("input:radio[name=chk_career]:checked").val(),
			introCode : $("input:radio[name=chk_intro]:checked").val() 
		};
	
// 	alert(params.introCode);
	$.ajax({
		url: "pdfDownload.do",
		type:"post",
		data: params,
		success: function(data){
			alert("PDF저장이 완료되었습니다.");
			window.location ="getfileDownload.do";
			
		},
		error: function(error){
			alert("작업실패");
		}
		
		
	});
	
}

function resumeSubmit() {
	if (!$("input:radio[name=chk_company]:checked").val()) {
		alert("최소 1개이상의 기업에 지원해야 합니다!");
	}else{
		alert("현재 시스템 점검으로 이용이 제한됩니다. \n불편을 드려 죄송합니다.");
	}
}

function introDelete(idx, code) {
	var param = {introCode : code};
 	$.ajax({
 		url:"introApplyDelete.do",
 		type:"post",
 		data: param,
		success: function(data){
			alert("관심목록에서 삭제되었습니다.");
			$(".introIdx"+idx+"").remove();		
		},
		error: function(error){
			alert("작업실패");
		} 		
 	})
}

function resumeDelete(idx, code) {
	var param = {resumeCode : code};
 	$.ajax({
 		url:"resumeApplyDelete.do",
 		type:"post",
 		data: param,
		success: function(data){
			alert("관심목록에서 삭제되었습니다.");
			$(".resumeIdx"+idx+"").remove();
		},
		error: function(error){
			alert("작업실패");
		} 		
 	})
}
$("#deletebtn1").on("click", function () {
	alert("관심목록에서 삭제되었습니다.");
	$(this).parents("tr").remove();
}) 
$("#deletebtn2").on("click", function () {
	alert("관심목록에서 삭제되었습니다.");
	$(this).parents("tr").remove();
}) 



</script>


</html>