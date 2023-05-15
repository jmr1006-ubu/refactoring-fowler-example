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
public class Rental {
	protected Movie _movie;
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int updateFrequenRenterPoints(int frequentRenterPoints) {
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& _movie.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
