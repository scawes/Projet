package pheromone;

import fourmi.Fourmi;

public class PheromoneMale extends Pheromone {
  
  public PheromoneMale(Fourmi maFourmi) {
    this.sexe = true;
    this.fourmiliere = maFourmi.getFourmiliere() ;
  }
  
  

}
