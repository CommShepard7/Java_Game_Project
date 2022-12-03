package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class Flaque extends Biome{

	public Flaque(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources,Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources,Integer> RessourcesàPoser = new HashMap<Ressources,Integer>();
		int aleatoireEau = rand.nextInt(4);
		//Il y a un temps à attendre pour extraire l'eau de la flaque (le coefficient varie en fonction des outils
		// que le joueur possède )
		tempsUtilisation("Extraction de l'eau", tempsDestruction/coefficient);
		RessourcesàPoser.put(Ressources.EAU, aleatoireEau);
		return RessourcesàPoser;

		}

}
