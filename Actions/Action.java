package Actions;

import Joueur.Joueur;

public abstract class Action {
	
	/**
	 * Nom de l'action
	 */
	protected String nom;
	
	/**
	 * Identifiant de l'action
	 */
	protected int identifiant;
	
	/**
	 * Obtenir le nom de l'action
	 * @return nom de l'action
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Obtenir l'identifiant de l'action
	 * @return identifiant de l'action
	 */
	public int getIdentifiant() {
		return this.identifiant;
	}

	/**
	 * Realiser l'action
	 */
	public abstract void realiser(Joueur j, String[] args) throws ActionNonRealisableException;

}
