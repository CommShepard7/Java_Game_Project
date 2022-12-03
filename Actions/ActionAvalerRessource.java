package Actions;

import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.NonComestibleException;
import Objets.Ressource;
import Objets.Ressources;

public class ActionAvalerRessource extends ActionRessource {

	public ActionAvalerRessource(String nom, int identifiant, Ressources ressource) {
		super(nom, identifiant, ressource);
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		Ressource r = Ressource.instancierRessource(this.ressource, j.getPosition());
		try {
			j.getInventaire().EnleverRessource(this.ressource, 1);
			System.out.print("[" + j.getNom() + "]");
			System.out.println("Je mange la ressource " + this.ressource);
			r.avaler(j);
		} catch (ElementNonPresentException ene) {
			System.out.println(j.getNom() + " n'a pas de " + this.ressource + " dans son inventaire.");
			throw new ActionNonRealisableException();
		} catch (NonComestibleException nce) {
			System.out.println(this.ressource + " ne se mange pas.");
			throw new ActionNonRealisableException();
		}
	}

}
