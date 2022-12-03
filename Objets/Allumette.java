package Objets;

import java.awt.Point;

import Joueur.Joueur;

public class Allumette extends Objet {

	public Allumette(Point position) {
		super(Objets.ALLUMETTE, position, 0);
	}

	@Override
	public void utiliser(Joueur j) throws ObjetNonUtilisableException {
		this.dansInventaire(j.getInventaire());
		// if feu est a proximite alors :
			//il faut recuperer le feu en question et l'allumé
			this.tempsUtilisation(null);
		//sinon
			throw new ObjetNonUtilisableException();
		
	}

}
