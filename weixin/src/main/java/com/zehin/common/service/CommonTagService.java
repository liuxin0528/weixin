/*
 * @(#)CommonService.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.service;

import java.util.List;
import java.util.Map;

/**
 *	日期		:	2016年3月31日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	test<br>
 *	功能		:	封装的共用部分<br>
 */
public interface CommonTagService {
	
	/**
	 * 根据数据字典组ID，查询下拉数据
	 * Description : 
	 * @param groupId
	 * @return
	 */
	public List<Map<String,String>> queryComboboxDataByGroupId(String groupId);
	
	/**
	 * 根据用户自定义的sql查询下拉数据 
	 * Description : 
	 * @param sql
	 * @return
	 */
	public List<Map<String,String>> queryComboboxDataBySql(String sql);
	
	/**
	 * 根据用户自定义的sql查询datagrid数据
	 * Description : 
	 * @param sql
	 * @return
	 */
	public Map<String,Object> queryDataGridData(Map<String, String> paramMap);

}
