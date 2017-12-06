package territoire.entite.fourmi;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Position;
import territoire.zone.deplacement.DeplacementFourmi;

public class Fourmi implements Trace {
	
	Fourmiliere fourmiliere;
	Etat etat;
	Position position;
	DeplacementFourmi deplacement;
	private double dureeDevie;
	private double poid;
	private int appetit;
	
	private final int APPETIT_DEFAUT = 200;
	private final double POID_MIN = 1.5;
	private final double POID_MAX = 2;
	                        
	private final double VIE_MIN = 1.5;
	private final double VIE_MAX = 2.5;
	        

	        

	public Fourmi(Fourmiliere fourmiliere,Position position) {
		this.etat=new Oeuf(this);
		setFourmiliere(fourmiliere);
		this.deplacement = new DeplacementFourmi(this,position);
		this.appetit=APPETIT_DEFAUT;
        this.poid = (POID_MIN + (double)Math.random()* ((POID_MAX-POID_MIN)+1));
        this.dureeDevie = (VIE_MIN + (double)Math.random()* ((VIE_MAX-VIE_MIN)+1));
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
