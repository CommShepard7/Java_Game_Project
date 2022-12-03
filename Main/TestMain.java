package Main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Actions.Action;
import Actions.ActionAvalerRessource;
import Actions.ActionConstruireObjet;
import Actions.ActionLacherRessource;
import Actions.ActionRamasserRessource;
import Actions.ActionUtiliserObjet;
import Jeu.Carte;
import Jeu.Deplacement;
import Jeu.Jeu;
import Missions.Mission;
import Missions.MissionAvalerPommePourrie;
import Missions.MissionConstruireObjet;
import Missions.MissionRamasserRessource;
import Missions.MissionUtiliserFeu;
import Objets.Allumette;
import Objets.Banane;
import Objets.Bois;
import Objets.Bouilloire;
import Objets.Bouteille;
import Objets.Caillou;
import Objets.Chevre;
import Objets.ChevreCuite;
import Objets.Diamant;
import Objets.Eau;
import Objets.EauSalee;
import Objets.ElementNonPresentException;
import Objets.Feu;
import Objets.Four;
import Objets.Hachette;
import Objets.Inventaire;
import Objets.InventairePleinException;
import Objets.Lit;
import Objets.Minerai;
import Objets.NoixDeCoco;
import Objets.Objet;
import Objets.Objets;
import Objets.Paille;
import Objets.Pomme;
import Objets.PommePourrie;
import Objets.RecuperateurEau;
import Objets.Ressource;
import Objets.Ressources;
import Objets.Tronconneuse;
import SignauxVitaux.Signes;

public class TestMain {

	private List<String> joueurNom;

	private Carte map;

	private Jeu jeu;

	private Action avalerPomme;
	private Action avalerEau;
	private Action avalerEauSalee;
	private Action avalerChevre;
	private Action avalerPaille;
	private Action avalerChevreCuite;
	private Action construireLit;
	private Action lacherPomme;
	private Action utiliserLit;
	private Action utiliserFeu;
	private Action utiliserFour;
	private Action environnement;
	private Action poserObjet;

	private Objets[] objetNoms = Objets.values();
	private List<Objet> objets;

	private List<Mission> missions;

	private Ressources[] ressourcesNoms = Ressources.values();
	private List<Ressources> ressourcesLit;
	private List<Ressource> ressources;

	private Inventaire inventaire;

	private Signes[] signes = Signes.values();

	@Before
	public void setRessourcesObjets() {

		missions = new ArrayList<Mission>();
		ressources = new ArrayList<Ressource>();
		ressourcesLit = new ArrayList<Ressources>();
		objets = new ArrayList<Objet>();

		ressources.add(new Eau(new Point(100, 100)));
		ressources.add(new EauSalee(new Point(110, 100)));
		ressources.add(new Diamant(new Point(120, 100)));
		ressources.add(new Chevre(new Point(130, 100)));
		ressources.add(new ChevreCuite(new Point(140, 100)));
		ressources.add(new Pomme(new Point(150, 100)));
		ressources.add(new PommePourrie(new Point(170, 100)));
		ressources.add(new Caillou(new Point(180, 100)));
		ressources.add(new Bouteille(new Point(190, 100)));
		ressources.add(new Minerai(new Point(200, 100)));
		ressources.add(new Paille(new Point(210, 100)));
		ressources.add(new NoixDeCoco(new Point(220, 100)));
		ressources.add(new Banane(new Point(230, 100)));
		ressources.add(new Bois(new Point(240, 100)));

		ressourcesLit.add(Ressources.BOIS);

		objets.add(new Allumette(new Point(300, 200)));
		objets.add(new Bouilloire(new Point(310, 200)));
		objets.add(new Feu(new Point(320, 200)));
		objets.add(new Four(new Point(330, 200)));
		objets.add(new Hachette(new Point(340, 200)));
		objets.add(new Lit(new Point(350, 200)));
		objets.add(new RecuperateurEau(new Point(360, 200)));
		objets.add(new Tronconneuse(new Point(370, 200)));

		missions.add(new MissionRamasserRessource(Ressources.POMME, 2, 100));
		missions.add(new MissionRamasserRessource(Ressources.NOIX_DE_COCO, 1, 50));
		missions.add(new MissionRamasserRessource(Ressources.CHEVRE, 3, 150));

		joueurNom = new ArrayList<String>();
		joueurNom.add("Player");

		avalerPomme = new ActionAvalerRessource("AvalerRessource", 1, Ressources.POMME);

		construireLit = new ActionConstruireObjet("ConstruireLit", 1, Objets.LIT, ressourcesLit);
		lacherPomme = new ActionLacherRessource("", 1, Ressources.POMME);

		avalerEau = new ActionAvalerRessource("AvalerRessource", 1, Ressources.EAU);
		avalerEauSalee = new ActionAvalerRessource("AvalerRessource", 1, Ressources.EAU_SALEE);
		avalerPaille = new ActionAvalerRessource("AvalerRessource", 1, Ressources.PAILLE);
		avalerChevreCuite = new ActionAvalerRessource("AvalerRessource", 1, Ressources.CHEVRE_CUITE);
		;
		utiliserLit = new ActionUtiliserObjet("UtiliserLit", 1, Objets.LIT);
		utiliserFour = new ActionUtiliserObjet("UtiliserFour", 1, Objets.FOUR);

		jeu = new Jeu(joueurNom, objets, ressources, missions);
		jeu.getJoueurs().get(0).setPosition(new Point(150, 200));

	}

