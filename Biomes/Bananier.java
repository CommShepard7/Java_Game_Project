package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class Bananier extends Biome {

	public Bananier(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources, Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources, Integer> Ressource = new HashMap<Ressources, Integer>();
		int nbBananes = rand.nextInt(3);
		int nbBois = rand.nextInt(2);
		tempsUtilisation("Aie aie la banane", tempsDestruction / coefficient);
		Ressource.put(Ressources.BANANE, nbBananes);
		Ressource.put(Ressources.BOIS, nbBois);
		return Ressource;
	}

}