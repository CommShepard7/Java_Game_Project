package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Hachette extends Objet {

	public Hachette(Point position) {
		super(Objets.HACHETTE, position, 4);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		Inventaire i = j.getInventaire();
		this.dansInventaire(i);
		if (i.estPresent(Ressources.BOIS)) {
			try {
				i.AjouterRessource(Ressources.BOIS, 1);
			} catch (InventairePleinException e) {
				throw new ObjetNonUtilisableException();
			}
			this.tempsUtilisation(null);
		} else {
			throw new ObjetNonUtilisableException();
		}
	}

}
