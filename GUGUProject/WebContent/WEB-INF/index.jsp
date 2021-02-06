<%@page import="vo.FaqVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("memberVO") != null){
		System.out.println("현재 로그인 상태");
	}else{
		System.out.println("현재 로그아웃 상태");
	}
	String fullPath = request.getRequestURI();
	String path = fullPath.substring(fullPath.length()-9, fullPath.length());
	System.out.println("경로"+path);
%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  
  <title>구해죠!</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700" rel="stylesheet">

	<!-- Vendor CSS Files -->
	<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
	<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
	<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="assets/vendor/aos/aos.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	 <!-- Template Main CSS File -->
	<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>

<!-- ======= Top Bar ======= -->
<div id="topbar" style="margin-top: 1%;" class="d-none d-lg-flex align-items-end fixed-top topbar-transparent">
	<div class="container d-flex justify-content-end">
	 <div class="widget-heading" style="margin-top: 3%;">
	 	<%
	 		if(session.getAttribute("memberVO") != null){
	 	%>	
      			<a href="logout.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 로그아웃</button></a>
      			<a href="member/memberPage.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 마이페이지</button></a>
	 	<%		
	 		}else if(session.getAttribute("adminVO") != null){
	 	%>  	
	      		<a href="logout.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 로그아웃</button></a>
	      		<a href="admin/adminPage.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 관리자 페이지</button></a>
	 	<%		
	 		}else{ // 로그인 하지 않은 상태 일때
		      %>
    			<a href="login.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 로그인</button></a>
				<a href="member/member.do"><button class="mb-2 mr-2 btn-transition btn btn-outline-primary bi bi-person-circle"> 회원가입</button></a>
	    <%
    	    } // else문 닫기  
      	%>
		</div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top header-transparent">
    <div class="container d-flex align-items-center">
    <!-- 관리자 로그인 여기 있어요 -->
    <a href="adminLogin.do"><i class="bi bi-bell" style="color: white;"></i></a>
	      <h1 class="logo mr-auto"><a href="index.do">구해줘요~!</a></h1>
      <nav class="main-nav d-none d-lg-block">
        <ul>
          <li class="active"><a href="/GUGUProject/main.do">Detail</a></li>
          <li><a href="#about">취업 성공 후기</a></li>
          <li><a href="#services">취업 성공 툴</a></li>
          <li><a href="#portfolio">기업 리스트</a></li>
          <li><a href="#team">개발 팀원</a></li>
          <li><a href="#footer">사용된툴</a></li>
        </ul>
      </nav><!-- .main-nav-->
    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="clearfix">
    <div class="container d-flex h-100">
      <div class="row justify-content-center align-self-center" data-aos="fade-up">
        <div class="col-md-6 intro-info order-md-first order-last" data-aos="zoom-in" data-aos-delay="100">
          <h2>취업이 어려우시다구요?<br><br>코로나19로 지친 여러분들을 위해서 저희가 준비 했습니다!<br><br><span>개인 맞춤형 기업 소개를 해주는 구해죠!를 찾아보세요!</span></h2>
