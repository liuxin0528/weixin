<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/zehin" prefix="zh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面图片放大</title>
    
    
	<link rel='stylesheet' type='text/css' href="../common/imgShow/assets/touchTouch/touchTouch.css"/>
	<zh:commonHead easyui="true"/>
	<script type="text/javascript" src="../common/imgShow/assets/touchTouch/touchTouch.jquery.js?randomId=<%=Math.random()%>"></script>
	
</head>
<script type="text/javascript">

$(function(){
	$('img').touchTouch();
});


	


</script>
<body>

<img src="../common/image/small.jpg" width="100px" height="100px"/>

</body>
</html>