package territoire.entite.proie;

import territoire.Territoire;
import territoire.entite.proie.etat.Etat;
import territoire.entite.proie.etat.MortProie;
import territoire.entite.proie.etat.Vivant;
import territoire.zone.Position;
import territoire.zone.deplacement.Deplacement;
import territoire.zone.deplacement.DeplacementProie;

public class Proie {

	Territoire territoire;
	Etat etat;
	DeplacementProie deplacement;
	  

	  double poid;
	  int fraicheur;//a enlever
	  private final double poidMin = 1.5;
	  private final double poidMax = 5;
	  
	  public Proie(Territoire territoire,Position position) {
		  this.territoire = territoire;
		  deplacement = new DeplacementProie(this, position);
		  etat = new Vivant(this);
		  poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));
	
	  }
	  
	  public Deplacement getDeplacement() {
	    return this.deplacement;
	  }
	  
	  public Territoire getTerritoire() {
		    return this.territoire;
	  }
	  
	  public boolean isVivant() {
		  return etat.isVivant();
	  }
	  
	  public Etat getVivant() {
		  return etat.getVivant();
	  }
	  
	  public Etat getEtat() {
		  return etat;
	  }
	  
	  public void mortProie() {
		  etat = new MortProie(this);
	  }
	   
	  public double getPoid() {
	    return this.poid;
	  }
	  
	  public void decrementePoid(double manger) {
	    this.poid-= manger;
	  }
	  
	  public void evenement() {
		  etat.evenement();
	  }
	  
	  /*public void deces() {

	    this.enVie= false;
	  }*/
	  /*public void decrementeFraicheur() {
	    fraicheur--;
  }*/
}
