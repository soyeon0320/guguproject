<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	MemberVO memberVO = (MemberVO)request.getAttribute("memberVO");
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
<style>
	body { 
 		margin-left: 5%; 
 		margin-top: 3%; 
 	}
 	th { 
 		text-align: center; 
 	} 
	tr{
		height: 70px;
	}
	
</style>
<script type="text/javascript">
	function modifyInfo() {
		if($("#name").val()==""){
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return;
		}
		
		if(!$('input[name=memberGender]').is(':checked')){
			alert("성별을 선택해주세요.");
			return;
		}
		
		if($("#mobile").val()==""){
			alert("연락처를 입력해주세요.");
			$("#mobile").focus();
			return;
		}
		
		if($("#email").val()==""){
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return;
		}
		
		if($("#memberAddr1").val()=="" || $("#memberAddr2").val()==""){
			alert("상세주소를 입력해주세요.");
			$("#memberAddr2").focus();
			return;
		}
		
		if($("#memberBirth").val()==""){
			alert("생년월을 입력해주세요.");
			return;
		}
		if($.isNumeric($("#memberBirth"))) {
			alert("생년월일은 숫자만 입력이 가능합니다.");
			return;
		}
		if($("#memberBirth").length > 8) {
			alert("생년월일은 8자리로 입력해주세요.");
			return;
		}
		
		alert("등록에 성공하셨습니다!");
		var fm = $('form[name=memInfoFm]');
		fm.submit();
	}
</script>
<body>
	<div class="col-lg-12">
    	<div class="main-card mb-3 card">
         	<div class="card-body" style="width:50%;">
         		<h3 class="card-title" style="font-size: 20px; text-align: center;"><%= memberVO.getMemberId() %>님의 정보 수정</h3>
				<form name="memInfoFm" action="update.do" method="post">
		             <input type="hidden" name="memberId" value="<%= memberVO.getMemberId() %>">
		             <table class="mb-0 table table-hover">
		              	<tr>
		              		<th>이름</th>
		              		<td>
		              		<input type="text" id="name" name="memberName" value="<%= memberVO.getMemberName() %>" class="form-control">
		              		</td>
		              	</tr>
		              	<tr>
		              		<th>성별</th>
		              		<td>
		              		<label for="gender"><input type="radio" id="genderM" name="memberGender" value="M"> M </label> 
		              		<label for="gender"><input type="radio" id="genderF" name="memberGender" value="F"> F </label>
		              		</td>
		              	</tr>
		              	<tr>
		              		<th>연락처</th>
		              		<td>
		              		<input type="text" id="mobile" name="memberPhone" maxlength="13" value="<%= memberVO.getMemberPhone() %>" class="form-control">
		              		</td>
		              	</tr>
		              	<tr>
		              		<th>이메일</th>
		              		<td>
		              			<input type="text" id="email" name="memberEmail" maxlength="100" value="<%= memberVO.getMemberEmail() %>" class="form-control">
		              		</td>
		              	</tr>
						<tr>
							<th>우편번호</th>
							<td>
								<input type="text" name="memberPost" id="memberPost" maxlength="5" class="form-control" readonly>
								<input type="button" class="mb-2 mr-2 btn-transition btn btn-outline-success" onclick="sample6_execDaumPostcode()" value="우편번호 검색"> 
							</td>
						</tr>
 						<tr>
 							<th>동</th> 
 							<td> 
 								 <input type="text" name="memberDong" id="memberDong" class="form-control" readonly>
 							</td> 
 						</tr> 
 		              	<tr> 
 		              		<th>주소</th> 
 		              		<td> 
 		              			<input type="text" id="memberAddr1" name="memberAddr1" value="<%= memberVO.getMemberAddr1() %>" class="form-control" readonly> 
 		              		</td>
 		              	</tr> 
		              	<tr>
		              		<th>상세주소</th>
		              		<td>
		              			<input type="text" id="memberAddr2" name="memberAddr2" value="<%= memberVO.getMemberAddr2() %>" class="form-control">
		              		</td>
		              	</tr>
		              	<tr>
		              		<th>생년월일</th>
		              		<td>
		              			<input type="text" id="memberBirth" name="memberBirth" class="form-control" value="<%= memberVO.getMemberBirth().substring(0, 11) %>">
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;">
								<button type="button" onclick="modifyInfo()" class="mb-2 mr-2 btn-transition btn btn-outline-warning">
								<i class="bi bi-pencil-square"></i> 회원 수정</button>
								<button type="button" onclick="history.go(-1)" class="mb-2 mr-2 btn-transition btn btn-outline-secondary">
								<i class="bi bi-arrow-90deg-left"></i> 내정보</button>
							</td>
						</tr>
					</table>
				</form>
             </div>
          </div>
       </div>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("memberDong").value = extraAddr;
            
            } else {
                document.getElementById("memberDong").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('memberPost').value = data.zonecode;
            document.getElementById("memberAddr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("memberAddr2").focus();
        }
    }).open();
}
</script>
<script src="../assets/js/mainMember.js"></script>
</html>