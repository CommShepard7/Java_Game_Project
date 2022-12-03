package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Bouilloire extends Objet {

	public Bouilloire(Point position) {
		super(Objets.BOUILLOIRE, position, 3);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		this.aProximite();
		Inventaire inventaire = j.getInventaire();
		try {
			inventaire.EnleverRessource(Ressources.EAU_SALEE, 1);
			inventaire.AjouterRessource(Ressources.EAU, 1);
			this.tempsUtilisation(null);
		} catch (ElementNonPresentException e) {
			throw new ObjetNonUtilisableException();
		} catch (InventairePleinException e) {
			throw new ObjetNonUtilisableException();
		}
	}

}
