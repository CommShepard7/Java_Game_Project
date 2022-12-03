package Objets;

@SuppressWarnings("serial")
public class ElementNonPresentException extends Exception {

	/**
	 * Initialiser un ElementNonPresentException avec le message précisé.
	 *
	 * @param message le message explicatif
	 */
	public ElementNonPresentException(String message) {
		super(message);
	}

}
