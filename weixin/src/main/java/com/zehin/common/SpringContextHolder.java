/*
 * @(#)SpringContextHolder.java 
 * 
 * Copyright 2016 by 青岛众恒信息科技股份有限公司 . 
 * All rights reserved.
 *
 */
package com.zehin.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 日期 : 2016年3月31日<br>
 * 作者 : liu_xin<br>
 * 项目 : test<br>
 * 功能 : spring工具类<br>
 */
public class SpringContextHolder implements ApplicationContextAware {

	//设置一个静态变量来保存spring ApplicationContext对象
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	/**
	 * 获取存在静态变量中的ApplicationContext
	 * Description : 
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	/**
	 * 根据beanName获取Bean
	 * Description : 
	 * @param beanName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		checkApplicationContext();
		return (T) applicationContext.getBean(beanName);
	}
	
	/**
	 * 根据类获取Bean
	 * Description : 
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		checkApplicationContext();
		return (T) applicationContext.getBean(clazz);
	}
	
	
	public static void checkApplicationContext(){
		if(null == applicationContext){
			throw new IllegalArgumentException("applicationContext未注入。");
		}
	}

}