	@Test
	public void testInitJoueur() {

		assertEquals(jeu.getJoueurs().get(0).getNom(), "Player");
		assertEquals(jeu.getJoueurs().get(0).getCouleur(), Color.RED);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(150, 200));
		jeu.getJoueurs().get(0).ajouterDiamants(30);
		assertEquals(jeu.getJoueurs().get(0).getDiamants(), 30);
		jeu.getJoueurs().get(0).enleverDiamants(20);
		assertEquals(jeu.getJoueurs().get(0).getDiamants(), 10);
		jeu.getJoueurs().get(0).ajouterPoints(120);
		assertEquals(jeu.getJoueurs().get(0).getPoints(), 120);
		jeu.getJoueurs().get(0).enleverPoints(10);
		assertEquals(jeu.getJoueurs().get(0).getPoints(), 110);
		assertEquals(jeu.getJoueurs().get(0).getCaracteristiques().get(0).getValeur(), 5);
		assertEquals(jeu.getJoueurs().get(0).getCaracteristiques().get(1).getValeur(), 5);
		assertEquals(jeu.getJoueurs().get(0).getCaracteristiques().get(2).getValeur(), 5);

	}

	@Test
	public void testInitRessources() {

		assertEquals(jeu.carte.getRessources().get(0).getPosition(), new Point(100, 100));
		assertEquals(jeu.carte.getRessources().get(1).getPosition(), new Point(110, 100));
		assertEquals(jeu.carte.getRessources().get(2).getPosition(), new Point(120, 100));
		assertEquals(jeu.carte.getRessources().get(12).getPosition(), new Point(230, 100));

		assertEquals(jeu.carte.getRessources().get(0).getNom(), Ressources.EAU);
		assertEquals(jeu.carte.getRessources().get(1).getNom(), Ressources.EAU_SALEE);
		assertEquals(jeu.carte.getRessources().get(2).getNom(), Ressources.DIAMANT);
		assertEquals(jeu.carte.getRessources().get(12).getNom(), Ressources.BANANE);
		assertEquals(ressourcesLit.get(0), Ressources.BOIS);

	}

	@Test
	public void testInitObjets() {

		assertEquals(jeu.carte.getObjets().get(0).getPosition(), new Point(300, 200));
		assertEquals(jeu.carte.getObjets().get(1).getPosition(), new Point(310, 200));
		assertEquals(jeu.carte.getObjets().get(2).getPosition(), new Point(320, 200));
		assertEquals(jeu.carte.getObjets().get(3).getPosition(), new Point(330, 200));

		assertEquals(jeu.carte.getObjets().get(0).getNom(), Objets.ALLUMETTE);
		assertEquals(jeu.carte.getObjets().get(1).getNom(), Objets.BOUILLOIRE);
		assertEquals(jeu.carte.getObjets().get(2).getNom(), Objets.FEU);
		assertEquals(jeu.carte.getObjets().get(3).getNom(), Objets.FOUR);
		assertEquals(jeu.carte.getObjets().get(7).getNom(), Objets.TRONCONNEUSE);

	}

	@Test
	public void testDeplacement() {

		jeu.getJoueurs().get(0).seDeplacer(Deplacement.NORD);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(150, 198));
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.EST);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(152, 198));
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.OUEST);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(150, 198));
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.SUD);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(150, 200));
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.OUEST);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(148, 200));
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.OUEST);
		assertEquals(jeu.getJoueurs().get(0).getPosition(), new Point(148, 200));

	}

	@Test
	public void testActionsAvalerRessources() {

		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.POMME, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU_SALEE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.CHEVRE_CUITE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.PAILLE, 1);
		} catch (InventairePleinException e) {

		}

		jeu.getJoueurs().get(0).seDeplacer(Deplacement.NORD);

		jeu.getJoueurs().get(0).faireAction(avalerPomme, null);

		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FAIM.ordinal()).getJauge(), 60);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal()).getJauge(), 60);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.SOIF.ordinal()).getJauge(), 50);

		jeu.getJoueurs().get(0).faireAction(avalerEauSalee, null);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FAIM.ordinal()).getJauge(), 60);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal()).getJauge(), 60);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.SOIF.ordinal()).getJauge(), 0);

		jeu.getJoueurs().get(0).faireAction(avalerEau, null);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FAIM.ordinal()).getJauge(), 60);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal()).getJauge(), 70);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.SOIF.ordinal()).getJauge(), 10);

		jeu.getJoueurs().get(0).faireAction(avalerChevreCuite, null);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FAIM.ordinal()).getJauge(), 70);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal()).getJauge(), 80);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.SOIF.ordinal()).getJauge(), 10);

		jeu.getJoueurs().get(0).faireAction(avalerPaille, null);

	}

	@Test
	public void testActionConstruireObjet() {

		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.BOIS, 1);
		} catch (InventairePleinException e) {

		}
		jeu.getJoueurs().get(0).faireAction(construireLit, null);
		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Objets.LIT));
		assertFalse(jeu.getJoueurs().get(0).getInventaire().estPresent(Ressources.BOIS));

	}

	@Test
	public void testActionUtiliserObjet() {

		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.BOIS, 1);
		} catch (InventairePleinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jeu.getJoueurs().get(0).seDeplacer(Deplacement.NORD);

		jeu.getJoueurs().get(0).faireAction(construireLit, null);
		jeu.getJoueurs().get(0).faireAction(utiliserLit, null);
		assertEquals(jeu.getJoueurs().get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal()).getJauge(), 70);

		jeu.getJoueurs().get(0).faireAction(utiliserFour, null);

	}

	public void Inventaire() throws ElementNonPresentException {

		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.POMME, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU_SALEE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.CHEVRE_CUITE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterObjet(Objets.LANCE_PIERRE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.EAU_SALEE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.CHEVRE_CUITE, 1);
			jeu.getJoueurs().get(0).getInventaire().AjouterObjet(Objets.LANCE_PIERRE, 1);
		} catch (InventairePleinException e) {

		}

		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Ressources.POMME));
		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Ressources.EAU));
		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Ressources.EAU_SALEE));
		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Ressources.CHEVRE_CUITE));
		assertTrue(jeu.getJoueurs().get(0).getInventaire().estPresent(Objets.LANCE_PIERRE));

		jeu.getJoueurs().get(0).getInventaire().EnleverObjet(Objets.LANCE_PIERRE, 1);
		jeu.getJoueurs().get(0).getInventaire().EnleverRessource(Ressources.POMME, 1);
		jeu.getJoueurs().get(0).getInventaire().EnleverObjet(Objets.LANCE_PIERRE, 1);

	}

	@Test
	public void testMissions() {

		jeu.getJoueurs().get(0).enleverPoints(jeu.getJoueurs().get(0).getPoints());

		jeu.carte.addRessource(new Pomme(new Point(120, 150)), 1);
		jeu.carte.addRessource(new Pomme(new Point(130, 150)), 2);
		jeu.carte.addRessource(new Pomme(new Point(140, 150)), 3);

		jeu.getJoueurs().get(0).setMission(new MissionConstruireObjet(Objets.LIT, 100));
		jeu.getJoueurs().get(0).setMission(new MissionAvalerPommePourrie());
		jeu.getJoueurs().get(0).setMission(new MissionRamasserRessource(Ressources.POMME, 3, 100));
		jeu.getJoueurs().get(0).setMission(new MissionUtiliserFeu());

		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.POMME_POURRIE, 1);
		} catch (InventairePleinException e) {

		}
		jeu.getJoueurs().get(0)
				.faireAction(new ActionAvalerRessource("AvalerPommePourrie", 1, Ressources.POMME_POURRIE), null);

		assertEquals(jeu.getJoueurs().get(0).getPoints(), 150);
		try {
			jeu.getJoueurs().get(0).getInventaire().AjouterRessource(Ressources.BOIS, 1);
		} catch (InventairePleinException e) {

		}
		jeu.getJoueurs().get(0).faireAction(construireLit, null);
		System.out.println(jeu.getJoueurs().get(0).missions);
		assertEquals(jeu.getJoueurs().get(0).getPoints(), 350);

		jeu.getJoueurs().get(0).faireAction(new ActionRamasserRessource("RamasserPomme", 1, Ressources.POMME),
				new String[] { "1" });
		jeu.getJoueurs().get(0).faireAction(new ActionRamasserRessource("RamasserPomme", 1, Ressources.POMME),
				new String[] { "2" });
		jeu.getJoueurs().get(0).faireAction(new ActionLacherRessource("RamasserPomme", 1, Ressources.POMME),
				new String[] { "2" });
		jeu.getJoueurs().get(0).faireAction(new ActionRamasserRessource("RamasserPomme", 1, Ressources.POMME),
				new String[] { "2" });

		assertEquals(jeu.getJoueurs().get(0).getPoints(), 350);
		jeu.getJoueurs().get(0).faireAction(new ActionRamasserRessource("RamasserPomme", 1, Ressources.POMME),
				new String[] { "3" });

		assertEquals(jeu.getJoueurs().get(0).getPoints(), 450);

	}

}
