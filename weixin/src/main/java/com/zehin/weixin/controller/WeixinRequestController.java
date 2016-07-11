package com.zehin.weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zehin.weixin.util.SignUtil;

/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	微信服务器请求<br>
 */
@Controller
@RequestMapping("/weixin")
public class WeixinRequestController {
	
	@RequestMapping("/weixinRequest")
	@ResponseBody
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
		
		//验证服务器地址的有效性
		if(SignUtil.checkSignature(signature, timestamp, nonce, echostr)){
			System.out.println("weixinservice doGet ok return" + echostr);
			response.getWriter().println(echostr);
		}
	}

}
