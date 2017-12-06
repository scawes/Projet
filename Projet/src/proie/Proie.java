package proie;

import territoire.Territoire;
import territoire.zone.Deplacement;
import territoire.zone.DeplacementProie;
import territoire.zone.Position;

public class Proie {

	Territoire territoire;
	  double poid;
	  DeplacementProie deplacement;
	  
	  Boolean enVie;//a enlever
  int fraicheur;//a enlever
	  private final double poidMin = 1.5;
	  private final double poidMax = 240;
	  
	  public Proie(Territoire territoire,Position position) {
		  this.territoire = territoire;
		  deplacement = new DeplacementProie(this, position);
	    poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));
	    enVie = true;
	  }
	  
	  public Deplacement getDeplacement() {
	    return this.deplacement;
	  }
	  
	  public Territoire getTerritoire() {
		    return this.territoire;
		  }
	   
	  public double getPoid() {
	    return this.poid;
	  }
	  
	  public void decrementePoid(double manger) {
	    this.poid-= manger;
	  }
	  
	  /*public void deces() {

	    this.enVie= false;
	  }*/
	  /*public void decrementeFraicheur() {
	    fraicheur--;
  }*/
}