<!--           <div> -->
<!--             <a href="#about" class="btn-get-started scrollto">취업에 필요한 정보를 알아보아요!</a> -->
<!--           </div> -->
        </div>

        <div class="col-md-6 intro-img order-md-last order-first" data-aos="zoom-out" data-aos-delay="200">
          <img src="assets/img/intro-img.svg" alt="" class="img-fluid">
        </div>
      </div>

    </div>
  </section><!-- End Hero -->

  <main id="main">
    <!-- ======= About Section ======= -->
    <section id="about" class="about">

      <div class="container" data-aos="fade-up">
        <div class="row">

          <div class="col-lg-5 col-md-6">
            <div class="about-img" data-aos="fade-right" data-aos-delay="100">
              <img src="images/univerStudent.jpg" alt="">
            </div>
          </div>

          <div class="col-lg-7 col-md-6">
            <div class="about-content" data-aos="fade-left" data-aos-delay="100">
              <h2>취업정보가 전무했던 대학생</h2>
              <h3>‘그냥 학교 다니다 보면, 어떻게든 때 돼서 내가 갈 직장 하나쯤은 있겠지?’라는 생각으로 대학을 다녔다. </h3>
              <p>갈수록 경쟁이 치열해지고 구사 가능한 외국어 한두 개쯤, 상장 한 두 개쯤은 가지고 취업 시장에 뛰어드는 고스펙자들이 넘쳐나는 마당에 그렇게 앞날을 기다리고 있었다.</p>
              <p>아니나 다를까, 4학년이 되면서 처음 뛰어든 인턴 시장 경쟁률은 최소 50:1~100:1에 육박했다. 20여 개 이상의 자기소개서를 쓰고 고배를 마셨고, 운 좋게 면접에 가면 준비가 덜 된 불안과 긴장으로 어렵사리 잡은 기회를 놓치기 일쑤였다. 우여곡절 끝에 IT 회사의 체험형 인턴 6개월 자리를 추가 합격으로 얻게 됐다.</p>
              <ul>
                <li><i class="ion-android-checkmark-circle"></i>구해죠! 사이트를 통해 취업준비의 서두, 정보를 얻다</li>
                <li><i class="ion-android-checkmark-circle"></i>정보력으로 결실을 얻다.</li>
                <li><i class="ion-android-checkmark-circle"></i>마치며...</li>
              </ul>
               <div>
           		 <a href="/GUGUProject/successReview/successReviewList.do" class="btn-get-started scrollto">취업 성공 후기 보러가기</a>
          		</div>
            </div>
          </div>
        </div>
      </div>

    </section><!-- End About Section -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services section-bg">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>취업 성공을 위한 툴</h3>
          <p>살다보면 실수를 할 수도 있습니다. 하지만, 중요한 순간에서 하면 안되겠죠?</p>
        </header>

        <div class="row">

          <div class="col-md-6 col-lg-4 wow bounceInUp" data-aos="zoom-in" data-aos-delay="100">
            <div class="box">
              <div class="icon" style="background: #fceef3;"><i class="ion-ios-analytics-outline" style="color: #ff689b;"></i></div>
              <h4 class="title"><a href="https://speller.cs.pusan.ac.kr/">맞춤법 검사</a></h4>
               <p class="description">앗! 오타를 찾아보아요!</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4" data-aos="zoom-in" data-aos-delay="200">
            <div class="box">
              <div class="icon" style="background: #fff0da;"><i class="ion-ios-bookmarks-outline" style="color: #e98e06;"></i></div>
              <h4 class="title"><a href="/GUGUProject/limit/list.do">글자수 세기</a></h4>
              <p class="description">한글 문서로 작성하는데 글자수를 모르겠다구요? 글자수와 공백까지 세어드립니다.</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-4" data-aos="zoom-in" data-aos-delay="300">
            <div class="box">
	              <div class="icon" style="background: #e6fdfc;">
	              	<i class="ion-ios-paper-outline" style="color: #3fcdc7;"></i>
	              </div>
	              <h4 class="title"><a href="/GUGUProject/introduction/insertForm.do">자소서</a></h4>
              <p class="description">앗! 로그인 안 잊으셨죠? 이곳에서 자소서를 작성하고 컨펌도 받고 지원도 해보세요!	</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow" data-aos="zoom-in" data-aos-delay="100">
            <div class="box">
              <div class="icon" style="background: #eafde7;"><i class="ion-ios-speedometer-outline" style="color:#41cf2e;"></i></div>
              <h4 class="title"><a href="/GUGUProject/resume/list.do">이력서</a></h4>
              <p class="description">기업 지원의 첫 걸음! 이력서!</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-4" data-aos="zoom-in" data-aos-delay="200"">
        <div class=" box">
            <div class="icon" style="background: #e1eeff;"><i class="ion-ios-world-outline" style="color: #2282ff;"></i></div>
            <h4 class="title"><a href="/GUGUProject/funboard/list.do">자유게시판</a></h4>
            <p class="description">다른 사람들과 의견을 공유해 보세요!</p>
          </div>
        </div>
        <div class="col-md-6 col-lg-4" data-aos="zoom-in" data-aos-delay="300">
          <div class="box">
            <div class="icon" style="background: #ecebff;"><i class="ion-ios-clock-outline" style="color: #8660fe;"></i></div>
            <h4 class="title"><a href="/GUGUProject/company/list.do">맞춤형 기업 </a></h4>
            <p class="description">학교, 경력, 기간 등 본인 맞춤으로 원하는 기업을 볼 수있도록 구성된 검색 기능을 사용해 보세요.	</p>
          </div>
        </div>
      </div>
    </section><!-- End Services Section -->

    <!-- ======= Why Us Section ======= -->
    <section id="why-us" class="why-us">
      <div class="container-fluid" data-aos="fade-up">

        <header class="section-header">
          <h3>우리도 할 수 있다!</h3>
          <p>면접에 대한 부담감을 줄일 수 있도록 여러 프로그램들에 참여해보세요.
          	복장 부터 자세, 인사 등 하나 하나 알려드립니다.</p>
        </header>

        <div class="row">

          <div class="col-lg-6" data-aos="zoom-in" data-aos-delay="100">
            <div class="why-us-img">
              <img src="images/InterviewSuccess.jpg" alt="" class="img-fluid">
            </div>
          </div>

          <div class="col-lg-6">
            <div class="why-us-content">
              <p>취업 성공을 향한 실질적인 최종 관문은 바로 면접이다. </p>
              <p>
				면접 준비를 할 때는 여러 번 모의면접을 해본 후, 실전 감각을 익히는 것이 필요 하다. 
				취업 준비생들의 실전 감각 향상을 도와주고자 취업지원팀에서 취업준비 집중기간을 맞아 유형별
				모의 면접 특강을 진행한다.
              </p>

              <div class="features clearfix" data-aos="fade-up" data-aos-delay="100">
                <i class="fa fa-diamond" style="color: #f058dc;"></i>
                <h4>역량/인성 면접</h4>
                <p>모의면접에 참여한 지원자들이 받은 질문을 통해 계속되는 꼬리 질문으로 면접이 진행된다.</p>
              </div>

              <div class="features clearfix" data-aos="fade-up" data-aos-delay="200">
                <i class="fa fa-object-group" style="color: #ffb774;"></i>
                <h4>토론 면접</h4>
                <p>면접 대상자 확인 및 주제 선정 시간을 가지고, 주제 분석 및 토론, 토론 진행, 마무리 단계로  진행이 된다.</p>
              </div>

              <div class="features clearfix" data-aos="fade-up" data-aos-delay="300">
                <i class="fa fa-language" style="color: #589af1;"></i>
                <h4>PT 면접</h4>
                <p>PT 면접은 현장에서 발표할 주제를 부여받고, 정해진 시간 동안 면접관들 앞에서 발표하는 방식으로 진행된다.
                이번 모의 면접에서는 '가고자하는 회사','부서에 입사해야 하는 이유와 자신이 어떤 준비를 했는지를 1~2분 이내로 발표하라'
                라는 주제 등 으로 진행된다.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section><!-- End Why Us Section -->

    <!-- ======= Call To Action Section ======= -->
    <section id="call-to-action" class="call-to-action">
      <div class="container" data-aos="zoom-out">
        <div class="row">
          <div class="col-lg-9 text-center text-lg-left">
            <h3 class="cta-title">기업 검색하러 가기!</h3>
            <p class="cta-text">분야별로 찾아보세요!</p>
          </div>
          <div class="col-lg-3 cta-btn-container text-center">
            <a class="cta-btn align-middle" href="/GUGUProject/company/list.do">기업 검색</a>
          </div>
        </div>

      </div>
    </section><!--  End Call To Action Section -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio section-bg">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3 class="section-title">기업 이미지</h3>
        </header>

        <div class="row" data-aos="fade-up" data-aos-delay="100">
          <div class="col-lg-12">
            <ul id="portfolio-flters">
              <li data-filter="*" class="filter-active">게임 회사</li>
              <li data-filter=".filter-app">개발자</li>
              <li data-filter=".filter-card">풀스택</li>
              <li data-filter=".filter-web">인공지능</li>
            </ul>
          </div>
        </div>

        <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="200">

          <div class="col-lg-4 col-md-6 portfolio-item filter-app" >
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/app1.JPG" class="img-fluid" alt="네오필" style="width: 450px;height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">네오필 게임 회사</a></h4>
                <p>던파를 만든 사람들</p>
                <div>
                  <a href="https://career.nexon.com/user/recruit/introduce/dnf?joinCorp=NO" class="link-details" title="More Details">
                  <i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/web3.jpg" class="img-fluid" alt="" style="width: 450px;height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">Web 3</a></h4>
                <p>Web</p>
                <div>
                  <a href="#" class="link-details" title="More Details"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-app" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/app2.jpg" class="img-fluid" alt="네이버" style="width: 450px;height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">Naver</a></h4>
                <p>Naver</p>
                <div>
                  <a href="https://recruit.navercorp.com/naver/recruitMain" class="link-details" title="More Details">
                  <i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/card2.JPG" class="img-fluid" alt="레모나" style="width: 450px;height: 130px;">
              <div class="portfolio-info">
                <h4><a href="https://www.kyungnampharm.com:6519/recruit/index.asp#section1">레모나</a></h4>
                <p>레모나</p>
                <div>
                  <a href="https://www.kyungnampharm.com:6519/recruit/index.asp#section1" class="link-details" title="More Details">
                  <i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/web2.JPG" class="img-fluid" alt="한국 전자금융" style="width: 450px;height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">한국 전자금융</a></h4>
                <p>한국 전자금융</p>
                <div>
                  <a href="https://www.nicetcm.co.kr/front/sub/sub0502.htm" class="link-details" title="More Details">
                  <i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-app" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/app3.JPG" class="img-fluid" alt="다나와" style="width:450px; height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">다나와</a></h4>
                <p>다나와</p>
                <div>
                  <a href="https://recruit.danawa.com/" class="link-details" title="More Details"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/card1.JPG" class="img-fluid" alt="대덕인재개발원" style="width:450px; height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">대덕 인재개발원</a></h4>
                <p>대덕 인재개발원</p>
                <div>
                  <a href="https://www.ddit.or.kr/" class="link-details" title="More Details"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/card3.JPG" class="img-fluid" alt="배달의 민족" style="width:450px; height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">배달의 민족</a></h4>
                <p>배달의 민족</p>
                <div>
                  <a href="https://www.woowahan.com/#/recruit/tech" class="link-details" title="More Details"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="assets/img/portfolio/web1.jpg" class="img-fluid" alt="kakao" style="width:450px; height: 130px;">
              <div class="portfolio-info">
                <h4><a href="portfolio-details.html">kakao</a></h4>
                <p>kakao</p>
                <div>
                  <a href="https://careers.kakao.com/index" class="link-details" title="More Details"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Section -->

    <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="testimonials">
      <div class="container" data-aos="zoom-in">

        <header class="section-header">
          <h3>성공한 사람들의 명언</h3>
        </header>

        <div class="row justify-content-center">
          <div class="col-lg-8">

            <div class="owl-carousel testimonials-carousel">

              <div class="testimonial-item">
                <img src="images/steve.JPG" class="testimonial-img" alt="">
                <h3>스티브 잡스</h3>
                <h4>애플 CEO</h4>
                <p>
                  	단순함을 얻기란 복잡함을 얻기보다 어렵습니다.
                  	 무언가를 단순하게 만들기 위해서는 생각을 깔끔히 정리해야 합니다. 
                  	 이 과정은 어렵지만 한번 거치면 당신은 무엇이든 할 수 있습니다.
                </p>
              </div>

              <div class="testimonial-item">
                <img src="images/larry.JPG" class="testimonial-img" alt="">
                <h3>래리 페이지</h3>
                <h4>구글 CEO</h4>
                <p>
                	작은 사람들이 모인 팀도 매우 큰 영향을 행사할 수도 있다.
                </p>
              </div>

              <div class="testimonial-item">
                <img src="images/lee.JPG" class="testimonial-img" alt="">
                <h3>이건희</h3>
                <h4>삼성 CEO</h4>
                <p>
                	작은 것을 탐내다가 큰 것을 잃는다.
                	무엇이 큰 것인가를 판단하라.
                </p>
              </div>
            </div>

          </div>
        </div>

      </div>
    </section><!-- End Testimonials Section -->


    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing section-bg wow fadeInUp">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>도와줘요!</h3>
          <p></p>
        </header>

        <div class="row flex-items-xs-middle flex-items-xs-center">

          <!-- Basic Plan  -->
          <div class="col-xs-12 col-lg-4" data-aos="fade-up" data-aos-delay="100">
            <div class="card">
              <div class="card-header">
                <h4>1:1 실시간 채팅 방</h4>
              </div>
              <div class="card-block">
                <h4 class="card-title">
                	긴급한 문의가 있으신가요?
                </h4>
                <ul class="list-group">
                  <li class="list-group-item">1:1 실시간 채팅방을 통해</li>
                  <li class="list-group-item">신속한 질의응답을 도와드립니다.</li>
                  <li class="list-group-item">운영 시간 : A.M 08:00 ~ P.M 09:00</li>
                </ul>
                <a href="/GUGUProject/inquery/inquery.do" class="btn">채팅하러 가기</a>
              </div>
            </div>
          </div>

          <!-- Regular Plan  -->
          <div class="col-xs-12 col-lg-4" data-aos="fade-up" data-aos-delay="200">
            <div class="card">
              <div class="card-header">
                <h4>취업 설명회</h4>
              </div>
              <div class="card-block">
                <h4 class="card-title">
                 	설명회 참석은 필수!
                </h4>
                <ul class="list-group">
                  <li class="list-group-item">취업을 하시고 싶으시다고요!?</li>
                  <li class="list-group-item">그렇다면 군말없이 설명회에 참석하셔야죠!!!</li>
                  <li class="list-group-item">지금 바로 기회를 잡으세요~</li>
                </ul>
                <a href="/GUGUProject/company/list.do" class="btn">설명회 일정 보러가기</a>
              </div>
            </div>
          </div>

          <!-- Premium Plan  -->
          <div class="col-xs-12 col-lg-4" data-aos="fade-up" data-aos-delay="300">
            <div class="card">
              <div class="card-header">
                <h4>취업뉴스</h4>
              </div>
              <div class="card-block">
                <h4 class="card-title">
                  	취업에 대한 정보와 이슈는 여기로!
                </h4>
                <ul class="list-group">
                  <li class="list-group-item">모든 취준생, 직장인들이 궁금해할만한 </li>
                  <li class="list-group-item">국내 취업시장 뉴스와 통계를 제공합니다.</li>
                  <li class="list-group-item">취업뉴스는 구해죠에서!</li>
                </ul>
                <a href="/GUGUProject/jobnews/list.do" class="btn">취업뉴스 보러가기</a>
              </div>
            </div>
          </div>
        </div>
      </div>

    </section><!-- End Pricing Section -->

    <!-- ======= F.A.Q Section ======= -->
