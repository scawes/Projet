package territoire.entite.proie.etat.tache.vivant;

import rapports.Trace;
import territoire.entite.proie.etat.Vivant;

public abstract class TacheProieVivant implements Trace{
	
	Vivant etat;

	public TacheProieVivant(Vivant etat) {
		this.etat=etat;
	}

	public static TacheProieVivant getTache(Vivant etat) {
		return new Deplacer(etat);
	}
	
	public abstract void evenement();
	
	public abstract boolean estAttaquer();
}
