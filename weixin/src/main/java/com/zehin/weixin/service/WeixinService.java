/*
 * @(#)WeixinService.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.service;

import com.zehin.weixin.model.AbstractMessage;

/**
 *	日期		:	2016年7月12日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	service接口<br>
 */
public interface WeixinService {
	
	/**
	 * 处理用户发送来的消息 
	 * Description : 
	 * @param message
	 */
	public AbstractMessage dealUserMessage(AbstractMessage message);

}
