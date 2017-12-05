package proie;

import territoire.Position;

public class ProieMorte {
  double poid;
  Position position;
  
  public ProieMorte(double poid, Position position) {
    this.poid = poid;
    this.position = position;
  }
  
  public void DecrementePoid(double manger) {
    this.poid-=manger;
  }

}
