package proie.etat;


import proie.Proie;
import proie.etat.tache.Deplacer;
import proie.etat.tache.Tache;
import rapports.Rapport;
import rapports.Trace;

public class Vivant extends Etat implements Trace {

	
	Tache tache;
	int tempsDehors ; 

	public Vivant(Proie proie) {
		super(proie);

		tache=getTache(this);//ajouter cette methode danss adulte

	}
	
	public Tache getTache(Etat etat) {
		//if(etat.getFourmi().getFourmiliere().getListeFourmi().size()<1)
		return new Deplacer(etat);
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

}
