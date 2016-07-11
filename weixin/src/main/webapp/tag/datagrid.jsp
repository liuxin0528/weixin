<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/zehin" prefix="zh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>datagrid</title>
    <zh:commonHead easyui="true"/>
</head>
<script type="text/javascript">


var colModel = [[
     	        {field:'detailId',title:'编号',width:100},
    	        {field:'detailName',title:'名称',width:300},
    	        {field:'tInserted',title:'添加时间',width:150}
    	    ]];

$(function(){
	$('#aa').tree({
		data: [{
		    "id": 1,
		    "text": "Node 1",
		    "state": "closed",
		    "children": [{
		        "id": 11,
		        "text": "Node 11"
		    },{
		        "id": 12,
		        "text": "Node 12"
		    }]
		},{
		    "id": 2,
		    "text": "Node 2",
		    "state": "closed"
		}]
	});
	

})


</script>
<body>
<ul id="aa"></ul>
<!-- 
	* id				true		唯一标识
	* colModel			true		列属性
	* serviceId 		true		实现类的标识
	* title				false   	datagrid标题
	* singleSelect		false		是否单选true or false--默认单选
	* pageSize			false		每页多少条数据--默认10条
	* searchboxId		false		搜索框ID
	* treeNodeId		false		组织机构ID
 -->

<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north',border:false,height:44" style="overflow: hidden;">
   		<div class="main_header">
           <div class="main_title">测试数据</div>
           <div class="main_edit">
               <ul class="editlist">
                  <li class="search_this">
                      <input type="text" id="querystr" class="easyui-searchbox" data-options="prompt:'请输入关键字搜索',width:195" />
                  </li>
                  
               </ul>
           </div>
       </div>
   </div>      
   
   <div data-options="region:'center',border:false">
       <div class="easyui-panel" data-options="fit:true,border:false" >
       		<zh:datagrid id="testDatagird" colModel="colModel" serviceId="testDatagridServiceImpl"  searchboxId="querystr" treeNodeId="aa"></zh:datagrid>
       </div>
   </div>                    
</div>



</body>
</html>