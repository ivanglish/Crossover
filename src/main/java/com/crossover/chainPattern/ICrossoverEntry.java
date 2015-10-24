package com.crossover.chainPattern;

import com.crossover.exceptions.CaseNotContemplatedException;



public interface ICrossoverEntry {
	
	public void handleRequest(ServiceRequest request) throws CaseNotContemplatedException;

}
