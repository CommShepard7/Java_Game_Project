package Objets;

import java.awt.Point;

import Joueur.Joueur;

public abstract class Objet {

	private Objets nom;
	private Point position;
	private final int DUREE_UTILISATION;

	public Objet(Objets objet, Point position, int DUREE_UTILISATION) {
		this.nom = objet;
		this.position = position;
		this.DUREE_UTILISATION = DUREE_UTILISATION;
	}

	public Objets getNom() {
		return this.nom;
	}

	public Point getPosition() {

		return this.position;

	}

	protected void tempsUtilisation(String message) {
		try {
			System.out.println(message);
			Thread.sleep(DUREE_UTILISATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void aProximite() throws ObjetNonUtilisableException {
		// if this est pas a proximité alors :
		throw new ObjetNonUtilisableException();
		// car ca veut dire qu'il n'y a pas l'objet pres du joueur
	}

	protected void dansInventaire(Inventaire i) throws ObjetNonUtilisableException {
		if (!i.estPresent(this.nom)) {
			throw new ObjetNonUtilisableException();
		}
	}

	public abstract void utiliser(Joueur j) throws ObjetNonUtilisableException;

	public static final Objet instancierObjet(Objets r, Point position) {
		switch (r) {
		case RECUPERATEUR_EAU:
			return new RecuperateurEau(position);
		case LIT:
			return new Lit(position);
		case FEU:
			return new Feu(position);
		case BOUILLOIRE:
			return new Bouilloire(position);
		case FOUR:
			return new Four(position);
		case LANCE_PIERRE:
			return new LancePierre(position);
		case ALLUMETTE:
			return new Allumette(position);
		case TRONCONNEUSE:
			return new Tronconneuse(position);
		case HACHETTE:
			return new Hachette(position);
		default:
			return null;
		}
	}
	
	public static final boolean isObjet (String chaine) {
		for (Objets objet : Objets.values()) {
			if (objet.name().equals(chaine)) {
				return true;
			}
		}
		return false;
	}
}
