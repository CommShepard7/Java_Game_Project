package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Tronconneuse extends Objet {

	public Tronconneuse(Point position) {
		super(Objets.TRONCONNEUSE, position, 6);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		Inventaire i = j.getInventaire();
		this.dansInventaire(i);
		if (i.estPresent(Ressources.BOIS)) {
			try {
				i.AjouterRessource(Ressources.BOIS, 2);
			} catch (InventairePleinException e) {
				throw new ObjetNonUtilisableException();
			}
			this.tempsUtilisation(null);
		} else {
			throw new ObjetNonUtilisableException();
		}

	}

}
