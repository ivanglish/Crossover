package com.crossover.realAlgorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crossover.exceptions.CaseNotContemplatedException;


public class PrettifyNumberTest {

	private PrettifyNumber cross =  new PrettifyNumber();

	@Test
	public void prettifyNumberTest()  throws CaseNotContemplatedException{
		String s = cross.prettifyNumber(585L);
		assertEquals("585", s);
		s = cross.prettifyNumber(999_999L);
		assertEquals("999999", s);
		s = cross.prettifyNumber((long) 2_500_000.34D);
		assertEquals("2.5M", s);
		s = cross.prettifyNumber(3_500_000_000_000L);
		assertEquals("3.5T", s);
		s = cross.prettifyNumber(4_000_000_000_000_000L);
		assertEquals("4Q", s);
		s = cross.prettifyNumber(20_500_000L);
		assertEquals("20.5M", s);
		s = cross.prettifyNumber(123_400_000L);
		assertEquals("123.4M", s);
		s = cross.prettifyNumber(99_800_000_000L);
		assertEquals("99.8B", s);
	}
	
	@Test
	public void executionStressTest()  throws CaseNotContemplatedException{
		
		long startTime = System.currentTimeMillis();
		String s;
		for (int i = 0; i < 10000; i++) {	
			s = cross.prettifyNumber(585L);
			assertEquals("585", s);
			s = cross.prettifyNumber(999_999L);
			assertEquals("999999", s);
			s = cross.prettifyNumber((long) 2_500_000.34D);
			assertEquals("2.5M", s);
			s = cross.prettifyNumber(3_500_000_000_000L);
			assertEquals("3.5T", s);
			s = cross.prettifyNumber(4_000_000_000_000_000L);
			assertEquals("4Q", s);
			s = cross.prettifyNumber(20_500_000L);
			assertEquals("20.5M", s);
			s = cross.prettifyNumber(123_400_000L);
			assertEquals("123.4M", s);
			s = cross.prettifyNumber(99_800_000_000L);
			assertEquals("99.8B", s);
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime +" ---> Pretty execution time wtih a 10000 loop");
	}
}
