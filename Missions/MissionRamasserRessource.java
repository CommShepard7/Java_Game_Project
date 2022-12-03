package Missions;

import Actions.Action;
import Actions.ActionLacherRessource;
import Actions.ActionRamasserRessource;
import Objets.Ressources;

public class MissionRamasserRessource extends Mission {

	/**
	 * Ressource que l'on doit ramasser pour effectuer la mission
	 */
	protected Ressources ressource;

	/**
	 * Nombre de ressources ramassées
	 */
	private int nbDeRessources;

	/**
	 * Nombre total de ressources à ramasser
	 */
	private int nbObjectifDeRessources;

	public MissionRamasserRessource(Ressources ressource, int nbObjectifDeRessources, int nbPoints) {
		super("Ramasser " + nbObjectifDeRessources + " " + ressource.toString(), nbPoints);
		this.nbDeRessources = 0;
		this.ressource = ressource;
		this.nbObjectifDeRessources = nbObjectifDeRessources;
	}

	@Override
	public void majMission(Action action) {
		if (action instanceof ActionRamasserRessource
				&& ((ActionRamasserRessource) action).getRessource() == this.ressource) {
			this.nbDeRessources++;
		} else if (action instanceof ActionLacherRessource
				&& ((ActionLacherRessource) action).getRessource() == this.ressource) {
			this.nbDeRessources--;
		}
	}

	@Override
	public boolean estRealisee() {
		return (this.nbDeRessources == this.nbObjectifDeRessources);
	}

}
