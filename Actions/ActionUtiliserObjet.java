package Actions;

import Joueur.Joueur;
import Objets.Objet;
import Objets.ObjetNonUtilisableException;
import Objets.Objets;

public class ActionUtiliserObjet extends ActionObjet {

	public ActionUtiliserObjet(String nom, int identifiant, Objets objet) {
		super(nom, identifiant, objet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		Objet o = Objet.instancierObjet(this.objet, j.getPosition());
		try {
			o.utiliser(j);
		} catch (ObjetNonUtilisableException e) {
			System.out.println("L'objet n'est pas utilisable");
			throw new ActionNonRealisableException();
		}

	}

}
