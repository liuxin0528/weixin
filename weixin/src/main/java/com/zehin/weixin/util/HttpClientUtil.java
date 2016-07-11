package com.zehin.weixin.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	HTTP CLIENT<br>
 */
public class HttpClientUtil {
	
	/**
	 * 执行http url 请求
	 * Description : 
	 * @param url
	 * @return
	 */
	public static String execHttpGet(String url){
		try {
			HttpClient client = new HttpClient();
			HttpMethod method = new GetMethod(url.trim());
			client.executeMethod(method);
			
			client.setConnectionTimeout(10000);
			client.setTimeout(10000);
			
			byte[] responseBody = method.getResponseBodyAsString().getBytes("ISO-8859-1");
			
			String response = new String(responseBody,"GB2312");
			return response;
		} catch (Exception e) {
			
		}
		return null;
	}

}
