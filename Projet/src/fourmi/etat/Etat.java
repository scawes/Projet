package fourmi.etat;

import fourmi.Fourmi;
import rapports.Trace;

public abstract class Etat implements Trace {

	Fourmi fourmi;
	
	double appetit;
	int timerNourriture;
	double poid;
	
	Etat(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	double getDureeDeVie() {
          return this.fourmi.getDureeDeVie();
        }
        
        void setDureeDeVie(double duree) {
          this.fourmi.setDureeDeVie(duree);
        }
        
        void decrementDureeDeVie() {
          double tampon=this.getDureeDeVie()-1;
          this.fourmi.setDureeDeVie(tampon);
        }
	
	public Fourmi getFourmi() {
		return fourmi;
	}
	
	public abstract void evenement();

}
