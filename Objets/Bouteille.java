package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Bouteille extends Ressource {

	public Bouteille(Point position) {
		super(Ressources.BOUTEILLE, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();

	}

}
