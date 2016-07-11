<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/zehin" prefix="zh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DWR</title>
	<zh:commonHead easyui="true"/>
	
	<!-- 项目名加文件 引入DWR test是项目名，注意修改-->
	<script type="text/javascript" src= "/test/dwr/util.js"></script>  
    <script type="text/javascript" src="/test/dwr/engine.js"></script>  
    <script type="text/javascript" src="/test/dwr/interface/ajaxController.js"> </script>  
	
</head>
<script type="text/javascript">

$(function(){
	ajaxController.testDwr();
})

	


</script>
<body>


</body>
</html>