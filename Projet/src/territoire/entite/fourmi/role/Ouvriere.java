package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.tache.ouvriere.Attaque;
import territoire.entite.fourmi.tache.ouvriere.Chasser;
import territoire.entite.fourmi.tache.ouvriere.RetourFourmiliere;
import territoire.entite.fourmi.tache.ouvriere.TacheOuvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.MortProie;

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
		tache.trace(rapport);
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
	
	public RetourFourmiliere tacheRamenerProie(MortProie proie) {
		RetourFourmiliere retourFourmiliere = new RetourFourmiliere(this,proie);
		tache = retourFourmiliere;
		return retourFourmiliere;
	}

}
