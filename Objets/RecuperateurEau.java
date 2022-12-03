package Objets;

import java.awt.Point;
import Joueur.Joueur;

public class RecuperateurEau extends Objet {

	public RecuperateurEau(Point position) {
		super(Objets.RECUPERATEUR_EAU, position, 2);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		Inventaire inventaire = j.getInventaire();
		this.dansInventaire(inventaire);
		// if EAU est a proximité alors on peut faire ça :
			try {
				inventaire.AjouterRessource(Ressources.EAU, 1);
			} catch (InventairePleinException e) {
				throw new ObjetNonUtilisableException();
			}
			this.tempsUtilisation(null);
		// sinon
			throw new ObjetNonUtilisableException();
			// car ca veut dire qu'il n'y a pas d'eau pres du joueur
		
	}

}
