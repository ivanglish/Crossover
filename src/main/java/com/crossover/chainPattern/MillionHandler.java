package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Scale;

//This class will give the output for millions
public class MillionHandler extends AbstractHandler implements ICrossoverEntry {

	private ICrossoverEntry next = null;
	
	@Override
	public void handleRequest(ServiceRequest service) throws CaseNotContemplatedException {
		String numString = service.getNumber().toString();
		int length = numString.length();
		//get only Millions
		if(length >= 7 && length <= 9)
		{
			//resolved by this level
			service.setPrettifiedNumber(setOutput(numString, Scale.M ,length));
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
