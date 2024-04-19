package imaginnovate.shivkahar.util;

public class TaxCalc {
	 public static double calculateTax(double salary) {
	        double tax = 0.0;
	        if (salary > 250000 && salary <= 500000) {
	            tax = (salary - 250000) * 0.05;
	        } else if (salary > 500000 && salary <= 1000000) {
	            tax = 12500 + (salary - 500000) * 0.1;
	        } else if (salary > 1000000) {
	            tax = 62500 + (salary - 1000000) * 0.2;
	        }
	        return tax;
	    }

	    public static double calculateCess(double salary) {
	        if (salary > 2500000) {
	            return (salary - 2500000) * 0.02;
	        }
	        return 0.0;
	    }
}
