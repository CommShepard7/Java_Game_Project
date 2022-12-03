package Biomes;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Objets.Ressources;

public class GrosRocher extends Biome{

	public GrosRocher(Point position, int tempsDestruction) {
		super(position, tempsDestruction);
	}

	@Override
	public Map<Ressources,Integer> detruire(int coefficient) {
		Random rand = new Random();
		Map<Ressources,Integer> RessourcesàPoser = new HashMap<Ressources,Integer>();
		int aleatoireCaillou = rand.nextInt(2);
		int aleatoireMinerai = rand.nextInt(4);
		int aleatoireDiamant = rand.nextInt(1);
		//Il y a un temps à attendre pour extraire la roche (le coefficient varie en fonction des outils
		// que le joueur possède )
		tempsUtilisation("Extraction de la roche", tempsDestruction/coefficient);
		RessourcesàPoser.put(Ressources.CAILLOU, aleatoireCaillou);
		RessourcesàPoser.put(Ressources.MINERAI, aleatoireMinerai);
		RessourcesàPoser.put(Ressources.DIAMANT, aleatoireDiamant);
		return RessourcesàPoser;

	}

}
