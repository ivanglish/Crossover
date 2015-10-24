package com.crossover.initialIdeas;

import java.text.DecimalFormat;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Scale;

public class NumericScaleApproach {

	private final static int changeScale=3;
	public String prettifyNumber(Long number) throws CaseNotContemplatedException{
		int numberLength =getNumberLength(number); 
		int index = numberLength/changeScale;		
		if (index < 2) return number.toString();
		return setOutput(number, Scale.getScale(index), numberLength);
	}
	
	private String setOutput(Long number,Scale c, int numberLength){
		double decimalBase10 = 1 /Math.pow(10, numberLength -1);
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(number*decimalBase10)+c;
	}
	
	private int getNumberLength(Long number){
		return (int) Math.floor(Math.log10(number) + 1);
	}
	
	public static void main(String[] args) {
		double i = 100.94;
		System.out.println(Math.log10(i) + 1);
		System.out.println(Math.floor(Math.log10(i ) + 1));
	}
}
