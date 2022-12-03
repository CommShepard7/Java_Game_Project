package Actions;

import Jeu.Jeu;
import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.Ressource;
import Objets.Ressources;

public class ActionLacherRessource extends ActionRessource {

	public ActionLacherRessource(String nom, int identifiant, Ressources ressource) {
		super(nom, identifiant, ressource);

	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		try {
			j.getInventaire().EnleverRessource(ressource, 1);
			Jeu.carte.addRessource(Ressource.instancierRessource(ressource, j.getPosition()),
					1);
		} catch (ElementNonPresentException ex) {
			System.out.println("La ressource n'est pas dans l'inventaire");
			throw new ActionNonRealisableException();
		}

	}

}
