package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class Pommier extends Biome {

	public Pommier(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources, Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources, Integer> Ressource = new HashMap<Ressources, Integer>();
		int nbPommes = rand.nextInt(3);
		int nbBois = rand.nextInt(2);
		tempsUtilisation("Pom pom pom la pomme", tempsDestruction / coefficient);
		Ressource.put(Ressources.POMME, nbPommes);
		Ressource.put(Ressources.BOIS, nbBois);
		return Ressource;
	}

}