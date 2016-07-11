/*
 * @(#)CommonBoboxBySqlTag.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zehin.common.SpringContextHolder;
import com.zehin.common.service.CommonTagService;

import net.sf.json.JSONArray;

/**
 *	日期		:	2016年3月31日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	test<br>
 *	功能		:	sql下拉<br>
 */
public class ComBoboxBySqlTag  extends SimpleTagSupport {

	private String id;// 标签ID属性

	private String name;// 标签的name属性

	private String width;// 控件宽度

	private String sql;// 需要查询的sql
	
	private String valueField;//值
	
	private String textField;//下拉显示的值

	private boolean emptyValueFlag = false;// 是否允许有空值--默认为false
	
	private boolean required = false;//是否是必填项 --默认为false--生效的前提是emptyValueFlag为false

	private CommonTagService commonTagService;

	public ComBoboxBySqlTag() {
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
		sb.append(" data-options='valueField:\""+ valueField +"\",textField:\"" + textField + "\",editable:false, required:" + required + ", ");

		// 添加数据
		List<Map<String, String>> objList = new ArrayList<Map<String, String>>();
		// 加上是否有空的选项
		if (emptyValueFlag) {
			Map<String, String> emptyMap = new HashMap<String, String>();
			emptyMap.put(valueField, "");
			emptyMap.put(textField, "&nbsp;");
			objList.add(emptyMap);
		}
		objList.addAll(commonTagService.queryComboboxDataBySql(sql));
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

	

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
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
