<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/zehin" prefix="zh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comboboxByGroup</title>
    <zh:commonHead easyui="true"/>
</head>

<body>

<!-- 
	* id				true		唯一标识
	* name				false		标签name属性
	* groupId 			true		组标识--数据加载组的子数据
	* emptyValueFlag	false		是否有空值的选项
	* width				false		标签的宽度(默认 120px)
	* required			false		不否是必填项（默认为false）--生效的前提是emptyValueFlag为false
 -->
<zh:comboboxByGroup id="groupvalue" name="groupvalue" groupId="02" emptyValueFlag="true"  width="" required="true"></zh:comboboxByGroup>

<script type="text/javascript">
$(function(){
	$("#groupvalue").combobox({
		onSelect:function(record){
			console.log(record)
		}
	})
})
</script>


</body>
</html>