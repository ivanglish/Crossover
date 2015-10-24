package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Scale;

//This class will give the output for trillions
public class TrillionHandler extends AbstractHandler implements ICrossoverEntry {

	private ICrossoverEntry next = null;
	
	@Override
	public void handleRequest(ServiceRequest service) throws CaseNotContemplatedException {
		String numString = service.getNumber().toString();
		int length = numString.length();
		//get only Trillions
		if(length >= 13 && length <= 15)
		{
			//resolved by this level
			service.setPrettifiedNumber(setOutput(numString, Scale.T ,length));
		}
		else
		{
			if(next != null){
				next.handleRequest(service);
			}
			else
			{
				throw new CaseNotContemplatedException("Error! ");
			}
		}
	}
	
	public ICrossoverEntry getNext() {
		return next;
	}
	public void setNext(ICrossoverEntry next) {
		this.next = next;
	}
}
