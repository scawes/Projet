package proie;

import fourmi.Deplacement;
import territoire.Position;

public class Proie {
  Position position;
  double poid;
  Deplacement deplacement;
  private final double poidMin = 1.5;
  private final double poidMax = 240;
  
  public Proie() {
    poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));

  }
  
  public Deplacement getDeplacement() {
    return this.deplacement;
  }
  
  public void setPosition(Position position) {
    this.position = position;
  }
  
  public Position getPosition() {
    return this.position;
    
  }
  
  public void deces() {
    ProieMorte unCadavre = new ProieMorte(this.poid,this.position);
    
  }
}
