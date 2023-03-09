package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;

	public Romain(String nom, int force) {
		this.nom = nom;
		equipements = new Equipement[2];
		assert(force > 0);
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert(force > 0);
		int forceAvantCoup = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(force < forceAvantCoup);
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipement == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
			} else {
				ajoutEquipement(equipement);
			}
			break;
		case 0:
			ajoutEquipement(equipement);
			break;
		default:
			break;
		}
	}

	private void ajoutEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + "s'équipe avec un " + equipement.toString() + ".");
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}