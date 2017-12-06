package territoire.entite.fourmi;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.DureeVie;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Position;
import territoire.zone.deplacement.DeplacementFourmi;

public class Fourmi implements Trace {
	
	private Fourmiliere fourmiliere;
	private Etat etat;
	private Position position;
	private DeplacementFourmi deplacement;
	private Appetit appetit;
	
	
	
	private final int APPETIT_DEFAUT = 200;
	        

	        

	public Fourmi(Fourmiliere fourmiliere,Position position) {
		this.etat=new Oeuf(this);
		setFourmiliere(fourmiliere);
		this.deplacement = new DeplacementFourmi(this,position);
		this.appetit=new Appetit(APPETIT_DEFAUT);
        //this.poid = (POID_MIN + (double)Math.random()* ((POID_MAX-POID_MIN)+1));
	}
	
	
	public DeplacementFourmi getDeplacement() {
		return deplacement;
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
