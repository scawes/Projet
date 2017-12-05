package fourmi;

import fourmi.etat.Etat;
import fourmi.etat.Oeuf;
import fourmiliere.Fourmiliere;
import rapports.Rapport;
import rapports.Trace;
import territoire.Position;

public class Fourmi implements Trace {
	
	Fourmiliere fourmiliere;
	Etat etat;
	Position position;
	Deplacement deplacement;
	private double dureeDevie;
	private double poid;
	private static double poidMin = 1.5;
	private static double poidMax = 2;
	        
	private static double dureeDeVieMin = 1.5;
	private static double dureeDeVieMax = 2.5;
	        

	public Fourmi(Fourmiliere fourmiliere,Position position) {
		etat=new Oeuf(this);
		setPosition(position);
		this.fourmiliere=fourmiliere;
		deplacement = new Deplacement(this);
		this.poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));
		this.dureeDevie = (dureeDeVieMin + (double)Math.random()* ((dureeDeVieMax-dureeDeVieMin)+1));
	}
	
	public double getPoid() {
	  return this.poid;
	}
	
	public void DecrementeDureeDeVie() {
	  dureeDevie --;
	}
	
	
	
	public Deplacement getDeplacement() {
		return deplacement;
	}
	
	public void setPosition(Position position){
		this.position=position;
	}
	
	public void setFourmiliere(Fourmiliere fourmiliere) {
		this.fourmiliere=fourmiliere;
	}
	
	public Fourmiliere getFourmiliere() {
		return fourmiliere;
	}
	
	public Position getPosition() {
		return position;
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
