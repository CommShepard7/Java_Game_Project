package Missions;

import Actions.Action;

public abstract class Mission {

	/**
	 * Nom associé à la mission
	 */
	protected String nom;

	/**
	 * Points associés à la mission
	 */
	protected int points;

	/**
	 * Constructeur de la mission
	 *
	 * @param nom    nom de la mission
	 * @param points associés à la mission
	 */
	public Mission(String nom, int points) {
		this.nom = nom;
		this.points = points;
	}

	/**
	 * Renvoie si la mission est terminée ou non
	 *
	 * @return retourne vrai si la mission est terminée
	 */
	public abstract boolean estRealisee();

	/**
	 * Mets à jour la mission selon l'action effectuée par le joueur
	 *
	 * @param action Action que le joueur sera amenée a effectuer
	 */
	public abstract void majMission(Action action);

	/**
	 * Obtenir le nombre de points d'une mission
	 *
	 * @return points associés à la mission
	 */
	public int getPoints() {
		return this.points;
	}

	public String getNom() {
		return this.nom;
	}

}
