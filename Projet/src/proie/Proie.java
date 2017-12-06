package proie;

import proie.etat.Etat;
import proie.etat.Vivant;
import territoire.Territoire;
import territoire.zone.Deplacement;
import territoire.zone.DeplacementProie;
import territoire.zone.Position;

public class Proie {

	Territoire territoire;
	Etat etat;
	DeplacementProie deplacement;
	  

	  double poid;
	  int fraicheur;//a enlever
	  private final double poidMin = 1.5;
	  private final double poidMax = 240;
	  
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
	  
	  public boolean getVivant() {
		  return etat.getVivant();
	  }
	  
	  public Etat getEtat() {
		  return etat;
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
