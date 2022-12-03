package Actions;

import Jeu.Jeu;
import Joueur.Joueur;
import Objets.Chevre;
import Objets.Objets;
import Objets.Ressources;

public class ActionTuerChevre extends ActionRessource {

	public ActionTuerChevre(String nom, int identifiant, Ressources ressource) {
		super(nom, identifiant, ressource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		Chevre chevre = (Chevre)Jeu.carte.getRessources().get(Integer.parseInt(args[0]));
		if (j.getInventaire().estPresent(Objets.LANCE_PIERRE)) {
			chevre.tuerChevre();
		} else {
			throw new ActionNonRealisableException();
		}
	}
}
