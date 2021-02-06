<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description" content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	<link href="/GUGUProject/assets/css/main.css" rel="stylesheet">
<title>글자수 세기</title>
<style>
.wrap { width: 60%; height: auto; position: relative;display: inline-block;}
.wrap textarea { width: 100%; resize: none; min-height: 4.5em; line-height:1.6em; max-height: 20em;}
.wrap span { position: absolute; bottom: 5px; right: 5px;}
#counter { background: rgba(255,0,0,0.5); border-radius: 0.5em; padding: 0 .5em 0 .5em;font-size: 20px;display: block;
    width: 7%; margin-left: 9%;margin-bottom: 1%;}
h2{margin: 3%; text-align: center; margin-left: -23%;}
#content{ margin-left: 15%; height: 500px !important; }
</style>
<script type="text/javascript">
$(function() {
    $('#content').keyup(function (e){
        var content = $(this).val();
        $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
        $('#counter').html(content.length + '/5000');
    });
    $('#content').keyup();
});
</script>
</head>
<body>
<div>
	<h2>글자수 세기</h2>
	    <span id="counter"></span>
	<div class="wrap">
	    <textarea id="content" maxlength="5000"></textarea>
	</div>
</div>
</body>
</html>