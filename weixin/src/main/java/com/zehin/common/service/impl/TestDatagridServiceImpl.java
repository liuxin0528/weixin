/*
 * @(#)TestDatagridServiceImpl.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.zehin.common.service.DataGridCommonService;
import com.zehin.common.service.TestDatagridService;
import com.zehin.common.util.StringUtil;

/**
 *	日期		:	2016年4月4日<br>
 *	作者		:	liuxin<br>
 *	项目		:	test<br>
 *	功能		:	用来测试的datagrid<br>
 */
@Service
public class TestDatagridServiceImpl implements TestDatagridService, DataGridCommonService {
	
	/**
	 * 正常情况下的逻辑
	 * Description :
	 */
	@Override
	public void queryNormalData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNewSql(Map<String, String> paramMap) {
		
		String searchboxValue = paramMap.get("searchboxValue");//搜索框的值
		if(StringUtil.isNotEmpty(searchboxValue)){
			return "SELECT detail_id as detailId, detail_name as detailName,t_inserted as tInserted FROM sys_datadict_detail where detail_name like '%"+searchboxValue+"%'";
		}
		String treeNodeId = paramMap.get("treeNodeId");//组织机构ID
		if(StringUtil.isNotEmpty(treeNodeId)){
			
		}
		
		return "SELECT detail_id as detailId, detail_name as detailName ,t_inserted as tInserted FROM sys_datadict_detail";
	}

	@Override
	public List<Map<String, Object>> callbackTransList(List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			Set set = map.keySet();
			
			Iterator it = set.iterator();
			
			while (it.hasNext()) {
				String key = it.next().toString();
				if(StringUtil.equals("detailName", key)){
					map.put(key, "123");
				}
				
			}
		}
		return list;
	}
	
}
