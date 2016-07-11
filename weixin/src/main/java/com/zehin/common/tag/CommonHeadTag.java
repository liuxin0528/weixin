/*
 * @(#)CommonHead.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 *	日期		:	2016年3月24日<br>
 *	作者		:	liuxin<br>
 *	项目		:	test<br>
 *	功能		:	<br>
 */
public class CommonHeadTag extends SimpleTagSupport{
	
	private Boolean easyui;//是否需要easyui
	
	private Boolean angularJs = false;//是否需要angularjs
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext)this.getJspContext();
		
		JspWriter out = context.getOut();
		
		//绝对路径
		String absolutePath = context.getServletContext().getContextPath();
		
		StringBuffer sb = new StringBuffer();
		
		if(easyui){
			sb.append("<link rel='stylesheet' type='text/css' href='" + absolutePath + "/common/css/reset.css' />\n");
			sb.append("<link rel='stylesheet' type='text/css' href='" + absolutePath + "/common/themes/default/easyui.css' />\n");
			sb.append("<link rel='stylesheet' type='text/css' href='" + absolutePath + "/common/themes/icon.css' />\n");
			sb.append("<link rel='stylesheet' type='text/css' href='" + absolutePath + "/common/css/import.css' />\n");
		}
		
		sb.append("<script type='text/javascript' src='" + absolutePath + "/common/js/jquery.min.js'></script>\n");
		if(easyui){
			sb.append("<script type='text/javascript' src='" + absolutePath + "/common/js/jquery.easyui.min.js'></script>\n");
			sb.append("<script type='text/javascript' src='" + absolutePath + "/common/js/locale/easyui-lang-zh_CN.js'></script>\n");
		}
		if(angularJs){
			sb.append("<script type='text/javascript' src='" + absolutePath + "/common/js/angular.min.js'></script>\n");	
		}
		sb.append("<script type='text/javascript'>" + "var absolutePath='" + absolutePath + "'; </script>\n");
		
		
		out.println(sb.toString());
	}

	public Boolean getEasyui() {
		return easyui;
	}

	public void setEasyui(Boolean easyui) {
		this.easyui = easyui;
	}

	public Boolean getAngularJs() {
		return angularJs;
	}

	public void setAngularJs(Boolean angularJs) {
		this.angularJs = angularJs;
	}


}
