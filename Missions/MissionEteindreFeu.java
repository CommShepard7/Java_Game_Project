package Missions;

import Actions.Action;
import Actions.ActionEteindreFeu;


public class MissionEteindreFeu extends Mission {

	private boolean estéteint;

	public MissionEteindreFeu(String nom, int points) {
		super("Eteindre le feu", 200);
		this.estéteint = false;
	}

	@Override
	public boolean estRealisee() {
		return estéteint;
	}

	@Override
	public void majMission(Action action) {

		if (action instanceof ActionEteindreFeu)  {
			this.estéteint = true;
		}
	}

}
