package ubu.gii.dass.refactoring;

public class Children extends Movie {

	public Children(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public int getFrequentPoints(int daysRented) {
		return 1;
	}

	public double getCharge(int daysRented) {
		double result = 0;
			result = 1.5;
	        if (daysRented > 3) {
	            result += (daysRented - 3) * 1.5;
	        }
	        return result;	
	}

}
