package proie.etat;


import fourmi.tache.ouvriere.Attaque;
import proie.Proie;
import proie.etat.tache.vivant.Deplacer;
import proie.etat.tache.vivant.EstAttaquer;
import proie.etat.tache.vivant.TacheProieVivant;
import rapports.Rapport;
import rapports.Trace;

public class Vivant extends Etat implements Trace {

	
	TacheProieVivant tache;
	int tempsDehors ; 

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

	@Override
	public void actionFourmi(Attaque fourmi) {
		if (tache.estAttaquer()) {
			((EstAttaquer) tache).fourmiArrive(fourmi);
		} else {
			tache = new EstAttaquer(this,fourmi);
		}
	}

	@Override
	public boolean getVivant() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
