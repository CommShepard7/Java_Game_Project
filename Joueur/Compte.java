package Joueur;

import java.awt.Color;

public class Compte {

	private int argent;

	private Compte[] amis;

	@SuppressWarnings("unused")
	private Color[] skins;

	public Compte() {
		this.argent = 0; // TODO on commence à combien ?
	}

	public void ajouterArgent(int montant) {
		this.argent += montant;
	}

	public void retirerArgent(int montant) {
		if (montant > this.argent) {
			this.argent = 0;
		} else {
			this.argent -= montant;
		}
	}

	public void ajouterAmis(Compte ami) {
		this.amis[this.amis.length + 1] = ami;
	}

	public void retirerAmis(Compte ami) {
		// Il faudrait pas rajouter en attribut un nom ou un identifiant ?
		// ça pourrait serait plus simple pour retirer / ajouter des amis et les rentrer
		// en mémoire
	}

	public void changerSkin(Color skin) {

	}

}
