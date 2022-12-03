package Main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Carte2D.CarteV2;
import Jeu.Jeu;
import Missions.Mission;
import Missions.MissionRamasserRessource;
import Objets.Allumette;
import Objets.Chevre;
import Objets.Feu;
import Objets.Lit;
import Objets.NoixDeCoco;
import Objets.Objet;
import Objets.Pomme;
import Objets.Ressource;
import Objets.Ressources;

public class Main {

	private static List<String> nomJoueurs = new ArrayList<String>();
	private static List<Objet> objets = new ArrayList<Objet>();
	private static List<Ressource> ressources = new ArrayList<Ressource>();
	private static List<Mission> missions = new ArrayList<Mission>();

	public static void initJoueurs() {
		nomJoueurs.add("Shepard");
	}

	public static void initObjets() {
		objets.add(new Feu(new Point(4410, 3270)));
		// objets.add(new Feu(new Point(900, 450)));
		objets.add(new Allumette(new Point(4500, 3550)));
		objets.add(new Lit(new Point(5300, 3150)));

	}

	public static void initRessources() {
		ressources.add(new Pomme(new Point(5250, 3750)));
		ressources.add(new Pomme(new Point(4950, 3700)));
		ressources.add(new NoixDeCoco(new Point(4410, 4200)));
		ressources.add(new Chevre(new Point(4280, 4150)));
		ressources.add(new Chevre(new Point(4050, 4300)));
		ressources.add(new Chevre(new Point(4150, 3800)));

	}

	public static void initMissions() {
		missions.add(new MissionRamasserRessource(Ressources.POMME, 2, 100));
		missions.add(new MissionRamasserRessource(Ressources.NOIX_DE_COCO, 1, 50));
		missions.add(new MissionRamasserRessource(Ressources.CHEVRE, 3, 150));
		missions.add(new MissionRamasserRessource(Ressources.POMME, 2, 100));
		missions.add(new MissionRamasserRessource(Ressources.NOIX_DE_COCO, 4, 50));
		missions.add(new MissionRamasserRessource(Ressources.CHEVRE, 2, 150));
		missions.add(new MissionRamasserRessource(Ressources.POMME, 1, 100));
		missions.add(new MissionRamasserRessource(Ressources.NOIX_DE_COCO, 2, 50));
		missions.add(new MissionRamasserRessource(Ressources.CHEVRE, 1, 150));

	}

	private static Jeu jeu;

	private static CarteV2 map;

	public static void main(String[] args) {
		initObjets();
		initRessources();
		initJoueurs();
		initMissions();
		jeu = new Jeu(nomJoueurs, objets, ressources, missions); // Objet = le type ou l'ensemble des objets
		jeu.getJoueurs().get(0).setPosition(new Point(400, 500));
		// jeu.getJoueurs().get(0).setMission(new
		// MissionRamasserRessource(Ressources.POMME, 2, 100));
		// Jouer jouer = new Jouer(jeu, 3);
		// jouer.lancer();
		map = new CarteV2(jeu);
		map.launch();

	}

}
