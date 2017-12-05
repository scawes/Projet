package proie;

import fourmi.Deplacement;
import territoire.Position;

public class Proie {
  Position position;
  double poid;
  Deplacement deplacement;
  Boolean enVie;
  int fraicheur;
  private final double poidMin = 1.5;
  private final double poidMax = 240;
  
  public Proie() {
    poid = (poidMin + (double)Math.random()* ((poidMax-poidMin)+1));
    enVie = true;
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
  
  public double getPoid() {
    return this.poid;
  }
  
  public void decrementePoid(double manger) {
    this.poid-= manger;
  }
  
  public void deces() {
   
    this.enVie= false;
  }
  public void decrementeFraicheur() {
    fraicheur--;
  }
}
