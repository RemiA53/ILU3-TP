package jeu;

import carte.*;

public class Sabot implements Iterable<T extends Type> {
	private int nbCartes;
	private Carte[] cartes;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = 110;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public Carte[] getCartes() {
		return cartes;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes != 110) {
			cartes[nbCartes] = carte;
			nbCartes++;
		} else {
			throw new IllegalStateException();
		}
		
	}
}
