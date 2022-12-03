package Actions;

import Objets.Objets;

public abstract class ActionObjet extends Action {

	/**
	 * Objet associé à l'action
	 */
	protected Objets objet;

	public ActionObjet(String nom, int identifiant, Objets objet) {
		this.nom = nom;
		this.identifiant = identifiant;
		this.objet = objet;
	}

	/**
	 * Obtenir l'objet associé à l'action
	 * 
	 * @return
	 */
	public Objets getObjet() {
		return this.objet;
	}

}
