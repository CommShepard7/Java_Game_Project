package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Caillou extends Ressource {
	
	

	public Caillou(Point position) {
		super(Ressources.CAILLOU, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();
		
	}

}
