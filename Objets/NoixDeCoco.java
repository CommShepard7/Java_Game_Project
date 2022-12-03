package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class NoixDeCoco extends Ressource {
	
	private final int FAIM = 10;
	private final int FATIGUE = 10;
	

	public NoixDeCoco(Point position) {
		super(Ressources.NOIX_DE_COCO, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Ma faim et ma fatigue s'améliorent.");
		j.getSignauxVitaux().get(Signes.FAIM.ordinal()).majJauge(FAIM);
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
		
	}

}
