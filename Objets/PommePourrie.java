package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class PommePourrie extends Ressource {

	private final int FATIGUE = -50;
	
	

	public PommePourrie(Point position) {
		super(Ressources.POMME_POURRIE, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Aïe aïe aïe je perd beaucoup d'energie car je suis malade!");
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
		
	}

}
