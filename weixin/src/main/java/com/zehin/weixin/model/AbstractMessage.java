/*
 * @(#)AbstractMessage.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.model;

import java.util.Calendar;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *	日期		:	2016年7月12日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	消息事件抽象类<br>
 */
public abstract class AbstractMessage {
	
	private String toUserName;//开发者微信号
	
	private String fromUserName;//发送方账号
	
	private String createTime;//消息创建时间
	
	private String msgType;//消息类型
	
	protected Document document;
	
	/**
	 * 构造方法
	 * @param toUserName
	 * @param fromUserName
	 * @param createTime
	 * @param msgType
	 */
	public AbstractMessage(String toUserName, String fromUserName, String createTime, String msgType) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
	}
	
	
	/**
	 * 转换成XML 数据格式
	 * Description : 
	 * @return
	 */
	public abstract String toXml();
	
	public void genDocument(){
		document = DocumentHelper.createDocument();
		Element xml = document.addElement("xml");
		
		//给用户返回消息时，发送人和接收人 要与用户发过来的对调一下
		xml.addElement("ToUserName").addCDATA(this.fromUserName);
		xml.addElement("FromUserName").addCDATA(this.toUserName);
		
		xml.addElement("CreateTime").addText("" + Calendar.getInstance().getTimeInMillis());
		xml.addElement("MsgType").addCDATA(this.msgType);
	}
	

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	
	
	

}
