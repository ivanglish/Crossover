package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Scale;

//This class will give the output for billions
public class BillionHandler extends AbstractHandler implements ICrossoverEntry {

	private ICrossoverEntry next = null;

	@Override
	public void handleRequest(ServiceRequest service) throws CaseNotContemplatedException {
		String numString = service.getNumber().toString();
		int length = numString.length();
		//get only Billions
		if(length >= 10 && length <= 12)
		{
			//resolved by this level
			service.setPrettifiedNumber(setOutput(numString, Scale.B ,length));
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
