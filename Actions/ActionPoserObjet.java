package Actions;

import Joueur.Joueur;
import Objets.ElementNonPresentException;
import Objets.Inventaire;
import Objets.Objet;
import Objets.ObjetNonUtilisableException;
import Objets.Objets;
import Objets.Ressource;
import Objets.Ressources;
import SignauxVitaux.Signes;

public class ActionPoserObjet extends ActionObjet {

	public ActionPoserObjet(String nom, int identifiant, Objets objet) {
		super(nom, identifiant, objet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realiser(Joueur j, String[] args) throws ActionNonRealisableException {
		
//		Inventaire inventaire = j.getInventaire();
//		if (!inventaire.estPresent(this.objet)) {
//			throw new ActionNonRealisableException();
//		}
//		switch(this.objet) {
//		case RECUPERATEUR_EAU :
//			try {
//				inventaire.EnleverRessource(Ressources.EAU_SALEE, 1);
//				inventaire.AjouterRessource(Ressources.EAU);
//			} catch (ElementNonPresentException e) {
//				throw new ActionNonRealisableException();
//			}
//			break;
//		case FEU :
//			j.getSignauxVitaux().get(Signes.FATIGUE.ordinal()).majJauge(10);
//			break;
//		default:
//			System.out.println("Pas encore de code");
//			break;
//		}

	}

}
