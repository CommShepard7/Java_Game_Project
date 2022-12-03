package Jeu;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Objets.Objet;
import Objets.Ressource;

public class Carte {

	private final int sizeX = 10000;
	private final int sizeY = 10000;

	/**
	 * Pas vraiments des cases, plutot un espace 2D avec un systeme de coordonees
	 * (x,y). sizeX, sizeY dimensions de la carte
	 */

	/**
	 *
	 * Les objets sur la carte peuvent etre initialises a partir de l'attribut
	 * Position initial des objets/ressourses(Voir demo).
	 *
	 * L'attribut Position sera ensuite mis a jour lorsqu'une ressource/objet est
	 * modifie.
	 *
	 * La classe Carte est utile pour manipuler les coordonnes (au lieu de le faire
	 * directement dans la partie Swing)
	 *
	 */
	@SuppressWarnings("unused")
	private int[][] cases;
	@SuppressWarnings("unused")
	private int[][] distancesRelativesObjets; // Pour detecter une collision avec un objet non marchable
	@SuppressWarnings("unused")
	private int[][] positionsRelativesObjets; // Pour gerer les collisions avec les objets non matchables
	private List<Objet> objetsMap = new ArrayList<Objet>();
	private List<Ressource> ressourceMap = new ArrayList<Ressource>();
	private int zoneInterdite = 147;

	public Carte(List<Objet> objetsMap, List<Ressource> ressourceMap) {

		this.cases = new int[sizeX][sizeY];
		this.objetsMap = objetsMap;
		this.ressourceMap = ressourceMap;

	}

	/**
	 * Ces methodes permettront de connaitre les coordonees des jLabels a placer sur
	 * la carte lors de son initialisation.
	 *
	 * Voir l128 de CarteDemo : Initialisation d'un cookie avec x = 460, y = 310, W
	 * = 20, H = 20
	 *
	 * Les objets et ressources doivent se trouver dans un array (pour
	 * l'initialisation des EventListeners) et les handlers des evenements
	 *
	 * Les coordonees des objets/ressources sont accesibles avec l'attribut Position
	 *
	 * @return
	 */

	/**
	 * Ce sera probablement des constantes
	 *
	 */

	/**
	 * Changer les coordonnees d'un objet lorsqu'il est construit, par exemple.
	 * Changer les coordonnees d'une ressource lorsqu'elle est jetee, pour la mettre
	 * au meme endroit que le joueur.
	 */

	public boolean collision(/* <?> extends Objet , joueur **/ ) {

		return false;

	}

	public boolean objetRamassable(/* <?> extends Objet **/) { /**
																 * Savoir si le joueur est a proximite d'un objet pour
																 * le ramasser
																 */
		return false;

	}

	public boolean verifierPosition(int x, int y) {
		return false;
	}

	public void verifierDeplacement(Deplacement direction, Point position) throws DeplacementInterditException {

		switch (direction) {
		case NORD:
			if (position.getX() + 2 <= zoneInterdite) {
				// if (position[0] + 2 <= zoneInterdite) {

				throw new DeplacementInterditException();
			}

			break;

		case SUD:
			if (position.getY() - 2 <= zoneInterdite) {
				// if (position[1] - 2 <= zoneInterdite) {

				throw new DeplacementInterditException();
			}
			break;

		case EST:
			if (position.getY() + 2 <= zoneInterdite) {
				// if (position[1] + 2 <= zoneInterdite) {

				throw new DeplacementInterditException();
			}

			break;

		case OUEST:
			if (position.getX() - 2 <= zoneInterdite) {
				// if (position[0] - 2 <= zoneInterdite) {

				throw new DeplacementInterditException();

			}

			break;

		}
	}

	public void retirerRessource(int labelNum) {

		this.ressourceMap.remove(labelNum);

	}

	public void retirerObjet(int labelNum) {

		this.objetsMap.remove(labelNum);
	}

	public void addObjets(Objet objet, int labelNum) {

		this.objetsMap.add(objet);

	}

	public void addRessource(Ressource ressource, int labelNum) {

		this.ressourceMap.add(ressource);

	}

	public List<Objet> getObjets() {

		return this.objetsMap;

	}

	public List<Ressource> getRessources() {

		return this.ressourceMap;

	}

}
