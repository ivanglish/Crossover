package com.crossover.initialIdeas;

import java.text.DecimalFormat;

public class NumericApproach {
	
	public String prettifyNumber(Long number){
		char c;
		if (number / 1_000_000L == 0)
			return number.toString();
		else if (number/1_000_000_000L == 0)
			c ='M';
		else if (number/1_000_000_000_000L==0)
			c = 'B';
		else if (number/1_000_000_000_000_000L==0)
			c = 'T';
		else c = 'Q';
		return setOutput (number, c);
	}
	
	private String setOutput(Long number,char c){
		double decimalBase10 = 1 /Math.pow(10, getNumberLength(number)-1);
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(number*decimalBase10)+c;
	}
	
	private int getNumberLength(Long number){
		return (int) Math.floor(Math.log10(number) + 1);
	}
}
