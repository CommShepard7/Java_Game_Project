package Missions;

import Actions.Action;
import Actions.ActionConstruireObjet;
import Actions.ActionLacherRessource;
import Actions.ActionRamasserRessource;
import Objets.Objets;

public class MissionConstruireObjet extends Mission {

	/**
	 * Objet que l'on doit construire pour effectuer la mission
	 */
	protected Objets objet;

	/**
	 * Etat de construction de l'objet
	 */
	private boolean estConstruit;

	public MissionConstruireObjet(Objets objet, int nbPoints) {
		super("Construire un " + objet.toString(), nbPoints);
		this.estConstruit = false;
	}

	@Override
	public void majMission(Action action) {
		if (action instanceof ActionConstruireObjet && ((ActionConstruireObjet) action).getObjet() == this.objet) {
			this.estConstruit = true;
		}
	}

	@Override
	public boolean estRealisee() {
		return this.estConstruit;
	}
}
