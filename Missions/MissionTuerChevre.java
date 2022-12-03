package Missions;

import Actions.Action;

public class MissionTuerChevre extends Mission {

	private boolean estTuée;

	public MissionTuerChevre(String nom, int points) {
		super("TuerChevre", 100);
		this.estTuée = false;
	}

	@Override
	public boolean estRealisee() {
		return estTuée;
	}

	@Override
	public void majMission(Action action) {
		//if (action instanceof ActionTuerChevre  {
			this.estTuée = true;
		//}
	}


}
