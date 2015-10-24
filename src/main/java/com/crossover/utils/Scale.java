package com.crossover.utils;

import com.crossover.exceptions.CaseNotContemplatedException;



public enum Scale {
	M,
	B, 
	T,
	Q;
	
	public static Scale getScale(int i) throws CaseNotContemplatedException{
		switch (i) {
		case 2:
			return M;
		case 3:
			return B;
		case 4:
			return T;
		case 5:
			return Q;
		default:
			throw new CaseNotContemplatedException("Error!");
		}
	}
}
