package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Diamant extends Ressource {
	
	

	public Diamant(Point position) {
		super(Ressources.DIAMANT, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();
		
	}

}
