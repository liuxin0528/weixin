<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/zehin" prefix="zh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CommonBoboxBySqlTag</title>
    <zh:commonHead easyui="true"/>
</head>

<body>
<!-- 
	* id				true		唯一标识
	* name				false		标签name属性
	* sql 				true		需要查询数据的sql
	* valueField		true		传到后台的值
	* textField			true		页面显示的值
	* emptyValueFlag	false		是否有空值的选项
	* width				false		标签的宽度(默认 120px)
	* required			false		是否是必填项（默认为false）--生效的前提是emptyValueFlag为false
 -->

<zh:comboboxBySql textField="detailName" valueField="detailId" sql="SELECT d.detail_id AS detailId , d.detail_name AS detailName FROM sys_datadict_detail d WHERE d.group_id = '02'" id="dd" required="true"></zh:comboboxBySql>

</body>
</html>