<%
	String memberId = session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");   
	List<FaqVO> list = (List<FaqVO>)request.getAttribute("list");
	String msg = request.getParameter("msg") == null? "" : request.getParameter("msg"); 
%>
    <section id="faq" class="faq">
      <div class="container" data-aos="fade-up">
        <header class="section-header">
          <h3>FAQ</h3>
          <p>여러 사람들이 자주 하는 질문을 볼 수 있는 공간이에요.</p>
        </header>
        <ul id="faq-list" data-aos="fade-up" data-aos-delay="100">
   <% 
		int count=1;
		for(int index=0; index<list.size(); index++){
   %>
         <li>
           <a data-toggle="collapse" class="collapsed" href="#faq1"><%=list.get(index).getQuestion() %><i class="ion-android-remove"></i></a>
           <div id="faq1" class="collapse" data-parent="#faq-list">
             <p> <%=list.get(index).getAnswer() %> </p>
           </div>
         </li>
	<%
		count++;
		}
	%>
        </ul>

      </div>
    </section><!-- End F.A.Q Section -->
  </main><!-- End #main -->

    <!-- ======= Team Section ======= -->
    <section id="team" class="team section-bg">
      <div class="container" data-aos="fade-up">
        <div class="section-header">
          <h3>구해죠! 를 구한 팀</h3>
          <p>코로나19로 지친 여러분들의 진로를 개발팀에서 지원해드립니다.</p>
        </div>

        <div class="row">

          <div class="col-lg-3 col-md-6" data-aos="fade-up" data-aos-delay="100">
            <div class="member">
              <img src="images/sje.JPG" class="img-fluid" alt="">
              <div class="member-info">
                <div class="member-info-content">
                  <h4>PL</h4>
                  <span>Song Ji-eun</span>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6" data-aos="fade-up" data-aos-delay="200" >
            <div class="member">
              <img src="images/ksy.jpg" class="img-fluid" alt="" style="height: 200px;">
              <div class="member-info">
                <div class="member-info-content">
                  <h4>AA</h4>
                  <span>Kim So-yeon</span>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6" data-aos="fade-up" data-aos-delay="300">
            <div class="member">
              <img src="images/byw.jpg" class="img-fluid" alt="">
              <div class="member-info">
                <div class="member-info-content">
                  <h4>UA</h4>
                  <span>Byun Young-woon</span>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6" data-aos="fade-up" data-aos-delay="400">
            <div class="member">
              <img src="images/pyj.jpg" class="img-fluid" alt="">
              <div class="member-info">
                <div class="member-info-content">
                  <h4>DA</h4>
                  <span>Park Ji-young</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section><!-- End Team Section -->
    
    <!-- ======= Clients Section ======= -->
    <section id="clients" class="clients">
      <div class="container" data-aos="zoom-in">

        <header class="section-header">
          <h3>사용된 툴</h3>
        </header>
        <div class="owl-carousel clients-carousel">
          <img src="assets/img/clients/client-1.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-2.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-3.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-4.png" alt=""  style="height: 150px;">
          <img src="assets/img/clients/client-5.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-6.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-7.png" alt="" style="height: 150px;">
          <img src="assets/img/clients/client-8.png" alt="" style="height: 150px;">
        </div>

      </div>
    </section><!-- End Clients Section -->
    
    
  <!-- ======= Footer ======= -->
  <footer id="footer" class="section-bg">
    <div class="container">
      <div class="copyright">
		GUGUProject
      </div>
    </div>
  </footer><!-- End  Footer -->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
</body>
</html>