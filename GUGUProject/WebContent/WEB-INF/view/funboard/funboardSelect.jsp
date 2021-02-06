<%@page import="vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.FunBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	FunBoardVO funBoardVO = (FunBoardVO)request.getAttribute("funBoardVO");
	List<CommentVO> commentList = (List<CommentVO>)request.getAttribute("commentList");
	String memberId = session.getAttribute("memberId")==null ? "" : (String)session.getAttribute("memberId"); 
	String commentCode = request.getParameter("commentCode");
	String content = request.getParameter("content");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script type="text/javascript">
$(document).ready(function(){
	$("#cmntModifyBt").hide();
	//댓글 수정
	$("#cmntModifyBt").click(function(evt){
		//현재 작업전에 수행되는 이벤트 발생 방지
		evt.preventDefault();
		$.ajax({
			url:"commentUpdate.do",
			type:"POST",
			data:{
				"content" : $("#cmntRegInp").val(),
				"commentCode" : $("#commentCode").val()
			},
			success:function(result){
				alert("댓글 수정에 성공하였습니다!");
				location.reload();
			},
			error:function(error){
				console.log(error);
			}
		});
	});
	
	//댓글 삭제
	$("#cmntDelete").on('click', function(){
		$.ajax({
			url:"commentDelete.do",
			type:"POST",
			data:{
					"commentCode" : $("#commentCode").val(),
				},
			success:function(result){
				alert("댓글 삭제에 성공하였습니다!");
			},
			error:function(error){
				console.log(error);
			}
		});
	});
});
	//댓글 수정시 현재 데이터 가져오기
	function cmntContent(param, code){
		$("#cmntRegBt").hide();
		$("#cmntModifyBt").show();
		$("#cmntRegInp").val(param);
		$("#commentCode").val(code);
		$("#parentFm").attr("action", "commentUpdate.do");
		$.ajax({
			url:"commentUpdate.do",
			type:"GET",
			data:{
					"content" : param,
					"commentCode" : code
				 },
			dataType:"json",
			success:function(data){
				//키 값으로 접근
				cmntModify(data.content, data.commentCode);
			},
			error:function(error){
				console.log(error);
			}
		});
	}
</script>
</head>
<style type="text/css">
	body {
		margin-left: 5%;
		margin-top: 3%;
	}
</style>
<body>
	<div class="col-lg-6">
    	<div class="main-card mb-3 card">
         	<div class="card-body">
         		<h3 class="card-title" style="font-size: 20px;"><%= funBoardVO.getMemId() %>님의 게시글</h3>
	             <table class="mb-0 table table-hover">
	              	<tr>
	              		<th>제목</th>
	              		<td><%= funBoardVO.getTitle() %></td>
	              	</tr>
	              	<tr>
	              		<th>등록자</th>
	              		<td><%= funBoardVO.getMemId() %></td>
	              	</tr>
	              	<tr>
	              		<th>등록일</th>
	              		<td><%= funBoardVO.getRegDate().substring(0, 11) %></td>
	              	</tr>
	              	<tr>
	              		<td colspan="2" style="text-align: center; white-space: pre-wrap;"><%= funBoardVO.getContent() %></td>
	              	</tr>
             		<tr>
						<td colspan="2" style="text-align: center;">
							<% if(funBoardVO.getMemId().equals(memberId)){ %>
							<a href="update.do?funBoardCode=<%= funBoardVO.getCode() %>">
							<button class="mb-2 mr-2 btn-transition btn btn-outline-warning"><i class="bi bi-pencil-square"></i> 게시글 수정</button>
							</a>&emsp;
							<% } %>
							<% if(funBoardVO.getMemId().equals(memberId) || session.getAttribute("adminId") != null){ %>
							<a href="delete.do?funBoardCode=<%= funBoardVO.getCode() %>">
							<button class="mb-2 mr-2 btn-transition btn btn-outline-danger"><i class="bi bi-trash"></i> 게시글 삭제</button>
							</a>&emsp;
							<% } %>
							<a href="list.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-info"><i class="bi bi-list-ol"></i> 게시글 목록</button></a>
						</td>
					</tr>
				</table>
          </div>
       </div>
       <div>
        <% if(session.getAttribute("memberId") != null) { %>
	  	<form action="commentInsert.do" method="post" id="parentFm">
			<input type="hidden" name="funBoardCode" value="<%= funBoardVO.getCode() %>">
			<input type="hidden" id="commentCode" name="commentCode" value="">
			<input type="hidden" name="regName" value="<%= memberId %>">
			<br>
			<input type="text" id="cmntRegInp" name="content" value="" class="form-control" style="width: 500px; height: 100px;" placeholder="내용을 입력해주세요"><br>
			<button type="submit" id="cmntRegBt" class="mb-2 mr-2 btn-transition btn btn-outline-primary"><i class="bi bi-journal-plus"></i>댓글 등록</button>&emsp;
			<button type="submit" id="cmntModifyBt" class="mb-2 mr-2 btn-transition btn btn-outline-warning"><i class="bi bi-journal-check"></i>댓글 수정</button>
		</form>
		<% } %>
	</div>	
	<div class="wrapper">
	  <div class="content-wrapper" style="margin-left: 1%; background-color: white; min-height: 0px;">
	  <% if(commentList.size() > 0) { %>
	  	<% for(int idx=0; idx<commentList.size(); idx++){ %>
		 	<div class="row">
		    	<div class="col-md-12">
					<div class="callout callout-info">
	                  <h5><i class="bi bi-person-square"></i> <%= commentList.get(idx).getRegName() %></h5>
	                  <p><%= commentList.get(idx).getContent() %></p>
	                  <p><i class="fas fa-clock"></i><%= commentList.get(idx).getRegDate().substring(0, 11) %></p>
	                  <% if(memberId.equals(commentList.get(idx).getRegName())){ %>
			          		<button class="mb-2 mr-2 btn-transition btn btn-outline-warning" onclick="cmntContent('<%= commentList.get(idx).getContent() %>',<%= commentList.get(idx).getCode() %>)">
		         	  		<i class="bi bi-journal-check"></i> 댓글 수정 시작</button>
		          	  <% } %>
		          	  <% if(memberId.equals(commentList.get(idx).getRegName()) || session.getAttribute("adminId") != null){ %>
			          		<form action="commentDelete.do" method="post" id="deleteFm">
								<a href="commentDelete.do?commentCode=<%= commentList.get(idx).getCode() %>">
								<input type="hidden" name="funBoardCode" value="<%= funBoardVO.getCode() %>">
								<input type="hidden" name="commentCode" value="<%= commentList.get(idx).getCode() %>">
								<button id="cmntDelete" class="mb-2 mr-2 btn-transition btn btn-outline-danger"><i class="bi bi-journal-minus"></i> 댓글 삭제</button></a>
							</form>
						<% } %>
	           	 	</div>
			<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<% } else{ %> 
			댓글이 존재하지 않습니다.
	<% } %>
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.min.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>
</body>
</html>