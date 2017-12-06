package proie.etat;


import proie.Proie;
import rapports.Rapport;
import rapports.Trace;
import territoire.zone.Position;

public class MortProie extends Etat implements Trace {

	final int DECOMPOSITION = 100;
	int tempsNourriture ; 

	public MortProie(Proie proie) {
		super(proie);
		tempsNourriture=DECOMPOSITION;
	}
	

	@Override
	public	void evenement() {

		tempsNourriture--;
	}


	@Override
	public void trace(Rapport rapport) {
		//rapport.traceForFourmiliere(this);
		//role.trace(rapport);
	}

	
	public void actionFourmi(Position position) {
		proie.getDeplacement().changerCase(position);
	}

	@Override
	public boolean isVivant() {
		return false;
	}



	@Override
	public void setTache() {
	
	}


	@Override
	public Etat getVivant() {
		return this;
	}

	

}
