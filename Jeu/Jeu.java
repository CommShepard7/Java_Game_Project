package Jeu;

import java.util.ArrayList;
import java.util.List;

import Actions.Action;
import Actions.ActionRamasserRessource;
import Joueur.Joueur;
import Missions.Mission;
import Objets.Objet;
import Objets.Ressource;

@SuppressWarnings("unused")
public class Jeu {

	public static Carte carte;
	// private Mission[] missions;
	// private MiniJeu[] minijeux;
	private List<Joueur> joueurs;
	@SuppressWarnings("unused")
	private List<Action> actions;
	private List<Mission> missions;

	@SuppressWarnings("static-access")
	public Jeu(List<String> nomJoueurs, List<Objet> objets, List<Ressource> ressources, List<Mission> missions) {

		// Joueurs
		this.joueurs = new ArrayList<Joueur>();
		for (String nom : nomJoueurs) {
			this.joueurs.add(new Joueur(nom, java.awt.Color.RED)); // il faut mettre la couleur
		}

		// Actions
		this.actions = new ArrayList<>();
		// actions.add(new ActionRamasserRessource(nom, identifiant, ressource));
		// il faut peut-etre les mettre dans une map avec comme clef une enumeration de
		// la ressource ou de l'objet en question
		// quoi que ca marche pas pcq on peut manger et ramasser une pomme donc la clef
		// n'est pas unique
		// a voir comment faire au niveau de l'id et tout, est-ce qu'on le garde etc.
		this.carte = new Carte(objets, ressources);

		// Missions
		this.missions = missions;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;

	}

}
