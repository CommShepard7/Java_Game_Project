package Actions;

import Jeu.Carte;

public abstract class ActionEnvironnement extends Action {


	public ActionEnvironnement(String nom, int identifiant, Carte carte) {
		this.nom = nom;
		this.identifiant = identifiant;
	}
}
