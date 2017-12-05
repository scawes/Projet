package pheromone;

import fourmiliere.Fourmiliere;

public abstract class Pheromone {
  Fourmiliere fourmiliere ;
  boolean sexe;
  int dureeDAction= 100;
  final int raffraichissementPheromone = 20;

  public void passageFourmie(){
	  dureeDAction+=raffraichissementPheromone;
  }
  
  public int getPuissance(){
	  return dureeDAction;
  }
  
  
  public void decrementPheromone() {
	  this.dureeDAction -= this.raffraichissementPheromone;
  }
}
