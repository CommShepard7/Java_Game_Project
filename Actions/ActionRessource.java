package Actions;

import Objets.Ressources;

public abstract class ActionRessource extends Action {

	/**
	 * Ressource associée à l'action
	 */
	protected Ressources ressource;

	public ActionRessource(String nom, int identifiant, Ressources ressource) {
		this.nom = nom;
		this.identifiant = identifiant;
		this.ressource = ressource;
	}

	/**
	 * Obtenir la ressource associée à l'action
	 * 
	 * @return
	 */
	public Ressources getRessource() {
		return this.ressource;
	}

	
}
