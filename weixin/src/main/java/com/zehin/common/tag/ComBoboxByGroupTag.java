/*
 * @(#)ComboboxTag.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zehin.common.SpringContextHolder;
import com.zehin.common.service.CommonTagService;
import com.zehin.common.util.StringUtil;

import net.sf.json.JSONArray;

/**
 * 日期 : 2016年3月26日<br>
 * 作者 : liuxin<br>
 * 项目 : test<br>
 * 功能 : 数据字典的下拉<br>
 */
public class ComBoboxByGroupTag extends SimpleTagSupport {

	private String id;// 标签ID属性

	private String name;// 标签的name属性

	private String width;// 控件宽度

	private String groupId;// 数据字典的组ID

	private boolean emptyValueFlag = false;// 是否允许有空值
	
	private boolean required = false;//是否是必填项--生效的前提是emptyValueFlag为false
	
	private CommonTagService commonTagService;

	public ComBoboxByGroupTag() {
		commonTagService = SpringContextHolder.getBean("commonTagServiceImpl");
	}

	@Override
	public void doTag() throws JspException, IOException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		PageContext context = (PageContext) this.getJspContext();
		JspWriter out = context.getOut();

		StringBuffer sb = new StringBuffer();

		sb.append("<input id='" + id + "' ").append("name='" + name + "' ").append("class='easyui-combobox'");

		if (width != null) {
			if (width.endsWith("px")) {
				sb.append(" style='width:" + width + "'");
			} else {
				sb.append(" style='width:" + width + "px'");
			}
		} else {
			sb.append(" style='width:120px'");
		}
		sb.append(" data-options='valueField:\"detailId\",textField:\"detailName\",editable:false, required:" + required + ", ");

		// 添加数据
		List<Map<String, String>> objList = new ArrayList<>();
		// 加上是否有空的选项
		if (emptyValueFlag) {
			Map<String, String> emptyMap = new HashMap<String, String>();
			emptyMap.put("detailId", "");
			emptyMap.put("detailName", "&nbsp;");
			objList.add(emptyMap);
		}
		objList.addAll(commonTagService.queryComboboxDataByGroupId(groupId));
		JSONArray json = JSONArray.fromObject(objList);
		sb.append("data:" + json.toString() + "");
		sb.append("'/>");
		out.println(sb.toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isEmptyValueFlag() {
		return emptyValueFlag;
	}

	public void setEmptyValueFlag(boolean emptyValueFlag) {
		this.emptyValueFlag = emptyValueFlag;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	

}
