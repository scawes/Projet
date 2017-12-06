package territoire.entite.proie.etat;


import rapports.Rapport;
import rapports.Trace;
import territoire.entite.proie.Proie;
import territoire.zone.Position;

public class MortProie extends Etat implements Trace {

	final int DECOMPOSITION = 100;
	int tempsNourriture ; 
	boolean estPrise;
	
	
	public MortProie(Proie proie) {
		super(proie);
		tempsNourriture=DECOMPOSITION;
		estPrise=false;
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

	public boolean estPrise(){
		if(estPrise){
			return true;
		} else {
			estPrise=true;
			return false;
		}
	}
	
	public void depose(){
		estPrise=false;
			
	}

	@Override
	public void setTache() {
	
	}


	@Override
	public Etat getVivant() {
		return this;
	}

	

}
