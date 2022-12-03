package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class Cocotier extends Biome {

	public Cocotier(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources, Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources, Integer> Ressource = new HashMap<Ressources, Integer>();
		int nbNoixDeCoco = rand.nextInt(3);
		int nbBois = rand.nextInt(2);
		tempsUtilisation("Attention aux Noix de Coco", tempsDestruction / coefficient);
		Ressource.put(Ressources.NOIX_DE_COCO, nbNoixDeCoco);
		Ressource.put(Ressources.BOIS, nbBois);
		return Ressource;
	}

}
