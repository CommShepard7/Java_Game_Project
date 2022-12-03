package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class Feu extends Objet {

	private boolean allume;
	private final int FATIGUE = 10;

	public Feu(Point position) {
		super(Objets.FEU, position, 2);
		this.allume = false;
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException { // Mettre aProximite() dans utiliser ?
		this.aProximite();
		// this.allumé = !this.allumé;
		if (this.allume) {
			j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(FATIGUE);
			this.tempsUtilisation(null);
		} else {
			throw new ObjetNonUtilisableException();
		}
	}

	public static boolean estAllume(Feu feu) {
		return feu.allume;
	}

	public void allumer() {
		this.allume = true;
	}

	public void eteindre() {
		this.allume = false;
	}

}
