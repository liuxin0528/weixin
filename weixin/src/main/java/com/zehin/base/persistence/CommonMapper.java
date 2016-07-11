/*
 * @(#)CommonCacheMapper.java 
 * 
 * Copyright 2015 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.base.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *	日期		:	2015年9月18日<br>
 *	作者		:	liuxin<br>
 *	项目		:	epark<br>
 *	功能		:	<br>
 */
public interface CommonMapper {
	
	/**
	 * 根据数据字典组ID，查询下拉数据
	 * Description : 
	 * @param groupId
	 * @return
	 */
	public List<Map<String,String>> queryComboboxDataByGroupId(@Param("groupId")String groupId);
	
	/**
	 * 根据用户自定义的sql查询下拉数据 
	 * Description : 
	 * @param sql
	 * @return
	 */
	public List<Map<String,String>> queryComboboxDataBySql(@Param("sql")String sql);
	
	/**
	 * 根据用户自定义的sql查询datagrid数据
	 * Description : 
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> queryDataGridData(@Param("sql")String sql);
	
	
}
