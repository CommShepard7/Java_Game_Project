package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class LancePierre extends Objet {

	public LancePierre(Point position) {
		super(Objets.LANCE_PIERRE, position, 7);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		Inventaire inventaire = j.getInventaire();
		this.dansInventaire(inventaire);
		// if chevre a proximité alors on peut utiliser
			try {
				inventaire.AjouterRessource(Ressources.CHEVRE,1);
			} catch (InventairePleinException e) {
				throw new ObjetNonUtilisableException();
			}
			this.tempsUtilisation(null);
		// sinon
			throw new ObjetNonUtilisableException();

	}

}
