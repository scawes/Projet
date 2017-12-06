package pheromone;

import fourmiliere.Fourmiliere;

public abstract class Pheromone {
  Fourmiliere fourmiliere ;
  boolean sexe;
  int dureeDAction= 100;
  final int RAFFRAICHISSEMENT = 50;
  final int MAX = 150;

  public void passageFourmie(){
	  if(dureeDAction+RAFFRAICHISSEMENT<MAX) {
		  dureeDAction+=RAFFRAICHISSEMENT;
	  }
	  
  }
  
  public int getPuissance(){
	  return dureeDAction;
  }
  
  
  public void decrementPheromone() {
	  if(dureeDAction>0) {
		  this.dureeDAction --;
	  }
  }
  
  public boolean isFourmiliere(Fourmiliere fourmiliere) {
	  return this.fourmiliere.equals(fourmiliere);
  }
  
  public boolean isSexue() {
	  return sexe;
  }
  
}
