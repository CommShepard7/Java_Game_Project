package Jeu;

import java.util.List;
import java.util.Random;

import Arbitre.Arbitre;
import Joueur.Joueur;
import Missions.Mission;

public class Jouer {

	private int nbMissionsJoueur = 5;
	private Jeu jeu;

	public Jouer(Jeu jeu, int nbMissionsJoueur) {
		this.nbMissionsJoueur = nbMissionsJoueur;
		this.jeu = jeu;
	}

	public void attribuerMissions() {
		List<Mission> missions = this.jeu.getMissions();
		List<Joueur> joueurs = this.jeu.getJoueurs();
		Random rand = new Random();

		for (Joueur joueur : joueurs) {
			int nbMissions = 0;
			while (nbMissions != this.nbMissionsJoueur) {
				int numeroMission = rand.nextInt(missions.size());
				Mission mission = missions.get(numeroMission);
				joueur.setMission(mission);
				missions.remove(mission);
				nbMissions++;
			}

		}
		this.jeu.setJoueurs(joueurs);
	}

	public void parametrerCaracteristiques() {
		// TODO
	}

	public void lancer() {
		Arbitre arbitre = new Arbitre(this.jeu);
		this.parametrerCaracteristiques();
		this.attribuerMissions();
		// while (!arbitre.checkMission()) {
		// TODO
		// }
	}

}
