package com.crossover;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.crossover.chainPattern.ServiceRequest;
import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.Msg;
import com.crossover.utils.SpringContextLoad;
import com.crossover.web.Routes;

public class Main{

	public static void main(String[] args) {
		double s=0;
		Scanner in;
		Routes.build();
		SpringContextLoad.getContext();
		ServiceRequest sr = SpringContextLoad.getRequest();
		for(;;){
				in = new Scanner(System.in);
			    System.out.println("Enter a number: ");
			    try {
			    	 s = in.nextDouble();
					    sr.setNumber((long) s);
					    SpringContextLoad.getSupportService().handleRequest(sr);
					    System.out.println("NUMBER PRETTIFIED: "+ sr.getPrettifiedNumber());
			    } catch (InputMismatchException e) {
			        System.err.print(Msg.wrongFormat.getMsg());
			    } catch (CaseNotContemplatedException e) {
					e.displayError();
				}		
		}
	}
}
