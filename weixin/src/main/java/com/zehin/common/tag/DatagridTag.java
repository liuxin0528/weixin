/*
 * @(#)DatagridTag.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zehin.common.util.StringUtil;

/**
 * 日期 : 2016年4月1日<br>
 * 作者 : liuxin<br>
 * 项目 : test<br>
 * 功能 : datagrid封装<br>
 */
public class DatagridTag extends SimpleTagSupport {

	private String id;// 唯一标识

	private String colModel;// 列标识
	
	private String title;//datagrid标题
	
	private String serviceId;//实现类的标识
	
	private boolean singleSelect = true;//是否单选true or false--默认单选
	
	private int pageSize = 10;//每页多少条数据--默认10条
	
	private String searchboxId;//搜索框的ID
	
	private String treeNodeId;//组织机构节点ID

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext)this.getJspContext();
		JspWriter out = context.getOut();
		//绝对路径
		String absolutePath = context.getServletContext().getContextPath();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table id='").append(id).append("'></table>");
		
		sb.append("<script type='text/javascript'>");
		sb.append("$(function(){");
		//组织机构树
		if(StringUtil.isNotEmpty(treeNodeId)){
			sb.append("var rootNode = $('#"+ treeNodeId +"').tree('getRoot');");
		}
		
		sb.append("$('#").append(id).append("').datagrid({");
		sb.append("url:'").append(absolutePath).append("/common/ajaxDataGrid.do',");
		if(StringUtil.isNotEmpty(treeNodeId)){
			sb.append("queryParams:{'serviceId':'").append(serviceId).append("','treeNodeId':rootNode.id},");
		}else{
			sb.append("queryParams:{'serviceId':'").append(serviceId).append("'},");
		}
		sb.append("type:'POST', dataType:'json', autoRowHeight:true,loadMsg:'正在加载......',pagination:true,");
		sb.append("columns:").append(colModel).append(",");
		
		//是否有标题 
		if(StringUtil.isNotEmpty(title)){
			sb.append("title:").append(title).append(",");
		}
		
		sb.append("singleSelect:").append(singleSelect);
		
		sb.append("});");
		
		sb.append("var page = $('#").append(id).append("').datagrid('getPager');");
		sb.append("$(page).pagination({pageNumber:1,pageSize:").append(pageSize).append(",pageList:[5,10,15],beforePageText:'第',afterPageText: '页    共 {pages} 页', displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录' });");
		
		//搜索框
		if(StringUtil.isNotEmpty(searchboxId) && StringUtil.isNotEmpty(treeNodeId)){
			sb.append("$('#").append(searchboxId).append("').searchbox({searcher:function(value,name){");
			sb.append("var node = $('#"+treeNodeId+"').tree('getSelected');");
			sb.append("$('#").append(id).append("').datagrid('reload',{'searchboxValue':value,'serviceId':'"+serviceId+"','treeNodeId':node.id})");
			sb.append("}});");
		}else if(StringUtil.isNotEmpty(searchboxId) && StringUtil.isEmpty(treeNodeId)){
			sb.append("$('#").append(searchboxId).append("').searchbox({searcher:function(value,name){");
			sb.append("$('#").append(id).append("').datagrid('reload',{'searchboxValue':value,'serviceId':'"+serviceId+"'})");
			sb.append("}});");
		}
		
		//组织机构树
		if(StringUtil.isNotEmpty(treeNodeId) && StringUtil.isNotEmpty(searchboxId)){
			sb.append("$('#").append(treeNodeId).append("').tree({onSelect:function(node){");
			sb.append("var value = $('#"+searchboxId+"').searchbox('getValue');");
			sb.append("$('#").append(id).append("').datagrid('reload',{'searchboxValue':value,'serviceId':'"+serviceId+"','treeNodeId':node.id})");
			sb.append("}});");
		}else if(StringUtil.isNotEmpty(treeNodeId) && StringUtil.isEmpty(searchboxId)){
			sb.append("$('#").append(treeNodeId).append("').tree({onSelect:function(node){");
			sb.append("$('#").append(id).append("').datagrid('reload',{'serviceId':'"+serviceId+"','treeNodeId':node.id})");
			sb.append("}});");
		}
		
		
		sb.append("})</script>");
		//System.out.println(sb.toString());
		out.println(sb.toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColModel() {
		return colModel;
	}

	public void setColModel(String colModel) {
		this.colModel = colModel;
	}

	public boolean isSingleSelect() {
		return singleSelect;
	}

	public void setSingleSelect(boolean singleSelect) {
		this.singleSelect = singleSelect;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSearchboxId() {
		return searchboxId;
	}

	public void setSearchboxId(String searchboxId) {
		this.searchboxId = searchboxId;
	}

	public String getTreeNodeId() {
		return treeNodeId;
	}

	public void setTreeNodeId(String treeNodeId) {
		this.treeNodeId = treeNodeId;
	}

	

}
