package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Bois extends Ressource {
	
	

	public Bois(Point position) {
		super(Ressources.BOIS, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();
		
	}

}
