package Actions;

import java.util.List;

import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.InventairePleinException;
import Objets.Objets;
import Objets.Ressources;

public class ActionConstruireObjet extends ActionObjet {

	protected List<Ressources> ressourcesNecessaires;

	public ActionConstruireObjet(String nom, int identifiant, Objets objet, List<Ressources> ressourcesNecessaires) {
		super(nom, identifiant, objet);
		this.ressourcesNecessaires = ressourcesNecessaires;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		for (Ressources r : ressourcesNecessaires) {
			if (!j.getInventaire().estPresent(r)) {
				throw new ActionNonRealisableException();
			}
		}
		
		// On retire les ressources necessaires
		for (Ressources r : ressourcesNecessaires) {
			try {
				j.getInventaire().EnleverRessource(r, 1);
			} catch (ElementNonPresentException e) {
				// c'est pas possible de rentrer dans le catch car on a verifier avant
			}
		}

		// Toutes les ressources sont presentes dans l'inventaire du joueur, on peut
				// donc creer l'objet
		try {
			j.getInventaire().AjouterObjet(this.objet, 1);
		} catch (InventairePleinException e1) {
			throw new ActionNonRealisableException();
		}
	}

}
