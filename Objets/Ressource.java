package Objets;
import java.awt.Point;
import Joueur.Joueur;

public abstract class Ressource {

	private Ressources nom;
	private Point position;

	public Ressource(Ressources r, Point position) {
		this.nom = r;
		this.position = position;
	}

	public Ressources getNom() {
		return this.nom;
	}

	public Point getPosition() {
		return this.position;
	}
	
	public abstract void avaler(Joueur j) throws NonComestibleException;
	
	public static final Ressource instancierRessource(Ressources r, Point position) {
		switch (r) {
		case EAU:
			return new Eau(position);
		case EAU_SALEE:
			return new EauSalee(position);
		case POMME:
			return new Pomme(position);
		case BANANE:
			return new Banane(position);
		case CHEVRE_CUITE:
			return new ChevreCuite(position);
		case NOIX_DE_COCO:
			return new NoixDeCoco(position);
		case CHEVRE:
			return new Chevre(position);
		case POMME_POURRIE:
			return new PommePourrie(position);
		case DIAMANT:
			return new Diamant(position);
		case PAILLE:
			return new Paille(position);
		case BOIS:
			return new Bois(position);
		case CAILLOU:
			return new Caillou(position);
		case MINERAI:
			return new Minerai(position);
		case BOUTEILLE:
			return new Bouteille(position);
		default:
			return null;
		}
	}
	
	public static final boolean isRessource (String chaine) {
		for (Ressources ressource : Ressources.values()) {
			if (ressource.name().equals(chaine)) {
				return true;
			}
		}
		return false;
	}
	
	

}