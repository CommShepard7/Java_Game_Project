package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Paille extends Ressource {
	
	

	public Paille(Point position) {
		super(Ressources.PAILLE, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();
		
	}

}
