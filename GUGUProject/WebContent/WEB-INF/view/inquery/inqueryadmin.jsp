<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
String memberId = session.getAttribute("memberId") == null ? "" : (String) session.getAttribute("memberId");
String adminId = session.getAttribute("adminId") == null ? "" : (String) session.getAttribute("adminId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>1:1문의 채팅방</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/GUGUProject/plugins/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/GUGUProject/plugins/css/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/GUGUProject/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="/GUGUProject/plugins/css/OverlayScrollbars.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<style type="text/css">/* Chart.js */
/* @keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}} */
/* .chartjs-render-monitor{animation:chartjs-render-animation 1ms} */
/* .chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{ */
/* 	position:absolute; */
/* 	direction:ltr;left:0;top:0;right:0;bottom:0; */
/* 	overflow:hidden; */
/* 	pointer-events:none; */
/* 	visibility:hidden; */
/* 	z-index:-1 */
/* 	} */
/* .chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0} */
/* .chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0} */
html, body {height:100%; margin:0; padding:0;}
.direct-chat-primary{height:100%;  width: auto; min-width: 500px; float:none; margin: auto; margin-top: 0; margin-bottom: 0;}
.direct-chat-messages, .card-body{height:440px; overflow: auto }
.direct-chat-messages::-webkit-scrollbar {
    display: none; 
}
.direct-chat-text{width: fit-content; word-break: normal; max-width: 300px; margin-left: 60px;}
.direct-chat-timestamp{position: relative; top: 20px; margin-left: 3px; margin-right: 3px; font-size: 0.9em;}
.left .direct-chat-text{
	margin-left: 20px;
    margin-right: 0;
}
.right .direct-chat-text {
    margin-left: 0;
    margin-right: 20px;
}
</style>
</head>
<title>Insert title here</title>
<body>
<div class="card direct-chat direct-chat-primary col-sm-12 container-fluid " >
              <div class="card-header ui-sortable-handle">
                <h3 class="card-title">GuGuSystems</h3>

<!--                 <div class="card-tools"> -->
<!--                   <span data-toggle="tooltip" title="3 New Messages" class="badge badge-primary">3</span> -->
<!--                   <button type="button" class="btn btn-tool" data-card-widget="collapse"> -->
<!--                     <i class="fas fa-minus"></i> -->
<!--                   </button> -->
<!--                   <button type="button" class="btn btn-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle"> -->
<!--                     <i class="fas fa-comments"></i> -->
<!--                   </button> -->
<!--                   <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i> -->
<!--                   </button> -->
<!--                 </div> -->
              </div>
              <!-- /.card-header -->
              
              <div class="card-body">
                <!-- Conversations are loaded here -->
                <div class="direct-chat-messages">
                
                  <!-- Message. Default to the left -->
                  <div class="direct-chat-msg">
                    <div class="direct-chat-infos clearfix">
                      <span class="direct-chat-name float-left">운영자</span>
                    </div>
            	        <!-- /.direct-chat-infos -->
        	            <img class="direct-chat-img" src="/GUGUProject/images/byw.jpg" alt="message user image">
	                    <!-- /.direct-chat-img -->
	                    <div class="direct-chat-text">
	                      	구구시스템 1:1 문의 채팅방입니다.<br>
	                      	상담요청을 기다리는 중입니다.
	                    </div>
	                    <span name="timeSpan" class="direct-chat-timestamp float-left"></span>
    	                <!-- /.direct-chat-text -->
                 	 </div>
                  <!-- /.direct-chat-msg -->

                </div>
                <!--/.direct-chat-messages-->
                
                <!-- /.direct-chat-pane -->
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
<!--                 <form action="#" method="post"> -->
                  <div class="input-group">
                    <input id="message" type="text" name="message" placeholder="Type Message ..." class="form-control" autofocus>
                    <span class="input-group-append">
                      <button type="button" class="btn btn-primary" onclick="sendMsg();">Send</button>
                    </span>
                  </div>
<!--                 </form> -->
              </div>
              <!-- /.card-footer-->
            </div>

</body>
<script src="/GUGUProject/plugins/js/jquery.min.js"></script>
<script src="/GUGUProject/plugins/js/jquery-ui.min.js"></script>
<script src="/GUGUProject/plugins/js/bootstrap.bundle.min.js"></script>
<script src="/GUGUProject/plugins/js/adminlte.js"></script>
<script src="/GUGUProject/plugins/js/demo.js"></script>
<script src="/GUGUProject/plugins/js/OverlayScrollbars.min.js"></script>

<script>





$("#message").keydown(function (key) {
	if(key.keyCode == 13){
		sendMsg();
	}
});


function getCurrentTime() {
	var date = new Date();
	var hours = date.getHours();
	var minutes = ('0'+date.getMinutes()).slice(-2);
	if(hours > 12){
		hours = "오후" + (hours - 12);
	}else if(hours == 12){
		hours = "오후 12"; 
	}else if(hours == 0){
		hours = "오전 12";
	}else{
		hours = "오전 " + hours;
	}
	
	return hours + ":" + minutes;
}


function printMsg(message) {
		
	var text = message.split("[/////]");
	var msg = text[0];
	var id = text[1];
	
	var memberId = "<%=memberId%>";
	var adminId = "<%=adminId%>";
	if(memberId != ""){
		printUserMsg(msg, id);
	}else if(adminId != ""){
		printAdminMsg(msg, id);
	}
}


function printAdminMsg(msg, id) {
	
	var time = getCurrentTime();
	var userId = id;
	var userImgSrc = "/GUGUProject/images/byw.jpg";

	var userMsgDiv = $('<div class="direct-chat-msg right">'
						+'<div class="direct-chat-infos clearfix">'
	  					+	'<span class="direct-chat-name float-right">'+userId+'</span>'
						+'</div>'
						+'<img class="direct-chat-img" src="'+userImgSrc+'" alt="message user image">'
						+'<div class="direct-chat-text text-right float-right">'
						+ msg 
						+'</div>'
	  					+'<span name="timeSpan" class="direct-chat-timestamp float-right">'+time+'</span>'
				  	  +'</div>');
	
// 	var height = $(".direct-chat-text")[index].height();
// 	$(".direct-chat-timestamp").attr("style", "top:"+height+"px");
// 	index++;
	
	$(".direct-chat-messages").append(userMsgDiv).stop().animate({ scrollTop: $('.direct-chat-messages')[0].scrollHeight }, 500);
	$("#message").val("").focus();
	setTimeStampPosition();
}

function printUserMsg(message) {
	
	var text = message.split("[/////]");
	var msg = text[0];
	var id = text[1];
	
	var time = getCurrentTime();
	var adminId = id;
	var userImgSrc = "/GUGUProject/images/sje.JPG";

	var userMsgDiv = $('<div class="direct-chat-msg left">'
						+'<div class="direct-chat-infos clearfix">'
	  					+	'<span class="direct-chat-name float-left">'+adminId+'</span>'
						+'</div>'
						+'<img class="direct-chat-img" src="'+userImgSrc+'" alt="message user image">'
						+'<div class="direct-chat-text text-left float-left">'
						+  msg
						+'</div>'
	  					+'<span name="timeSpan" class="direct-chat-timestamp float-left">'+time+'</span>'
				  	  +'</div>');
				  
	$(".direct-chat-messages").append(userMsgDiv).stop().animate({ scrollTop: $('.direct-chat-messages')[0].scrollHeight }, 500);
	
	setTimeStampPosition();
}

// 타임스팬에 동적으로 height값 부여
var index = 1;
function setTimeStampPosition() {
	var height = $($(".direct-chat-text")[index]).height();
	$($("span[name=timeSpan]")[index]).attr("style", "top:"+height+"px");
	index++;
}


var webSocket = new WebSocket("ws://192.168.46.49:8089/GUGUProject/websocket")

webSocket.onopen = function (message) {
}

webSocket.onclose = function (message) {
}

webSocket.onmessage = function (message) {
	
	if(message.data == "overConnect"){
		alert("접속자수 초과로 인한 접속해제");
		window.close();
	}else{
		printUserMsg(message.data);
	}

}

function sendMsg() {
	var msg = $("#message").val();
	if(msg == ""){
		$("#message").focus();
		return;
	}else if(msg.length > 5000){
		alert("채팅 입력 크기 초과!");
		$("#message").focus();
		return;
	}
	var id = "<%=adminId%>";
	var seperator = "[/////]"; 
	
	webSocket.send(msg+seperator+id);
	
	printAdminMsg(msg, id);
}

</script>





</html>