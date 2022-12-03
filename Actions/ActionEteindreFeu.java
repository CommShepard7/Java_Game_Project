package Actions;

import Jeu.Jeu;
import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.Feu;
import Objets.Objets;
import Objets.Ressources;

public class ActionEteindreFeu extends ActionObjet {

	public ActionEteindreFeu(String nom, int identifiant, Objets objet) {
		super(nom, identifiant, objet);
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		Feu feu = (Feu)Jeu.carte.getObjets().get(Integer.parseInt(args[0]));
		if (!Feu.estAllume(feu)) {
			throw new ActionNonRealisableException();
		}
		try {
			j.getInventaire().EnleverRessource(Ressources.EAU, 1);
			feu.eteindre();
		} catch (ElementNonPresentException e) {
			throw new ActionNonRealisableException();
		}
	}
}
