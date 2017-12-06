package fourmi;

import fourmi.etat.Etat;
import fourmi.etat.Oeuf;
import fourmiliere.Fourmiliere;
import rapports.Rapport;
import rapports.Trace;
import territoire.zone.DeplacementFourmi;
import territoire.zone.Position;

public class Fourmi implements Trace {
	
	Fourmiliere fourmiliere;
	Etat etat;
	Position position;
	DeplacementFourmi deplacement;
	private double dureeDevie;
	private double poid;
	private static double poidMin = 1.5;
	private static double poidMax = 2;
	                        
	private static double dureeDeVieMin = 1.5;
	private static double dureeDeVieMax = 2.5;
	        

	        

	public Fourmi(Fourmiliere fourmiliere,Position position) {
		etat=new Oeuf(this);
		setFourmiliere(fourmiliere);
		deplacement = new DeplacementFourmi(this,position);
	        this.poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));
	        this.dureeDevie = (dureeDeVieMin + (double)Math.random()* ((dureeDeVieMax-dureeDeVieMin)+1));
	}
	
	public void setPoid(double poid) {
	  this.poid=poid;
	}
	
	public double getPoid() {
	  return this.poid;
	}
	public double getDureeDeVie() {
	  return this.dureeDevie;
	}
	
	public void setDureeDeVie(double duree) {
	  this.dureeDevie=duree;
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
