package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class ChevreCuite extends Ressource {

	private final int FAIM = 10;
	private final int FATIGUE = 10;


	public ChevreCuite(Point position) {
		super(Ressources.CHEVRE_CUITE, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Ma faim et ma fatigue s'améliorent.");
		j.getSignauxVitaux().get(Signes.FAIM.ordinal()).majJauge(FAIM);
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
	}

}
