package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;

//This class will give the output for thousands and hundreds
public class ThousandHundredHandler implements ICrossoverEntry {

	private ICrossoverEntry next = null;

	@Override
	public void handleRequest(ServiceRequest service) throws CaseNotContemplatedException {
		String numString = service.getNumber().toString();
		//get only thousands and hundreds
		if(numString.length() < 7)
		{
			//resolved by this level
			service.setPrettifiedNumber(numString);
		}
		else
		{
			next.handleRequest(service);
		}
	}
	
	public ICrossoverEntry getNext() {
		return next;
	}
	public void setNext(ICrossoverEntry next) {
		this.next = next;
	}
}
