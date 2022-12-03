package Missions;

import Actions.*;
import Objets.Ressources;

public class MissionAvalerPommePourrie extends Mission {

	private boolean estMangée;

	public MissionAvalerPommePourrie() {
		super("Avaler une Pomme Pourrie", 150);
		this.estMangée = false;
	}

	@Override
	public void majMission(Action action) {
		if (action instanceof ActionAvalerRessource
				&& ((ActionAvalerRessource) action).getRessource() == Ressources.POMME_POURRIE) { // A
			// VOIR
			this.estMangée = true;
		}
	}

	@Override
	public boolean estRealisee() {
		return this.estMangée;
	}

}
