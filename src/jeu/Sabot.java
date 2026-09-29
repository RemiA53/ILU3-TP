package jeu;

import java.util.Iterator;

import carte.*;

public class Sabot<Carte> implements Iterable<T> {
	private int nbCartes;
	private Carte[] cartes;
	
	@Override
	public Iterator<T> iterator() {
		return new Iterateur();
	}
	
	// Classe interne itérateur
	private class Iterateur implements Iterator<T> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return 110==indiceIterateur;
		}
		
		public Carte next() {
			if(hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			}
		}
	}
	
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
