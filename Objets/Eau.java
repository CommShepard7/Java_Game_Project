package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class Eau extends Ressource {
	
	private final int SOIF = 10;
	private final int FATIGUE = 10;
	
	

	public Eau(Point position) {
		super(Ressources.EAU, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Ma soif et ma fatigue s'améliorent.");
		j.getSignauxVitaux().get(Signes.SOIF.ordinal()).majJauge(SOIF);
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
		
	}

}
