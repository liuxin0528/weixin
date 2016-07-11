/*
 * @(#)CommonController.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zehin.common.SpringContextHolder;
import com.zehin.common.service.CommonTagService;
import com.zehin.common.util.StringUtil;

/**
 *	日期		:	2016年3月31日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	test<br>
 *	功能		:	封装的共用部分<br>
 */
@Controller
@RequestMapping("/common")
public class CommonTagController {
	
	@Autowired
	private CommonTagService commonTagService;
	
	
	/**
	 * 
	 * Description :
	 */
	@RequestMapping("/ajaxDataGrid")
	@ResponseBody
	public Map<String,Object> ajaxDataGrid(HttpServletRequest request){
		
		Map<String, String> paramMap = StringUtil.getParamMap(request.getParameterMap());//参数列表
		
		Map<String,Object> map = commonTagService.queryDataGridData(paramMap);
		
		return map;
	}
	

}
