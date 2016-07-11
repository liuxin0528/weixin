package com.zehin.weixin.model;
/**
 * 
 *	日期		:	2016年7月11日<br>
 *	作者		:	liu_xin<br>
 *	项目		:	weixin<br>
 *	功能		:	微信获取token的返回<br>
 */
public class AccessToken {
	//{"access_token":"jsmGEyjCP1JXbfPi-V2ZQi0s_8x0jGpfCnNsfXY0nUHimkAgSue63GiHll1EbCeaFJg3loBAwz-3a6Fnvt3EuOr9GxrLRoGkJOowIv73j5ckAgvyHArw53E4z_OwPZr-DEBgACAGHE","expires_in":7200}

	private String access_token;
	
	private int  expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	

}
