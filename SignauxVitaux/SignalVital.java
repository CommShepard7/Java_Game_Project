package SignauxVitaux;

import java.awt.Color;

public abstract class SignalVital {
	public final int JAUGE_PLEINE = 100;
	
	private double jauge;
	private String nom;
	private Color couleur;
	
	public SignalVital(String nom, Color couleur) {
		this.jauge = JAUGE_PLEINE;
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public double getJauge() {
		return this.jauge;
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Augmente ou diminue la valeur de la jauge selon le nombre.
	 * S'assure que la valeur de la jauge est toujours comprise entre 0 et JAUGE_PLEINE
	 * @param d
	 */
	public void majJauge(double d) {
		double nouvelle_jauge = this.jauge + d;
		if (nouvelle_jauge > JAUGE_PLEINE) {
			this.jauge = JAUGE_PLEINE;
		}else if (nouvelle_jauge < 0 ) {
			this.jauge = 0;
		}else {
			this.jauge = nouvelle_jauge;
		}
	}

}
