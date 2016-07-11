/*
 * @(#)DataGridCommonService.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *	日期		:	2016年4月4日<br>
 *	作者		:	liuxin<br>
 *	项目		:	test<br>
 *	功能		:	<br>
 */
public interface DataGridCommonService {
	
	/**
	 * 拼接新的sql
	 * @param dataMap:用来拼接sql的条件数据
	 * @return 新的sql
	 */
	public String getNewSql(Map<String, String> paramMap);
	
	/**
	 * 对数据进行转义
	 * Description : 
	 * @param list
	 * @return
	 */
	public List<Map<String,Object>> callbackTransList(List<Map<String,Object>> list);

}
