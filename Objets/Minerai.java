package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Minerai extends Ressource {
	
	

	public Minerai(Point position) {
		super(Ressources.MINERAI, position);
	}

	@Override
	public void avaler(Joueur j) throws NonComestibleException {
		throw new NonComestibleException();
		
	}

}
