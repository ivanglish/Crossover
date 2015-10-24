package com.crossover.chainPattern;

import com.crossover.utils.Scale;

// Abstract class which contains the main method which set the output . this will be extended for all the chain members
public abstract class AbstractHandler {
	
	private final static int beat=3;
	protected String setOutput(String number,Scale c, int length) {
		String exit = null;
		//Prepair output according numbers position
		switch (length) {
			case beat*2+1:
			case beat*3+1:
			case beat*4+1:
			case beat*5+1:
				number =number.substring(0,2);
				exit = String.valueOf(number.charAt(0));
				exit = setExit(number, c, exit, 1);
				break;
			case beat*2+2:
			case beat*3+2:
			case beat*4+2:
			case beat*5+2:
				number =number.substring(0,3);
				exit = String.valueOf(number.substring(0,2));
				exit = setExit(number, c, exit, 2);
				break;
			case beat*2+3:
			case beat*3+3:
			case beat*4+3:
			case beat*5+3:
				number =number.substring(0,4);
				exit =String.valueOf(number.substring(0,3));
				exit = setExit(number, c, exit, 3);
				break;
		}		
		return exit; 
	}

	private String setExit(String number, Scale c, String exit, int i) {
		if (number.charAt(i)=='0')
			exit += c;
		else
			exit += "."+number.charAt(i)+c;
		return exit;
	}

}
