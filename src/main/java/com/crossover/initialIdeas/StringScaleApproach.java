package com.crossover.initialIdeas;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Scale;

public class StringScaleApproach {
	
	private final static int changeScale=3;
	public String prettifyNumber(Long number) throws CaseNotContemplatedException{
		int numberLength =getNumberLength(number); 
		int index = numberLength/changeScale;		
		String numString = number.toString();
		if (index < 2) return numString;
		return setOutput(numString, Scale.getScale(index));		
	}
	
	private String setOutput(String number,Scale c){
		String exit=String.valueOf(number.charAt(0));
		if (number.charAt(1)=='0')
			exit += c;
		else
			exit += "."+number.charAt(1)+c;
		return exit; 
	}
	
	private int getNumberLength(Long number){
		return (int) Math.floor(Math.log10(number) + 1);
	}
}
