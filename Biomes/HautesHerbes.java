package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class HautesHerbes extends Biome {

	public HautesHerbes(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources,Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources,Integer> RessourcesàPoser = new HashMap<Ressources,Integer>();
		int aleatoirePaille = rand.nextInt(3);
		tempsUtilisation("Desherbage en cours...", tempsDestruction/coefficient);
		RessourcesàPoser.put(Ressources.PAILLE, aleatoirePaille);
		return RessourcesàPoser;

	}
}
