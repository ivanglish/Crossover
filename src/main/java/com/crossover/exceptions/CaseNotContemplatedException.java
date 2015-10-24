package com.crossover.exceptions;

import com.crossover.utils.Msg;

public class CaseNotContemplatedException extends Exception {

	public CaseNotContemplatedException() {
		super();
	}

	public CaseNotContemplatedException(String message) {
		super(message +Msg.numberTooBig.getMsg());
	}
	
	public void displayError(){
		System.err.println(Msg.numberTooBig.getMsg());
	}
}
