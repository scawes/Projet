package pheromone;

import fourmiliere.Fourmiliere;

public abstract class Pheromone {
  Fourmiliere fourmiliere ;
  boolean sexe;
  int dureeDAction= 100;

  public void passageFourmie(){
	  dureeDAction+=20;
  }
  
  public int getPuissance(){
	  return dureeDAction;
  }
  
}
