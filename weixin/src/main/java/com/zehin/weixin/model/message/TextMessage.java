/*
 * @(#)TestMessage.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.model.message;

import com.zehin.weixin.model.AbstractMessage;

/**
 *	日期		:	2016年7月12日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	文本消息<br>
 */
public class TextMessage extends AbstractMessage{
	
	private String content;//文本消息内容
	
	private String msgId;//消息id，64位整型
	
	/**
	 * 构造方法
	 * @param toUserName
	 * @param fromUserName
	 * @param createTime
	 * @param msgType
	 */
	public TextMessage(String toUserName, String fromUserName, String createTime, String msgType,String content, String msgId) {
		super(toUserName, fromUserName, createTime, msgType);
		this.content = content;
		this.msgId = msgId;
	}
	
	public TextMessage(AbstractMessage sourceMessage) {
		super(sourceMessage.getToUserName(), sourceMessage.getFromUserName(), sourceMessage.getCreateTime(), sourceMessage.getMsgType());
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toXml() {
		genDocument();
		this.document.getRootElement().addElement("Content").addCDATA(this.content);
		return this.document.asXML();
	}
	
	

}
