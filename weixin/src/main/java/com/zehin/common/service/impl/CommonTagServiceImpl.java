/*
 * @(#)CommonServiceImpl.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zehin.base.persistence.CommonMapper;
import com.zehin.common.SpringContextHolder;
import com.zehin.common.service.CommonTagService;
import com.zehin.common.service.DataGridCommonService;

/**
 *	日期		:	2016年3月31日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	test<br>
 *	功能		:	封装的共用部分<br>
 */
@Service
public class CommonTagServiceImpl implements CommonTagService {
	
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private CommonMapper commonMapper;
	

	/**
	 * 根据数据字典组ID，查询下拉数据
	 * Description : 
	 * @param groupId
	 * @return
	 */
	@Override
	public List<Map<String,String>> queryComboboxDataByGroupId(String groupId) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			list = commonMapper.queryComboboxDataByGroupId(groupId);
		} catch (Exception e) {
			log.error("根据数据字典组ID，查询下拉数据", e);
		}
		return list;
	}

	/**
	 * 根据用户自定义的sql查询下拉数据 
	 * Description : 
	 * @param sql
	 * @return
	 */
	@Override
	public List<Map<String,String>> queryComboboxDataBySql(String sql) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			list = commonMapper.queryComboboxDataBySql(sql);
		} catch (Exception e) {
			log.error("根据用户自定义的sql查询下拉数据 ", e);
		}
		return list;
	}

	/**
	 * 根据用户自定义的sql查询datagrid数据
	 * Description : 
	 * @param sql
	 * @return
	 */
	@Override
	public Map<String,Object> queryDataGridData(Map<String, String> paramMap) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			int page = Integer.parseInt(paramMap.get("page"));
			int rows = Integer.parseInt(paramMap.get("rows"));
			
			DataGridCommonService service = SpringContextHolder.getBean(paramMap.get("serviceId"));
			String sql = service.getNewSql(paramMap);
			
			List<Map<String,Object>> list = commonMapper.queryDataGridData(sql);
			
			//返回的数据
			List<Map<String,Object>> subList = list.subList((page-1) * rows, (page * rows) > list.size() ? list.size() : page * rows);
			
			subList = service.callbackTransList(subList);
			
			map.put("rows", subList);
			map.put("total", list.size());
			
			
		} catch (Exception e) {
			log.error("查询datagrid数据失败", e);
		}
		return map;
	}


}
