/*
 * @(#)WeixinServiceImpl.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.service.impl;

import org.springframework.stereotype.Service;

import com.zehin.weixin.model.AbstractMessage;
import com.zehin.weixin.model.message.TextMessage;
import com.zehin.weixin.service.WeixinService;

/**
 *	日期		:	2016年7月12日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	service实现类<br>
 */
@Service
public class WeixinServiceImpl implements WeixinService{

	/**
	 * 处理用户发送来的消息 
	 * Description : 
	 * @param message
	 */
	@Override
	public AbstractMessage dealUserMessage(AbstractMessage sourceMessage) {
		if(sourceMessage == null){
			return null;
		}else if(sourceMessage instanceof TextMessage){
			return processTextMessage((TextMessage)sourceMessage);
		}
		
		return null;
	}
	
	/**
	 * 处理文本消息 
	 * Description : 
	 * @param sourceMessage
	 * @return
	 */
	private AbstractMessage processTextMessage(TextMessage sourceMessage){
		TextMessage textMessage = new TextMessage(sourceMessage);
		textMessage.setContent("你干啥呢。。。。。。");
		return textMessage;
	}

}
