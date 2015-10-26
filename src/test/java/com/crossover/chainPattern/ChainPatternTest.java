package com.crossover.chainPattern;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crossover.exceptions.CaseNotContemplatedException;


public class ChainPatternTest {
	
	static ApplicationContext context;
	static ICrossoverEntry supportService;
	static ServiceRequest request;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-config.xml");
		supportService = (CrossoverEntry) context.getBean("crossoverEntry");
		request = new ServiceRequest();	
	}

	@Test
	public void prettifyNumberTest() throws CaseNotContemplatedException {
		
		request.setNumber(585L);
		supportService.handleRequest(request);
		assertEquals("5845", request.getPrettifiedNumber());
		
		request.setNumber(999_999L);
		supportService.handleRequest(request);
		assertEquals("999999", request.getPrettifiedNumber());
		
		request.setNumber((long) 2_500_000.34D);
		supportService.handleRequest(request);
		assertEquals("2.5M", request.getPrettifiedNumber());
		
		request.setNumber(3_500_000_000_000L);
		supportService.handleRequest(request);
		assertEquals("3.5T", request.getPrettifiedNumber());
		
		request.setNumber(400_000_000_000_000L);
		supportService.handleRequest(request);
		assertEquals("400T", request.getPrettifiedNumber());
		
		request.setNumber(20_500_000L);
		supportService.handleRequest(request);
		assertEquals("20.5M", request.getPrettifiedNumber());
		
		request.setNumber(123_400_000L);
		supportService.handleRequest(request);
		assertEquals("123.4M", request.getPrettifiedNumber());
		
		request.setNumber(99_800_000_000L);
		supportService.handleRequest(request);
		assertEquals("99.8B", request.getPrettifiedNumber());

	}
	
	@Test
	public void executionStressTest()  throws CaseNotContemplatedException{
		
		long startTime = System.currentTimeMillis();
		ServiceRequest request = new ServiceRequest();
		for (int i = 0; i < 10000; i++) {	
			request.setNumber(585L);
			supportService.handleRequest(request);
			assertEquals("585", request.getPrettifiedNumber());
			
			request.setNumber(999_999L);
			supportService.handleRequest(request);
			assertEquals("999999", request.getPrettifiedNumber());
			
			request.setNumber((long) 2_500_000.34D);
			supportService.handleRequest(request);
			assertEquals("2.5M", request.getPrettifiedNumber());
			
			request.setNumber(3_500_000_000_000L);
			supportService.handleRequest(request);
			assertEquals("3.5T", request.getPrettifiedNumber());
			
			request.setNumber(400_000_000_000_000L);
			supportService.handleRequest(request);
			assertEquals("400T", request.getPrettifiedNumber());
			
			request.setNumber(20_500_000L);
			supportService.handleRequest(request);
			assertEquals("20.5M", request.getPrettifiedNumber());
			
			request.setNumber(123_400_000L);
			supportService.handleRequest(request);
			assertEquals("123.4M", request.getPrettifiedNumber());
			
			request.setNumber(99_800_000_000L);
			supportService.handleRequest(request);
			assertEquals("99.8B", request.getPrettifiedNumber());

		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime +" ---> ChainPattern execution time wtih a 10000 loop");
	}

}
