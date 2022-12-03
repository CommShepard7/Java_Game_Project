package Actions;

import Jeu.Jeu;
import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.Feu;
import Objets.Objets;

public class ActionAllumerFeu extends ActionObjet {

	public ActionAllumerFeu(String nom, int identifiant, Objets objet) {
		super(nom, identifiant, objet);
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		Feu feu = (Feu)Jeu.carte.getObjets().get(Integer.parseInt(args[0]));
		if (Feu.estAllume(feu)) {
			throw new ActionNonRealisableException();
		}
		try {
			j.getInventaire().EnleverObjet(Objets.ALLUMETTE, 1);
			feu.allumer();
		} catch (ElementNonPresentException e) {
			throw new ActionNonRealisableException();
		}
	}
}
