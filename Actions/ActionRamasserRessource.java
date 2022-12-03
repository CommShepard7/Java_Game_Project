package Actions;

import Jeu.Jeu;
import Joueur.Joueur;
import Objets.InventairePleinException;
import Objets.Ressources;

public class ActionRamasserRessource extends ActionRessource {

	public ActionRamasserRessource(String nom, int identifiant, Ressources ressource) {
		super(nom, identifiant, ressource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		try {
			j.getInventaire().AjouterRessource(this.ressource, 1);
		} catch (InventairePleinException e) {
			throw new ActionNonRealisableException();
		}
		Jeu.carte.retirerRessource(Integer.parseInt(args[0]));
	}

}
