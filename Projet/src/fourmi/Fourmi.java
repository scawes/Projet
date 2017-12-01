package fourmi;

import fourmi.etat.Etat;
import fourmi.etat.Oeuf;
import fourmiliere.Fourmiliere;
import rapports.Rapport;
import rapports.Trace;

public class Fourmi implements Trace {
	
	Fourmiliere fourmiliere;
	Etat etat;

	public Fourmi(Fourmiliere fourmiliere) {
		etat=new Oeuf(this);
		this.fourmiliere=fourmiliere;
	}
	
	public void setFourmiliere(Fourmiliere fourmiliere) {
		this.fourmiliere=fourmiliere;
	}
	
	public Fourmiliere getFourmiliere() {
		return fourmiliere;
	}

	public void evenement() {
		etat.evenement();
	}
	
	public void evolution(Etat nouvelEtat) {
		etat=nouvelEtat;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		etat.trace(rapport);
	}
	
}
