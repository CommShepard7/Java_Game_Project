package Missions;

import Actions.Action;
import Actions.ActionUtiliserObjet;
import Objets.Objets;

public class MissionUtiliserFeu extends Mission {

	private boolean estUtilisée;

	public MissionUtiliserFeu() {
		super("Utiliser un feu de camp", 100);
		this.estUtilisée = false;
	}

	@Override
	public void majMission(Action action) {
		if (action instanceof ActionUtiliserObjet && ((ActionUtiliserObjet) action).getObjet() == Objets.FEU) {
			this.estUtilisée = true;
		}
	}

	@Override
	public boolean estRealisee() {
		return this.estUtilisée;
	}

}
