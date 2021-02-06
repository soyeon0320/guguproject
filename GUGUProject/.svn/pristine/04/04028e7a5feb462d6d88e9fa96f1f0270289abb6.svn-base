<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String) session.getAttribute("memberId");
	String adminId = session.getAttribute("adminId") == null ? "" : (String) session.getAttribute("adminId");
%>
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
$(document).ready(function(){
	$('form[name="frmUrl"] li a').on('click', function(e){
		e.preventDefault();
		$('iframe[name="freamUrl"]').attr("src" , $(this).attr("href"));
	});
	
	<%if(memberId != ""){ %>
		$("#logInOutBtn").attr("onclick", "goLogout()");
		$("#logInOutBtn").html("로그아웃");
	$("#memberJoinBtn").attr("onclick", "goMemberPage()");
	$("#memberJoinBtn").html("마이페이지");
	<%}else if(adminId != ""){%>
	$("#logInOutBtn").attr("onclick", "goLogout()");
	$("#logInOutBtn").html("로그아웃");
	$("#memberJoinBtn").attr("onclick", "goAdminPage()");
	$("#memberJoinBtn").html("관리자페이지");
	<%}%>
	
});
function goLogin() {
	window.location.href="/GUGUProject/login.do";
}
function goLogout() {
	window.location.href="/GUGUProject/logout.do";
}
function goMemberPage() {
	window.location.href="/GUGUProject/member/memberPage.do";
}
function goAdminPage() {
	window.location.href="/GUGUProject/admin/adminPage.do";
}
function goMemberJoin() {
	window.location.href="/GUGUProject/member/member.do";
}
function openInqueryWindow() {
	var popupWidth = 600;
	var popupHeight = 550;

	var popupX = (window.screen.width-popupWidth)/2;
	var popupY = (window.screen.height-popupHeight)/2;
	<%if(!adminId.equals("")){ %>
		window.open("<%=request.getContextPath() %>/inquery/inqueryAdmin.do", '', 'width='+popupWidth+', height='+popupHeight+', left='+popupX+', top='+popupY+'');
	<%}else if(!memberId.equals("")){%>
		window.open("<%=request.getContextPath() %>/inquery/inquery.do", '', 'width='+popupWidth+', height='+popupHeight+', left='+popupX+', top='+popupY+'');
	<%}else{%>
		alert("1:1문의 채팅은 회원만 이용 가능합니다!")
		window.close()
	<%}%>
}

// 	$('input[name="All"]').click(function(){
// 		alert("서비스 점검 중");
// 	});
</script>
<%-- <%=request.getContextPath()%>/search/list.do --%>
<body>
	<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<div class="app-header header-shadow">
			<div class="app-header__logo">
				<div class="Home">
					<a href="/GUGUProject/index.do"> HOME </a>
				</div>
				<div class="header__pane ml-auto">
					<div>
						<button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<div class="app-header__mobile-menu">
				<div>
					<button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
						<span class="hamburger-box"> <span class="hamburger-inner"></span>
						</span>
					</button>
				</div>
			</div>
			<div class="app-header__menu">
				<span>
					<button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
						<span class="btn-icon-wrapper"> <i class="fa fa-ellipsis-v fa-w-6"></i>
						</span>
					</button>
				</span>
			</div>
			<div class="app-header__content">
<!-- 		<form name="frm" method="post" style="width: 100%;" action="/GUGUProject/search/list.do"> -->
				<input type="text" class="form-control" name="All" id="All" placeholder="검색어를 입력해 주세요" style="width:30%; float: left; margin-right: 1%;">
		
				<button type="submit" class="btn btn-outline-primary">
				   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						 <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
                	검색
              	</button>
