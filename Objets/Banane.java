package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class Banane extends Ressource {
	
	private final int FAIM = 10;
	private final int FATIGUE = 10;
	

	public Banane(Point position) {
		super(Ressources.BANANE, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Ma faim et ma fatigue s'améliorent.");
		j.getSignauxVitaux().get(Signes.FAIM.ordinal()).majJauge(FAIM);
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
		
	}

}
