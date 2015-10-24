package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;

//This class will be the entry to the chain process
public class CrossoverEntry  implements ICrossoverEntry{

	private ICrossoverEntry handler = null;
	
	@Override
	public void handleRequest(ServiceRequest request) throws CaseNotContemplatedException {
		handler.handleRequest(request);	
	}
	
	public ICrossoverEntry getHandler() {
		return handler;
	}

	public void setHandler(ICrossoverEntry handler) {
		this.handler = handler;
	}
}
