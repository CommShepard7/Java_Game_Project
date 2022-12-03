package Caracteristiques;

public abstract class Caracteristique {
	private final int VAL_MAX = 20;
	protected final static int VAL_MOY = 5;
	
	private int valeur;
	private String nom;
	
	public Caracteristique(int valeur, String nom) {
		this.valeur = valeur;
		this.nom = nom;
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Augmente ou diminue la valeur de la caractéristique selon le nombre.
	 * S'assure que la valeur de la caractéristique est toujours comprise entre 0
	 *  et VAL_MAX
	 * @param nombre
	 */
	public void setValeur(int nombre) {
		int nouvelle_valeur = this.valeur + nombre;
		if (nouvelle_valeur > VAL_MAX) {
			this.valeur = VAL_MAX;
		}else if (nouvelle_valeur < 0 ) {
			this.valeur = 0;
		}else {
			this.valeur = nouvelle_valeur;
		}
	}
	

}
