package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.*;
import carte.*;

public class Jeu {
	private Sabot sabot;
	
	public Jeu(Carte[] cartes) {
		List<Carte> listCartes = new ArrayList<>();
		Collections.addAll(listCartes, cartes);
		listCartes = GestionCartes.melanger(listCartes);
		this.sabot = new Sabot(listCartes.toArray(cartes));
	}
}
