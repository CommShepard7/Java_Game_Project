package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class Lit extends Objet {

	private final int FATIGUE = 20;

	public Lit(Point position) {
		super(Objets.LIT, position, 5);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		// if this.objet est a proximité alors on peut faire ça :
			this.tempsUtilisation(j.getNom() + " s'endort pendant 5 secondes et récupère de l'énergie.");
			j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
			this.tempsUtilisation(null);
		// sinon
			throw new ObjetNonUtilisableException();
			// car ca veut dire qu'il n'y a pas l'objet pres du joueur
		
	}

}
