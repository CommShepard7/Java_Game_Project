package Joueur;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Actions.Action;
import Actions.ActionNonRealisableException;
import Caracteristiques.Capacite;
import Caracteristiques.Caracteristique;
import Caracteristiques.Endurance;
import Caracteristiques.Perception;
import Caracteristiques.Rapidite;
import Jeu.Deplacement;
import Jeu.DeplacementInterditException;
import Jeu.Jeu;
import Missions.Mission; // AJOUT PAR DAVID MAIS A VOIR !!!!
import Objets.Inventaire;
import SignauxVitaux.Faim;
import SignauxVitaux.Fatigue;
import SignauxVitaux.SignalVital;
import SignauxVitaux.Signes;
import SignauxVitaux.Soif;

public class Joueur {

	/* Argent du joueur */
	private int diamants;

	/* Nombre de points du joueur */
	private int points;

	/* Position du joueur */
	private Point position;

	/* Nom du joueur */
	private String nom;

	private Color couleur;

	private List<SignalVital> signauxVitaux;

	private List<Caracteristique> caracteristiques;

	public List<Mission> missions; // AJOUT PAR DAVID MAIS A VOIR !!!!

	private Inventaire inventaire;

	public Joueur(String nomDuJoueur, Color couleur) {
		this.diamants = 0; // TODO a combien on demarre ?
		this.points = 0;
		this.position = new Point(0, 0); //TODO
		this.nom = nomDuJoueur;
		this.inventaire = new Inventaire(20);  //20 = capacité max
		this.couleur = couleur;

		this.missions = new ArrayList<Mission>(); // AJOUT PAR DAVID MAIS A VOIR !!!!

		this.signauxVitaux = new ArrayList<SignalVital>();
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.signauxVitaux.add(Signes.FAIM.ordinal(), new Faim());
		this.signauxVitaux.add(Signes.FATIGUE.ordinal(), new Fatigue());
		this.signauxVitaux.add(Signes.SOIF.ordinal(), new Soif());

		this.caracteristiques.add(new Capacite());
		this.caracteristiques.add(new Endurance());
		this.caracteristiques.add(new Perception());
		this.caracteristiques.add(new Rapidite());
	}

	/**
	 * Obtenir le nom du joueur
	 *
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modofier le nom du joueur
	 *
	 * @param nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir le nombre de diamants du joueur
	 *
	 * @return le nombre de diamants du joueur
	 */
	public int getDiamants() {
		return diamants;
	}

	/**
	 * Ajouter des diamants au joueur
	 *
	 * @param diamants
	 */
	public void ajouterDiamants(int diamants) {
		this.diamants += diamants;
	}

	/**
	 * Enlever des diamants au joueur
	 *
	 * @param diamants
	 */
	public void enleverDiamants(int diamants) {
		if (diamants > this.diamants) {
			this.diamants = 0;
		} else {
			this.diamants -= diamants;
		}
	}

	/**
	 * Obtenir le nombre de points du joueur
	 *
	 * @return le nombre de points du joueur
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Ajouter des points au joueur
	 *
	 * @param points
	 */
	public void ajouterPoints(int points) {
		this.points += points;
	}

	/**
	 * Enlever des points au joueur
	 *
	 * @param points
	 */
	public void enleverPoints(int points) {
		if (points > this.points) {
			this.points = 0;
		} else {
			this.points -= points;
		}
	}

	/**
	 * Obtenir a position du joueur
	 *
	 * @return position du joueur
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Modifier la position du joueur
	 *
	 * @param position du joueur
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * Réaliser une action
	 *
	 * @param action a realiser
	 */
	public void faireAction(Action a, String[] args) {
		try {
			a.realiser(this, args);
			majMissions(a);
		} catch (ActionNonRealisableException e) {
			System.out.println("L'action " + a.getNom() + " n'est pas réalisable");
		}
	}

	/**
	 * Mise à jour des missions
	 *
	 * @param a
	 */
	public void majMissions(Action a) {
		List<Integer> missionsRealises = new ArrayList<Integer>();
		int i = 0;
		int c = 0;
		for (Mission mission : this.missions) {
			mission.majMission(a);                          // AJOUT PAR DAVID MAIS A VOIR !!!!
			if (mission.estRealisee()) {
				this.ajouterPoints(mission.getPoints());
				i = this.missions.indexOf(mission);
				c++;
				missionsRealises.add(this.missions.indexOf(mission));
                System.out.println(missionsRealises);
			}
		}

		if (c != 0) {
		this.missions.remove(i);
		c = 0;
		}

		for (Integer k : missionsRealises) {
			System.out.println(k);
		    this.missions.remove(k);

		}
		System.out.println(this.missions.size());

		missionsRealises.clear();
	}

	/*
	 * Pourquoi ta fonction prend pas en compte l'argument direction ?
	 */
	public void seDeplacer(Deplacement direction) {
		try {
			// enlever faim, soif, fatigue
			Jeu.carte.verifierDeplacement(direction, this.getPosition());
			this.signauxVitaux.get(0).majJauge(-50);
			this.signauxVitaux.get(1).majJauge(-50);
			this.signauxVitaux.get(2).majJauge(-50);
			switch (direction) {
			case NORD:

				this.position.translate(0, -2);
				//this.position[1] -= 2;

				break;

			case SUD:

				this.position.translate(0, 2);
				//this.position[1] += 2;

				break;

			case EST:

				this.position.translate(2, 0);
				//this.position[0] += 2;

				break;

			case OUEST:

				this.position.translate(-2, 0);
				//this.position[0] -= 2;

				break;

			}

		} catch (DeplacementInterditException e) {
			System.out.println("Vous ne pouvez pas vous deplacer dans cette direction");
		}
	}

	public List<SignalVital> getSignauxVitaux() {
		return signauxVitaux;
	}

	public void setSignauxVitaux(List<SignalVital> signauxVitaux) {
		this.signauxVitaux = signauxVitaux;
	}

	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public void setMission(Mission mission) {
		this.missions.add(mission); // AJOUT PAR DAVID MAIS A VOIR !!!!
	}

	public Inventaire getInventaire() {
		return this.inventaire;
	}

}
