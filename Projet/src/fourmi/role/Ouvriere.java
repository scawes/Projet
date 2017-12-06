package fourmi.role;

import fourmi.etat.Etat;
import fourmi.tache.ouvriere.Attaque;
import fourmi.tache.ouvriere.Chasser;
import fourmi.tache.ouvriere.TacheOuvriere;
import proie.Proie;
import rapports.Rapport;
import rapports.Trace;

public class Ouvriere extends Role implements Trace{
	
	TacheOuvriere tache;

	public Ouvriere(Etat etat) {
		super(etat);
		tache = getTache();
	}

	@Override
	public	void evenement() {
		// TODO Auto-generated method stub
		tache.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
	
	public TacheOuvriere getTache() {
		tache = new Chasser(this);
		return tache;
	}
	
	public Attaque tacheAttaque(Proie proie) {
		Attaque attaque = new Attaque(this,proie);
		tache = attaque;
		return attaque;
	}

}
