package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public abstract class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	protected int _priceCode;
	protected int _daysRented;

	public Movie(String title) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	double getCharge(Rental rental, double thisAmount, Customer customer) {
		switch (rental.getMovie()._priceCode) {
		case Movie.REGULAR:
			thisAmount = customer.getChargeRegular(thisAmount, rental);
			break;
		case Movie.NEW_RELEASE:
			thisAmount = customer.getChargeNewRelease(thisAmount, rental);
			break;
		case Movie.CHILDRENS:
			thisAmount = customer.getChargeChildren(thisAmount, rental);
			break;
		}
		return thisAmount;
	}
	
	public abstract int getFrequentPoints(int daysRented);
}
