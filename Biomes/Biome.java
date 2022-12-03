package Biomes;

import java.awt.Point;
import java.util.Map;

import Objets.Ressources;

public abstract class Biome {

	@SuppressWarnings("unused")
	protected Point position;

	@SuppressWarnings("unused")
	protected int tempsDestruction;

	public Biome(Point position, int tempsDestruction) {
		this.position = position;
		this.tempsDestruction = tempsDestruction;
	}

	protected void tempsUtilisation(String message, int coefficient) {
		try {
			System.out.println(message);
			Thread.sleep(tempsDestruction/coefficient);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public abstract Map<Ressources,Integer> detruire(int coefficient);
}
