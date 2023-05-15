package ubu.gii.dass.refactoring;

public class NewRelease extends Movie {

	public NewRelease(String title) {
		super(title);
		
	}

	public int getFrequentPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}

	public double getCharge(int daysRented) {

		return daysRented * 3;	
	}

}
