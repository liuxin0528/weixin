package com.zehin.weixin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zehin.weixin.model.AbstractMessage;
import com.zehin.weixin.service.WeixinService;
import com.zehin.weixin.util.MessageBeanUtil;
import com.zehin.weixin.util.SignUtil;

/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	微信服务器请求<br>
 */
@Controller
@RequestMapping("/weixin/weixinRequest")
public class WeixinRequestController {
	
	@Resource
	private WeixinService weixinService;
	
	/**
	 * 确认请求来自微信服务器
	 * Description : 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(method = {RequestMethod.GET}, produces = "application/xml;charset=UTF-8") 
	public void getWeixinRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//微信加密签名
		String signature = request.getParameter("signature");
		
		//时间戳
		String timestamp = request.getParameter("timestamp");
		
		//随机数
		String nonce = request.getParameter("nonce");
		
		//随机字符串
		String echostr = request.getParameter("echostr");
		
		System.out.println("weixin servlet : signature=" + signature + "; timestamp=" + timestamp + "; nonce=" + nonce + "; echostr=" + echostr);
		
		PrintWriter out = response.getWriter();
		//验证服务器地址的有效性
		if(SignUtil.checkSignature(signature, timestamp, nonce, echostr)){
			System.out.println("weixinservice doGet ok return" + echostr);
			out.println(echostr);
		}
		out.flush();  
        out.close();
	}
	
	/**
	 * 处理微信服务器发来的请求
	 * Description :
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	@RequestMapping(method = {RequestMethod.POST}, produces = "text/xml;charset=UTF-8")  
	public void getWeixinResponse(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("=========接收到用户的发送请求==========");
		
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//得到请求体中推送的xml数据包结构
		String requestStr = this.getRequestStr(request);
		
		//转换用户发送的消息，得到一个 MessageBean
		AbstractMessage sourceMessage = MessageBeanUtil.str2MessageBean(requestStr);
		
		//处理用户的消息，并作出相应的处理
		AbstractMessage returnMessage = weixinService.dealUserMessage(sourceMessage);
		System.out.println(returnMessage.toXml());
		
		//给用户返回数据
        PrintWriter out = response.getWriter();  
        out.print(returnMessage.toXml());  
        out.close();  
	}
	
	
	
	/**
	 * 处理请求流
	 * Description : 
	 * @param request
	 * @return * @throws IOException 
	 */
	private String getRequestStr(HttpServletRequest request){
		try {

			InputStream is = request.getInputStream();
			
			//取HTTP请求流长度
			int size = request.getContentLength();
			
			//用于缓存每次读取的数据
			byte[] buffer = new byte[size];
			//用于存放结果的数组
			byte[] xmldataByte = new byte[size];
			
			int count = 0;
			int rbyte = 0;
			
			//循环读取
			while(count < size){
				//每次实际读取长度存于rbyte中
				rbyte = is.read(buffer);
				for (int i = 0; i < rbyte; i++) {
					xmldataByte[count + i] = buffer[i];
				}
				count += rbyte;
			}
			
			is.close();
			String requestStr = new String(xmldataByte, "UTF-8");
			return requestStr;
		
		} catch (Exception e) {
			System.out.println("数据异常。。。。。。");
		}
		return null;
	}
}
