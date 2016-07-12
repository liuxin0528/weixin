/*
 * @(#)MessageBeanUtil.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.weixin.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.zehin.common.util.StringUtil;
import com.zehin.weixin.model.AbstractMessage;
import com.zehin.weixin.model.message.TextMessage;

/**
 *	日期		:	2016年7月12日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	消息工具类<br>
 */
public class MessageBeanUtil {
	
	/**
	 * 收取微信的数据，转换成 MessageBean
	 * Description : 
	 * @param str
	 * @return
	 */
	public static AbstractMessage str2MessageBean(String str){
		if(StringUtil.isEmpty(str)){
			return null;
		}
		try {
			Document doc = DocumentHelper.parseText(str);
			Element rootElt = doc.getRootElement();
			
			String toUserName = rootElt.elementText("ToUserName");
			String fromUserName = rootElt.elementText("FromUserName");
			String createTime = rootElt.elementText("CreateTime");
			String msgType = rootElt.elementText("MsgType");
			
			if(StringUtil.isEmpty(msgType)){
				throw new Exception("error msg_type");
			}
			
			if(StringUtil.equals(msgType, "text")){
				return new TextMessage(toUserName, fromUserName, createTime, msgType, rootElt.elementText("Content"), rootElt.elementText("MsgId"));
			}else{
				throw new Exception("unknow msg_type");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
