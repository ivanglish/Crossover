package com.crossover.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crossover.chainPattern.CrossoverEntry;
import com.crossover.chainPattern.ICrossoverEntry;
import com.crossover.chainPattern.ServiceRequest;

public class SpringContextLoad {
	
	private static ApplicationContext context;
    private static ICrossoverEntry supportService;
	private static ServiceRequest request;

	public static void getContext(){
		context = new ClassPathXmlApplicationContext("application-config.xml");
		supportService = (CrossoverEntry) context.getBean("crossoverEntry");
		request = new ServiceRequest();	
	}
	
	public static ICrossoverEntry getSupportService() {
		return supportService;
	}

	public static void setSupportService(ICrossoverEntry supportService) {
		SpringContextLoad.supportService = supportService;
	}
	
	public static ServiceRequest getRequest() {
		return request;
	}

	public static void setRequest(ServiceRequest request) {
		SpringContextLoad.request = request;
	}
}
