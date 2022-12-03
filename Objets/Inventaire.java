package Objets;
import java.util.HashMap;
import java.util.Map;

public class Inventaire {

	private int CapaciteMax;

	/* Objets présents dans l'inventaire */
	Map<Objets,Integer> ObjetsPresents;

	/* Ressources présentes dans l'inventaire */
	Map<Ressources,Integer> RessourcesPresentes;

	/**
	 * Ajouter un objet dans l'inventaire du joueur
	 * @param objet à ajouter
	 * @throws InventairePleinException
	 */
	public void AjouterObjet(Objets objet, int nombre) throws InventairePleinException {
		if (tailleInventaire() > CapaciteMax - nombre) {
			throw new InventairePleinException();
		}
		if (ObjetsPresents.containsKey(objet)) {
			int compteur = ObjetsPresents.get(objet);
			ObjetsPresents.put(objet, compteur + nombre);
		}
		else {
			ObjetsPresents.put(objet, nombre);
		}
	}

	public int tailleInventaire() {
		int somme = 0;
		for (Objets Key : this.ObjetsPresents.keySet()) {
			somme += this.ObjetsPresents.get(Key);
		}
		for (Ressources Key : this.RessourcesPresentes.keySet()) {
			somme += this.RessourcesPresentes.get(Key);
		}
	return somme;
	}

	/**
	 * Enlever un nombre d'objets de l'inventaire du joueur
	 * @param objet à enlever
	 * @param nombre d'objets à enlever
	 * @throws ElementNonPresentException
	 */
	public void EnleverObjet(Objets objet, int nombre) throws ElementNonPresentException {
		if (ObjetsPresents.containsKey(objet) && ObjetsPresents.get(objet) < nombre) {
			throw new ElementNonPresentException("Les objets que l'on souhaite enlever ne sont pas présents");
		}
		else if (!ObjetsPresents.containsKey(objet)) {
			throw new ElementNonPresentException("No such object in inventory");

		}

		else {
		if (ObjetsPresents.get(objet) == nombre) {
			ObjetsPresents.remove(objet);
		}
		else {
			int compteur = ObjetsPresents.get(objet);
			ObjetsPresents.put(objet, compteur - 1);
		}
	}
	}

	/**
	 * Enlever un nombre de ressources de l'inventaire du joueur
	 * @param ressource à enlever
	 * @param nombre de ressources à enlever
	 * @throws ElementNonPresentException
	 */
	public void EnleverRessource(Ressources ressource, int nombre) throws ElementNonPresentException {
		if (RessourcesPresentes.containsKey(ressource) && RessourcesPresentes.get(ressource) < nombre) {
			throw new ElementNonPresentException("Les objets que l'on souhaite enlever ne sont pas présents");
		}
	   else if (!RessourcesPresentes.containsKey(ressource)) {
			throw new ElementNonPresentException("No such ressource in inventory");

		}

		else {
		if (RessourcesPresentes.get(ressource) == nombre) {
			RessourcesPresentes.remove(ressource);
		}
		else {
			int compteur = RessourcesPresentes.get(ressource);
			RessourcesPresentes.put(ressource, compteur - 1);
		}
	}
	}

	/**
	 * Ajouter une ressource dans l'inventaire du joueur
	 * @param ressource à ajouter
	 * @throws InventairePleinException
	 */
	public void AjouterRessource(Ressources ressource, int nombre) throws InventairePleinException {
		if (tailleInventaire() > CapaciteMax - nombre) {
			throw new InventairePleinException();
		}
		if (RessourcesPresentes.containsKey(ressource)) {
			int compteur = RessourcesPresentes.get(ressource);
			RessourcesPresentes.put(ressource, compteur + nombre);
		}
		else {
			RessourcesPresentes.put(ressource, nombre);
		}
	}

	/**
	 * Initialiser un inventaire vide
	 */
	public Inventaire(int capacite) {
		this.ObjetsPresents = new HashMap<Objets,Integer>();
		this.RessourcesPresentes = new HashMap<Ressources,Integer>();
		this.CapaciteMax = capacite;
	}

	/**
	 * Savoir si une ressource est présente dans l'inventaire
	 * @param ressource en question
	 */
	public boolean estPresent(Ressources r) {
		return this.RessourcesPresentes.containsKey(r);
	}

	/**
	 * Savoir si un objet est présent dans l'inventaire
	 * @param objet en question
	 */
	public boolean estPresent(Objets o) {
		return this.ObjetsPresents.containsKey(o);
	}

//	public boolean estPresent(Ressource r) {
//		Set<Ressource> ensembleRessource = RessourcesPresentes.keySet();
//		for (Ressource rPresente : ensembleRessource) {
//			if (rPresente.getNom() == r.getNom()) {
//				return true;
//			}
//		}
//		return false;
//	}


}
