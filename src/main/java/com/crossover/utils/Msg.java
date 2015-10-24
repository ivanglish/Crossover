package com.crossover.utils;

public enum Msg {
	
	
	numberTooBig("the number is too big ... this case is not being handled yet :("),
	wrongFormat("The number does not have the right format");
	
	private String msg;
	
	private Msg(String msg){
		this.msg=msg;
	}
	
	public String getMsg(){
		return msg;
	}

}
