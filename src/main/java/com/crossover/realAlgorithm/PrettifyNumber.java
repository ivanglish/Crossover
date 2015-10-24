package com.crossover.realAlgorithm;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Msg;
import com.crossover.utils.Scale;

public class PrettifyNumber {
	
	private final static int beat=3;
	public String prettifyNumber(Long number) throws CaseNotContemplatedException{
		Scale c = null;
		String numString = number.toString();
		int length = numString.length();
		//Give the scale according to length of the number
		if (length < 7) return numString;
		if (length >= 7 && length <= 9) c = Scale.M;
		else if (length >= 10 && length <= 12) c = Scale.B;
		else if (length >= 13 && length <= 15) c = Scale.T;
		else if (length >= 16 && length <= 18) c = Scale.Q;
		return setOutput(numString, c ,length);		
	}
	
	private String setOutput(String number,Scale c, int length) throws CaseNotContemplatedException{
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
			default:
				//In case number is too big throw exception
				throw new CaseNotContemplatedException(Msg.numberTooBig.getMsg());
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
