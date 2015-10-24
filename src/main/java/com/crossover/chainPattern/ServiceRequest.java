package com.crossover.chainPattern;

//this class will carry the number out to the processing and will contain the result
public class ServiceRequest {
	
	private Long number;
	private String result = null;
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getPrettifiedNumber() {
		return result;
	}
	public void setPrettifiedNumber(String result) {
		this.result = result;
	}

}
