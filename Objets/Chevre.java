package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class Chevre extends Ressource {

	private final int FAIM = 5;
	private final int FATIGUE = 5;
	private boolean estVivante ;


	public Chevre(Point position) {
		super(Ressources.CHEVRE, position);
		this.estVivante = true;
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Ma faim et ma fatigue s'améliorent mais moins que si je la faisais cuire");
		j.getSignauxVitaux().get(Signes.FAIM.ordinal()).majJauge(FAIM);
		j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);

	}

	public boolean estVivante() {
		return this.estVivante;
	}

	public void tuerChevre() {
		this.estVivante = false;
	}

}
