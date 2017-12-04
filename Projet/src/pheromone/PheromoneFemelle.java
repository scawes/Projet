package pheromone;

import fourmi.Fourmi;

public class PheromoneFemelle extends Pheromone{

  public PheromoneFemelle(Fourmi maFourmi) {
    this.sexe = true;
    this.fourmiliere = maFourmi.getFourmiliere() ;
  }
  
}
