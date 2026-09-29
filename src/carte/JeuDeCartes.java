package carte;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1)
	};
	
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
		int taille = 0;
		for (Configuration configuration : typesDeCartes) {
	            taille += configuration.getNbExemplaires();
	    }
		
		Carte[] cartes = new Carte[taille];
		int index = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration carte = typesDeCartes[i];
			int nbExemplaires = carte.getNbExemplaires();
			for (int j = 0; j < nbExemplaires; j++) {
				cartes[index] = carte.getCarte();
				index++;
			}
		}
		return cartes;
	}
	
	public String affichageJeuCartes() {
		StringBuilder chaine = new StringBuilder();
		for (Configuration configuration : typesDeCartes) {
			chaine.append(configuration.getNbExemplaires());
			chaine.append(" ");
			Carte carte = configuration.getCarte();
			chaine.append(carte.toString());
			chaine.append("\n");
		}
		return chaine.toString();
	}
	
	public boolean checkCount() {
		int nbExemplaireTot = 0;
		for (Configuration configuration : typesDeCartes) {
			nbExemplaireTot += configuration.nbExemplaires;
		}
		return nbExemplaireTot == 106;
	}
}
