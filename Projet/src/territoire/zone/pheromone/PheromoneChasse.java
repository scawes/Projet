package territoire.zone.pheromone;

import territoire.fourmiliere.Fourmiliere;

public class PheromoneChasse extends Pheromone {
  
  public PheromoneChasse(Fourmiliere maFourmiliere) {
    this.sexe = true;
    this.fourmiliere = maFourmiliere ;
  }
  
  

}