<!--  		</form>	 -->
			      <div class="app-header-right">
                    <div class="header-btn-lg pr-0">
                        <div class="widget-content p-0">
                            <div class="widget-content-wrapper">
                             <div class="widget-content-left  ml-3 header-user-info">
                                    <div class="widget-heading" style="margin-right: 5%;">
										<button id="logInOutBtn" style="margin: 5%;" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle" onclick="goLogin()"> 로그인</button>
										<button id="memberJoinBtn" style="margin: 5%;" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle" onclick="goMemberJoin()"> 회원가입</button>
	                                </div>
                                </div>	
                                <div class="widget-content-right header-user-info ml-3">
                                    <button type="button" class="btn-shadow p-1 btn btn-primary btn-sm show-toastr-example">
                                        <i class="fa text-white fa-calendar pr-1 pl-1"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
			</div>
		</div>
		<div class="app-main">
			<div class="app-sidebar sidebar-shadow">
				<div class="scrollbar-sidebar">
				<form name="frmUrl" action="" method="get">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lightbulb" viewBox="0 0 16 16">
							  <path d="M2 6a6 6 0 1 1 10.174 4.31c-.203.196-.359.4-.453.619l-.762 1.769A.5.5 0 0 1 10.5 13a.5.5 0 0 1 0 1 .5.5 0 0 1 0 1l-.224.447a1 1 0 0 1-.894.553H6.618a1 1 0 0 1-.894-.553L5.5 15a.5.5 0 0 1 0-1 .5.5 0 0 1 0-1 .5.5 0 0 1-.46-.302l-.761-1.77a1.964 1.964 0 0 0-.453-.618A5.984 5.984 0 0 1 2 6zm6-5a5 5 0 0 0-3.479 8.592c.263.254.514.564.676.941L5.83 12h4.342l.632-1.467c.162-.377.413-.687.676-.941A5 5 0 0 0 8 1z"/>
							</svg>
							취업정보</li>
								<li>
									<a href="<%=request.getContextPath() %>/company/list.do"> 
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
										  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
										</svg>
									기업 정보</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/jobnews/list.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									취업 뉴스</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/successReview/successReviewList.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									취업 성공 후기</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/survey/list.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									설문조사</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/jobfair/list.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
								  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
								</svg>
									취업 설명회</a>
								</li>
								
								<li class="app-sidebar__heading">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lightbulb" viewBox="0 0 16 16">
								  <path d="M2 6a6 6 0 1 1 10.174 4.31c-.203.196-.359.4-.453.619l-.762 1.769A.5.5 0 0 1 10.5 13a.5.5 0 0 1 0 1 .5.5 0 0 1 0 1l-.224.447a1 1 0 0 1-.894.553H6.618a1 1 0 0 1-.894-.553L5.5 15a.5.5 0 0 1 0-1 .5.5 0 0 1 0-1 .5.5 0 0 1-.46-.302l-.761-1.77a1.964 1.964 0 0 0-.453-.618A5.984 5.984 0 0 1 2 6zm6-5a5 5 0 0 0-3.479 8.592c.263.254.514.564.676.941L5.83 12h4.342l.632-1.467c.162-.377.413-.687.676-.941A5 5 0 0 0 8 1z"/>
								</svg>
								취업 성공 툴</li>
								
								<li>
									<a href="<%=request.getContextPath() %>/introduction/insertForm.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									자기소개서 작성</a>
								</li>
								<% if(!memberId.equals("")) { %>
								<li>
									<a href="<%=request.getContextPath() %>/resume/insert.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									이력서 작성</a>
								</li>
								<% } %>
								<li>
									<a href="https://speller.cs.pusan.ac.kr/">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									맞춤법 검사</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/limit/list.do">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									글자수 세기</a>
								</li>
								
								<li class="app-sidebar__heading">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lightbulb" viewBox="0 0 16 16">
								  <path d="M2 6a6 6 0 1 1 10.174 4.31c-.203.196-.359.4-.453.619l-.762 1.769A.5.5 0 0 1 10.5 13a.5.5 0 0 1 0 1 .5.5 0 0 1 0 1l-.224.447a1 1 0 0 1-.894.553H6.618a1 1 0 0 1-.894-.553L5.5 15a.5.5 0 0 1 0-1 .5.5 0 0 1 0-1 .5.5 0 0 1-.46-.302l-.761-1.77a1.964 1.964 0 0 0-.453-.618A5.984 5.984 0 0 1 2 6zm6-5a5 5 0 0 0-3.479 8.592c.263.254.514.564.676.941L5.83 12h4.342l.632-1.467c.162-.377.413-.687.676-.941A5 5 0 0 0 8 1z"/>
								</svg>
								고객센터</li>
								<%if(!adminId.equals("")){ %>
									<li>
									<a href="javascript:void(0);" onclick="openInqueryWindow()"> 
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-headset" viewBox="0 0 16 16">
									  <path d="M8 1a5 5 0 0 0-5 5v1h1a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V6a6 6 0 1 1 12 0v6a2.5 2.5 0 0 1-2.5 2.5H9.366a1 1 0 0 1-.866.5h-1a1 1 0 1 1 0-2h1a1 1 0 0 1 .866.5H11.5A1.5 1.5 0 0 0 13 12h-1a1 1 0 0 1-1-1V8a1 1 0 0 1 1-1h1V6a5 5 0 0 0-5-5z"/>
									</svg>										
	
										1:1 실시간 채팅</a>
									</li>
								<%}else{ %>
									<li>
									<a href="javascript:void(0);" onclick="openInqueryWindow()"> 
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-headset" viewBox="0 0 16 16">
							  <path d="M8 1a5 5 0 0 0-5 5v1h1a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V6a6 6 0 1 1 12 0v6a2.5 2.5 0 0 1-2.5 2.5H9.366a1 1 0 0 1-.866.5h-1a1 1 0 1 1 0-2h1a1 1 0 0 1 .866.5H11.5A1.5 1.5 0 0 0 13 12h-1a1 1 0 0 1-1-1V8a1 1 0 0 1 1-1h1V6a5 5 0 0 0-5-5z"/>
							</svg>
									1:1 실시간 채팅</a>
									</li>
								<%} %>
								<li>
								<a href="<%=request.getContextPath() %>/notis/notisList.do"> 
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									공지사항</a>
								</li>
								<li>
								<a href="<%=request.getContextPath() %>/faq/faq.do"> 
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									FAQ</a>
								</li>
								<li>
								<a href="<%=request.getContextPath() %>/funboard/list.do"> 
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
									</svg>
									자유게시판</a>
								</li>
						</ul>
					</div>
				</form>
				</div>
			</div>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<!-- 프레임 올자리 -->
		  <div class="app-main__outer">
			<iframe name="freamUrl" src="snow/snow.html" style="width: 100%; height: 100%; border: none;">
			</iframe>
            </div>		
		</div>
	</div>
	<script type="text/javascript" src="./assets/scripts/main.js"></script>
</body>
</html>
