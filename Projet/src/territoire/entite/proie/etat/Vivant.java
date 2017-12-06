package territoire.entite.proie.etat;


import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.tache.ouvriere.Attaque;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.tache.vivant.Deplacer;
import territoire.entite.proie.etat.tache.vivant.EstAttaquer;
import territoire.entite.proie.etat.tache.vivant.TacheProieVivant;

public class Vivant extends Etat implements Trace {

	
	TacheProieVivant tache;

	public Vivant(Proie proie) {
		super(proie);

		tache=getTache();
	}
	
	@Override
	public void setTache() {
		tache = getTache();
	}
	
	public TacheProieVivant getTache() {
		return new Deplacer(this);
	}
	

	@Override
	public	void evenement() {

		tache.evenement();
	}


	@Override
	public void trace(Rapport rapport) {
		//rapport.traceForFourmiliere(this);
		//role.trace(rapport);
	}

	public void actionFourmi(Attaque fourmi) {
		if (tache.estAttaquer()) {
			((EstAttaquer) tache).fourmiArrive(fourmi);
		} else {
			tache = new EstAttaquer(this,fourmi);
		}
	}

	@Override
	public boolean isVivant() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Etat getVivant() {
		// TODO Auto-generated method stub
		return this;
	}

	

}
