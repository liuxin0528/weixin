package com.zehin.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

import com.zehin.common.util.PropertiesUtils;

/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	请求验证工具类<br>
 */
public class SignUtil {
	
	/**
	 * 验证签名
	 * Description : 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce, String echostr){
		System.out.println("-------------开始验证签名--------------");
		//从配置文件获取 Token
		String Token = PropertiesUtils.getProperties("Token");
		
		//对参数进行排序
		String [] ArrTmp = {Token, timestamp, nonce};
		Arrays.sort(ArrTmp);
		
		//将三个参数拼成一个字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		
		//将字符串进行sha1加密
		String pwd = encrypt(sb.toString());
		
		boolean result = (pwd.equals(signature)) && (echostr != null) && (!"".equals(echostr));
		
		return result;
	}
	
	/**
	 * 将Token timestamp  nonce三个参数拼成的字符串进行sha1加密
	 * Description : 
	 * @param strSrc
	 * @return
	 */
	private static String encrypt(String strSrc){
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest());
		} catch (Exception e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}
	
	/**
	 * 将字节数组转换为十六进制字符串
	 * Description : 
	 * @param bts
	 * @return
	 */
	private static String bytes2Hex(byte[] bts){
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if(tmp.length() == 1){
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

}
