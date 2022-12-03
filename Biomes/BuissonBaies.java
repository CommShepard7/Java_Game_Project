package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class BuissonBaies extends Biome {

	public BuissonBaies(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources,Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources,Integer> RessourcesàPoser = new HashMap<Ressources,Integer>();
		int aleatoireBaie = rand.nextInt(4);
		tempsUtilisation("Déracinage en cours...", tempsDestruction/coefficient);
		RessourcesàPoser.put(Ressources.BAIE, aleatoireBaie);
		return RessourcesàPoser;
	}

}
