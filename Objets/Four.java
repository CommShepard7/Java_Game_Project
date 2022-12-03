package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Four extends Objet {

	public Four(Point position) {
		super(Objets.FOUR, position, 4);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		this.aProximite();
		try {
			Inventaire inventaire = j.getInventaire();
			inventaire.EnleverRessource(Ressources.CHEVRE, 1);
			inventaire.AjouterRessource(Ressources.CHEVRE_CUITE, 1);
			this.tempsUtilisation(null);
		} catch (ElementNonPresentException e) {
			System.out.println("Il n'y a pas de chevre crue dans votre inventaire");
			throw new ObjetNonUtilisableException();
		} catch (InventairePleinException e) {
			throw new ObjetNonUtilisableException();
		}
		
	}

}
