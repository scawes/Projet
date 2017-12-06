package proie.etat.tache;

import proie.etat.Etat;

public abstract class Tache {
	
	Etat etat;

	public Tache(Etat etat) {
		this.etat=etat;
	}

	public static Tache getTache(Etat etat) {
		return new Deplacer(etat);
	}
	
	public abstract void evenement();
}
