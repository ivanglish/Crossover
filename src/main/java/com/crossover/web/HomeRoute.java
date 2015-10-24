package com.crossover.web;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;

import com.crossover.chainPattern.ServiceRequest;
import com.crossover.exceptions.CaseNotContemplatedException;
import com.crossover.utils.DateExtensions;
import com.crossover.utils.Msg;
import com.crossover.utils.RuntimeExtension;
import com.crossover.utils.SpringContextLoad;
import com.google.gson.Gson;

public class HomeRoute extends Route {
    private Gson gson = new Gson();
	
    public HomeRoute() {
    	super("/:number");
    }

	@Override
    public Object handle(Request request, Response response) {
        Map<String, Object> values = new LinkedHashMap<>();
        String value = null;
        try {
			value = getPrettifiedNumber(Double.valueOf(request.params(":number")));
			values.put("numero prettiffied: ", value);
	        values.put("memory", RuntimeExtension.getMemoryInformation());
	        values.put("date", DateExtensions.getDateInIso8601());
	        return gson.toJson(values);
        } catch (InputMismatchException e) {
        	values.put("Error", Msg.numberTooBig.getMsg()+ e);
		} catch (CaseNotContemplatedException e) {
			values.put("Error", e.getMessage());
		}
        return gson.toJson(values);
    }
	
	public String getPrettifiedNumber(double number) throws CaseNotContemplatedException{
		ServiceRequest sr = SpringContextLoad.getRequest();
		sr.setNumber((long) number);
		SpringContextLoad.getSupportService().handleRequest(sr);
		return sr.getPrettifiedNumber();
	}
}
