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

	private String _title;
	
	public Movie(String title) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}


	public abstract int getFrequentPoints(int daysRented);
	public abstract double getCharge(int daysRented);
}
