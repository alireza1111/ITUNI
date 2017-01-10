package se.chalmers.bmi;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

///TST for GIT config

public class Operation {
	
	public double calc(double height, int weight){
		double result;
		result= (weight/(height*height));
		return result; 

		
	}
	
	public double parse(double val){       
	     DecimalFormat twoDForm = new DecimalFormat("#,##", new DecimalFormatSymbols(Locale.US));
	     return Double.valueOf(twoDForm.format(val));
	}

}
