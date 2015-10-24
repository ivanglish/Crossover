package com.crossover.initialIdeas;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringAproachTest {

	private StringApproach cross =  new StringApproach();

	@Test
	public void prettifyNumberTest() {
		String s = cross.prettifyNumber(585L);
		assertEquals("585", s);
		s = cross.prettifyNumber(1_000_000L);
		assertEquals("1M", s);
		s = cross.prettifyNumber((long) 2_500_000.34D);
		assertEquals("2.5M", s);
		s = cross.prettifyNumber(1_123_456_789L);
		assertEquals("1.1B", s);
		s = cross.prettifyNumber(3_500_000_000_000L);
		assertEquals("3.5T", s);
		s = cross.prettifyNumber(0L);
		assertEquals("0", s);
		s = cross.prettifyNumber(4_000_000_000_000_000L);
		assertEquals("4Q", s);
	}
	
	@Test
	public void executionStressTest(){
		
		long startTime = System.currentTimeMillis();
		String s;
		for (int i = 0; i < 10000; i++) {	
			s = cross.prettifyNumber(1_000_000L);
			assertEquals("1M", s);
			s = cross.prettifyNumber(585L);
			assertEquals("585", s);
			s = cross.prettifyNumber((long) 2_500_000.34D);
			assertEquals("2.5M", s);
			s = cross.prettifyNumber(1_123_456_789L);
			assertEquals("1.1B", s);
			s = cross.prettifyNumber(3_500_000_000_000L);
			assertEquals("3.5T", s);
			s = cross.prettifyNumber(0L);
			assertEquals("0", s);
			s = cross.prettifyNumber(4_000_000_000_000_000L);
			assertEquals("4Q", s);
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime +" ---> StringApproach execution time wtih a 10000 loop");
	}
}
