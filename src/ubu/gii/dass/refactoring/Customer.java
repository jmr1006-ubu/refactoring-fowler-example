package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental rental = rentals.next();
			// determine amounts for each line
			thisAmount = getCharge(thisAmount, rental);
			
			frequentRenterPoints = rental.updateFrequenRenterPoints(frequentRenterPoints);
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	private double getCharge(double thisAmount, Rental rental) {
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount = getChargeRegular(thisAmount, rental);
			break;
		case Movie.NEW_RELEASE:
			thisAmount = getChargeNewRelease(thisAmount, rental);
			break;
		case Movie.CHILDRENS:
			thisAmount = getChargeChildren(thisAmount, rental);
			break;
		}
		return thisAmount;
	}

	private double getChargeChildren(double thisAmount, Rental rental) {
		thisAmount += 1.5;
		if (rental._movie.getDaysRented() > 3)
			thisAmount += (rental._movie.getDaysRented() - 3) * 1.5;
		return thisAmount;
	}

	private double getChargeNewRelease(double thisAmount, Rental rental) {
		thisAmount += rental._movie.getDaysRented() * 3;
		return thisAmount;
	}

	private double getChargeRegular(double thisAmount, Rental rental) {
		thisAmount += 2;
		if (rental._movie.getDaysRented() > 2)
			thisAmount += (rental._movie.getDaysRented() - 2) * 1.5;
		return thisAmount;
	}
}
