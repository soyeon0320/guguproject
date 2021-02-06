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
<link href="<%=request.getContextPath() %>/assets/css/main.css" rel="stylesheet">
</head>
<script type="text/javascript">
$(document).ready(function(){
	$('form[name="frmUrl"] li a').on('click', function(e){
		e.preventDefault();
		$('iframe[name="freamUrl"]').attr("src" , $(this).attr("href"));
	});
});


function openInqueryWindow() {
	var popupWidth = 600;
	var popupHeight = 550;

	var popupX = (window.screen.width-popupWidth)/2;
	var popupY = (window.screen.height-popupHeight)/2;
	
		window.open("<%=request.getContextPath() %>/inquery/inqueryAdmin.do", '', 'width='+popupWidth+', height='+popupHeight+', left='+popupX+', top='+popupY+'');
}

</script>
<body>
	<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<div class="app-header header-shadow">
			<div class="app-header__logo">
				<div class="Home">
					<a href="<%=request.getContextPath() %>/index.do"> HOME </a>
				</div>
				<div class="header__pane ml-auto">
					<div>
						<button type="button"
							class="hamburger close-sidebar-btn hamburger--elastic"
							data-class="closed-sidebar">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<div class="app-header__mobile-menu">
				<div>
					<button type="button"
						class="hamburger hamburger--elastic mobile-toggle-nav">
						<span class="hamburger-box"> <span class="hamburger-inner"></span>
						</span>
					</button>
				</div>
			</div>
			<div class="app-header__menu">
				<span>
					<button type="button"
						class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
						<span class="btn-icon-wrapper"> <i class="fa fa-ellipsis-v fa-w-6"></i>
						</span>
					</button>
				</span>
			</div>
			<div class="app-header__content">
				<div class="app-header-left">
					<div class="search-wrapper">
						<div class="input-holder">
							<input type="text" class="search-input"
								placeholder="Type to search">
							<button class="search-icon">
								<span></span>
							</button>
						</div>
						<button class="close"></button>
					</div>
				</div>
			      <div class="app-header-right">
                    <div class="header-btn-lg pr-0">
                        <div class="widget-content p-0">
                            <div class="widget-content-wrapper">
                             <div class="widget-content-left  ml-3 header-user-info">
                                    <div class="widget-heading" style="margin-right: 5%;">
										<input type="button" value="로그아웃" style="margin: 5%;" class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle">
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
							<li class="app-sidebar__heading">회원관리</li>
								<li>
									<a href="<%=request.getContextPath() %>/member/list.do"> <i class="metismenu-icon pe-7s-rocket"></i>회원 목록</a>
								</li>
							
							<li class="app-sidebar__heading">취업정보</li>
								<li>
									<a href="<%=request.getContextPath() %>/company/adminList.do"> <i class="metismenu-icon pe-7s-rocket"></i>기업 관리</a>
									<a href="<%=request.getContextPath() %>/jobnews/managerlist.do"> <i class="metismenu-icon pe-7s-rocket"></i>취업 뉴스</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/successReview/successReviewList.do"> <i class="metismenu-icon pe-7s-rocket"></i>취업 성공 후기</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/survey/managerlist.do"> <i class="metismenu-icon pe-7s-rocket"></i>설문조사</a>
								</li>
								<li>
									<a href="<%=request.getContextPath() %>/jobfair/managerlist.do"> <i class="metismenu-icon pe-7s-rocket"></i>채용 설명회</a>
								</li>
								
								<li class="app-sidebar__heading">고객센터</li>
								<li>
								<a href="javascript:void(0);" onclick="openInqueryWindow()">
									<i class="metismenu-icon pe-7s-display2"></i>1:1 실시간 채팅</a>
								</li>
								<li>
								<a href="<%=request.getContextPath() %>/notis/notisAdminList.do"> 
									<i class="metismenu-icon pe-7s-display2"></i>공지사항</a>
								</li>
								<li>
								<a href="<%=request.getContextPath() %>/faq/faqList.do"> 
									<i class="metismenu-icon pe-7s-display2"></i>FAQ</a>
								</li>
								<li>
								<a href="<%=request.getContextPath() %>/funboard/list.do"> 
									<i class="metismenu-icon pe-7s-display2"></i>자유게시판</a>
								</li>
						</ul>
					</div>
				</form>
				</div>
			</div>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<!-- 프레임 올자리 -->
		  <div class="app-main__outer">
			<iframe name="freamUrl" src="" style="width: 100%; height: 100%;">
			</iframe>
            </div>			
		</div>
	</div>
	<script type="text/javascript" src="../assets/scripts/main.js"></script>
</body>
<script type="text/javascript">
$("input[value='로그아웃']").on("click",function(event){
	window.location.href = "<%=request.getContextPath() %>/logout.do";
});
</script>
</html>
