package Objets;

import java.awt.Point;

import Joueur.Joueur;
import SignauxVitaux.Signes;

public class EauSalee extends Ressource {
	
	private final int SOIF = -50;
	

	public EauSalee(Point position) {
		super(Ressources.EAU_SALEE, position);
	}

	@Override
	public void avaler(Joueur j) {
		System.out.println("Aïe aïe aïe j'ai très soif maintenant");
		j.getSignauxVitaux().get(Signes.SOIF.ordinal()).majJauge(SOIF);
		
	}

}
