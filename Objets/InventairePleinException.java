package Objets;

public class InventairePleinException extends Exception {

	/**
	 * Initialiser une InventairePleinException.
	 */
	public InventairePleinException() {
		super("L'inventaire est déjà plein, vous ne pouvez rien ajouter ! ");
	}


}
