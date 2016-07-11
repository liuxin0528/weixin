/*
 * @(#)UrlUtil.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.util;

import com.zehin.common.util.PropertiesUtils;

/**
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	请求类<br>
 */
public class UrlUtil {
	
	public static String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + PropertiesUtils.getProperties("AppID") + "&secret=" + PropertiesUtils.getProperties("AppSecret");

}
