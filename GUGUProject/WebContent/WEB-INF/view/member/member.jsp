<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String idCheck = request.getParameter("IdCheck");
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="UTF-8">
   <title>구해죠! : 회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/new_main.css">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">
	var id = document.querySelector('#id');
	
	function temp(event){
		event.preventDefault();
		var userId = $('input[name="memberId"]').val();
		if(userId == ""){
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return;
		}
		
		var idPattern = /[a-zA-Z0-9_-]{5,20}/;
		if(!idPattern.test(frm.id.value)){
			alert("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
			frm.memberId.focus();
			return;
		}
		
		var comId="";
		<% for(int i = 0; i < list.size(); i++){%>
			if(userId == "<%=list.get(i).getMemberId()%>" && idPattern.test(frm.id.value)){
				alert("사용할 수 없는 아이디 입니다.");
				frm.memberId.focus();
				return;
			}else if(userId != "<%=list.get(i).getMemberId()%>"){
				alert("사용 가능한 아이디 입니다.");
				frm.pswd1.focus();
				return;
			}
			
		<%}%>
	}
	function memberInsert(){
		if(frm.pswd1.value == ""){
			alert("비밀번호를 입력하세요");
			frm.pswd1.focus();
			return;
		}else if(frm.pswd2.value == ""){
			alert("비밀번호 확인을 써주세요")
			frm.pswd2.focus();
			return;
		}else if(frm.name.value == ""){
			alert("이름을 입력하세요.");
			frm.name.focus();
			return;
		}else if(frm.yy.value == ""){
			alert("년/연도를 입력하세요.");
			frm.yy.focus();
			return;
		}
		
		// select 값
		
		if(frm.dd.value == ""){
			alert("요일을 입력하세요.");
			frm.dd.focus();
			return;
		}else if(frm.postcode.value == ""){
			alert("우편번호를 찾아주세요.");
			return;
		}else if(frm.address.value == ""){
			alert("주소를 입력하세요.");
			return;
		}else if(frm.detailAddress.value == ""){
			alert("상세 주소를 입력하세요.");
			return;
		}
		frm.submit();
	}
</script>

 </head>
<body>
<form name="frm" method="post"> 
	<!-- wrapper -->
	<div id="wrapper">
	    <!-- content-->
	<div id="content">
	    <!-- ID -->
	<div>
	    <h3 class="join_title">
	        <label for="id">아이디</label>
	        <button class="mb-2 mr-2 btn btn-primary" style=" margin-left: 55%; width: 30%;" onclick="temp(event)" name="idCheck">아이디 중복체크</button>
	    </h3>
	    <span class="box int_id">
	        <input type="text" name="memberId" id="id" class="int" maxlength="20">
	    </span>
	    <span class="error_next_box"></span>
	</div>
	<!-- PW1 -->
	<div>
	    <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
	    <span class="box int_pass">
	        <input type="text" name="pswd1" id="pswd1" class="int" maxlength="20">
	        <span id="alertTxt">사용불가</span>
	        <img src="../assets/img/member/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
	    </span>
	    <span class="error_next_box"></span>
	</div>
	<!-- PW2 -->
	<div>
	    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
	    <span class="box int_pass_check">
	        <input type="text" id="pswd2" class="int" maxlength="20">
	        <img src="../assets/img/member/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
	    </span>
	    <span class="error_next_box"></span>
	</div>
	<!-- NAME -->
	<div>
	    <h3 class="join_title"><label for="name">이름</label></h3>
	    <span class="box int_name">
	        <input type="text" name="name" id="name" class="int" maxlength="20">
	    </span>
	    <span class="error_next_box"></span>
	</div>
	<!-- BIRTH -->
	<div>
	    <h3 class="join_title"><label for="yy">생년월일</label></h3>
	
	    <div id="bir_wrap">
	        <!-- BIRTH_YY -->
	<div id="bir_yy">
	    <span class="box">
	        <input type="text" name="yy" id="yy" class="int" maxlength="4" placeholder="년(4자)">
	    </span>
	</div>
	<!-- BIRTH_MM -->
	<div id="bir_mm">
	    <span class="box">
	        <select name="mm" id="mm" class="sel">
	            <option>월</option>
	            <option value="01">1</option>
	            <option value="02">2</option>
	            <option value="03">3</option>
	            <option value="04">4</option>
	            <option value="05">5</option>
	            <option value="06">6</option>
	            <option value="07">7</option>
	            <option value="08">8</option>
	            <option value="09">9</option>                                    
	            <option value="10">10</option>
	            <option value="11">11</option>
	            <option value="12">12</option>
	        </select>
	    </span>
	</div>
	<!-- BIRTH_DD -->
	        <div id="bir_dd">
	            <span class="box">
	                <input type="text" name="dd" id="dd" class="int" maxlength="2" placeholder="일">
	            </span>
	        </div>
	    </div>
	    <span class="error_next_box"></span>    
	</div>
	
	<!-- GENDER -->
	<div>
	    <h3 class="join_title"><label for="gender">성별</label></h3>
	    <span class="box gender_code">
	        <select name="gender" id="gender" class="sel">
	            <option value="">성별</option>
	            <option value="M">남자</option>
	            <option value="F">여자</option>
	        </select>                            
	    </span>
	    <span class="error_next_box">필수 정보입니다.</span>
	</div>
	<!-- Addr -->
	
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" style="margin-top: 5%; background-color: #BCF5A9;"><br>
	
	<div>
	    <h3 class="join_title"  style="width: 200px;"><label for="email" >우편번호</label></h3>
	    <span class="box int_email" style="width: 200px;">
	        <input type="text" name="postcode" id="sample6_postcode" class="int" maxlength="5" readonly="readonly">
	    </span>
	</div>
	<div>    
	    <h3 class="join_title"><label for="email">동</label></h3>
	    <span class="box int_email">
	        <input type="text" name="extraAddress" id="sample6_extraAddress" class="int" readonly="readonly">
	    </span>
	</div>

	<div>
	    <h3 class="join_title"><label for="email">주소</label></h3>
	    <span class="box int_email">
	        <input type="text" name="address" id="sample6_address" class="int" placeholder="필수입력">
	    </span>
	</div>
	<div>
	    <h3 class="join_title"><label for="email">상세주소</label></h3>
	    <span class="box int_email">
	        <input type="text" name="detailAddress" id="sample6_detailAddress" class="int" placeholder="필수입력">
	    </span>
	</div>
	
	<!-- EMAIL -->
	<div>
	    <h3 class="join_title"><label for="email">이메일</label></h3>
	    <span class="box int_email">
	        <input type="text" name="email" id="email" class="int" maxlength="100" placeholder="필수입력">
	    </span>
	    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
	</div>
	<!-- MOBILE -->
	<div>
	    <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
	    <span class="box int_mobile">
	        <input type="tel" name="mobile" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
	    </span>
	    <span class="error_next_box"></span>    
	</div>
	<!-- JOIN BTN-->
	    <div class="btn_area">
	        <button type="button" id="btnJoin" onclick="memberInsert()">
	            <span>가입하기</span>
	        </button>
	    </div>
	</div> 
	<!-- content-->
	</div> 
 <!-- wrapper -->
    <script src="../assets/js/mainMember.js"></script>
  </form> 
    </body>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = '';
                var extraAddr = ''; 

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</html>