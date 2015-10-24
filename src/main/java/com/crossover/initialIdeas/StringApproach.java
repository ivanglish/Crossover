package com.crossover.initialIdeas;



public class StringApproach {
		
	public String prettifyNumber(Long number){		
		char scale;
		if (number / 1_000_000L == 0)
			return number.toString();
		else if (number/1_000_000_000L == 0)
			scale ='M';
		else if (number/1_000_000_000_000L==0)
			scale = 'B';
		else if (number/1_000_000_000_000_000L==0)
			scale = 'T';
		else scale = 'Q';
		String numberString = number.toString();
		return setOutput (numberString.charAt(0),numberString.charAt(1), scale);
	}
	
	private String setOutput(char digit1, char digit2,char scale){
		if (digit2=='0')
			return digit1+String.valueOf(scale);
		else
			return digit1+"."+digit2+scale;
	}
}
