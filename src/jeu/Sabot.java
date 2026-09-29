package jeu;


import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;


import carte.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes;
	private int nombreOperation = 0;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes >= cartes.length) {
			throw new IllegalStateException("Le sabot est plein");
		}
		cartes[nbCartes] = carte;
		nbCartes++;
		nombreOperation++;
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	// Classe interne itérateur
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationReference = nombreOperation;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		@Override
		public Carte next() {
			if(nombreOperation != nombreOperationReference) {
				throw new ConcurrentModificationException();
			}
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}
		
		@Override
		public void remove() {
			if(nombreOperation!=nombreOperationReference) {
				throw new ConcurrentModificationException();
			}
			
			if (!nextEffectue || nbCartes < 1) {
				throw new IllegalStateException();
			}
			
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
			
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
		}
	}
}
