package com.zehin.weixin.util;

import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;

import com.zehin.weixin.model.AccessToken;

import net.sf.json.JSONObject;

/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	凭证类<br>
 */
public class AccessTokenUtil {
	
	private static AccessTokenUtil accessTokenUtil = null;
	
	
	//获取到的凭证
	private static String token;
	//获取时间，
	private static long getTimeInMillis;
	//凭证有效时间，单位：秒
	private static int expiresIn;
	
	/**
	 * 私有的构造方法 
	 */
	private AccessTokenUtil() {
		
	}
	
	public static String getToken(){
		if(accessTokenUtil == null || (!isTokenExpires())){
			String result = HttpClientUtil.execHttpGet(UrlUtil.GET_ACCESS_TOKEN);
			AccessToken accessToken = (AccessToken)JSONObject.toBean(JSONObject.fromObject(result), AccessToken.class);
			AccessTokenUtil.token = accessToken.getAccess_token();
			AccessTokenUtil.expiresIn = accessToken.getExpires_in();
			AccessTokenUtil.getTimeInMillis = Calendar.getInstance().getTimeInMillis();
		}
		return token;
	}
	
	/**
	 * 凭证是否超时（true-没有超时；false-超时）
	 * Description : 
	 * @return
	 */
	public static boolean isTokenExpires(){
		Calendar now = Calendar.getInstance();
		long nowTimeInMillis = now.getTimeInMillis();
		return ((nowTimeInMillis - getTimeInMillis) / 1000 < expiresIn);
	}
	
	

}
