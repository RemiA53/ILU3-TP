package carte;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = new Configuration[19];
	
	// CLASSE INTERNE //
	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
		
		
	}
	// FIN CLASSE INTERNE//
	
	public Carte[] donnerCarte() {
		Carte[] cartes = new Carte[110];
		int placeur = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration carte = typesDeCartes[i];
			int nbExemplaires = carte.getNbExemplaires();
			for (int j = 0; j < nbExemplaires; j++) {
				cartes[placeur] = carte.getCarte();
				placeur++;
			}
		}
		return cartes;
	}
	
	public String affichageJeuCartes() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration config = typesDeCartes[i];
			chaine.append(config.getNbExemplaires());
			chaine.append(" ");
			Carte carte = config.getCarte();
			chaine.append(carte.toString());
			chaine.append("\n");
		}
		return chaine.toString();
	}
	
	public boolean checkCount() {
		int nbExemplaireTot = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration config = typesDeCartes[i];
			nbExemplaireTot += config.nbExemplaires;
		}
		return nbExemplaireTot == 110;
	}
}
