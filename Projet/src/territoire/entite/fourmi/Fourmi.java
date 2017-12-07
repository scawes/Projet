package territoire.entite.fourmi;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Position;
import territoire.zone.deplacement.DeplacementFourmi;

public class Fourmi implements Trace {
	
	private Fourmiliere fourmiliere;
	private Etat etat;
	private DeplacementFourmi deplacement;
	private Appetit appetit;
	
	
	public Fourmi(Fourmiliere fourmiliere,Position position) {
		this.etat=new Oeuf(this);
		setFourmiliere(fourmiliere);
		this.deplacement = new DeplacementFourmi(this,position);
		this.appetit=new Appetit();
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
	
	public void setAppetit(double appetit){
		this.appetit = new Appetit(appetit);
	}
	
	public void appetit(){
		if(this.appetit.decrementer()){
			//A COMPLETER : mort fourmi
			//System.out.println("MORT");
		};
	}
	
	public Appetit getAppetit(){
		return appetit;
	}

	public void evenement() {
		appetit();
		etat.evenement();
	}
	
	public void evolution(Etat nouvelEtat) {
		etat=nouvelEtat;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		etat.trace(rapport);
		appetit.trace(rapport);
	}
	
}
