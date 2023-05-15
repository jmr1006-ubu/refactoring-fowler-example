package ubu.gii.dass.refactoring;

public class Regular extends Movie {

	public Regular(String title) {
		super(title);
	}

	public int getFrequentPoints(int daysRented) {
		return 1;
	}

	public double getCharge(int daysRented) {
		double result = 0;
		
		result = 2;
	        if (daysRented > 2) {
	            result += (daysRented - 2) * 1.5;
	        }
	    
	    return result;	
	}

}
