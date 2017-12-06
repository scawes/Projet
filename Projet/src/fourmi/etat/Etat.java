package fourmi.etat;

import fourmi.Fourmi;
import rapports.Trace;

public abstract class Etat implements Trace {

	Fourmi fourmi;
	
	double appetit;
	int timerNourriture;
	
	
	Etat(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	/*double getPoid() {
	 return this.fourmi.getPoid();
	}
	
	void setPoid(double poid) {
	  this.fourmi.setPoid(poid);
	}*/
	
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
        /*
        /**
         * retourne l'instance de la case sur la qu'elle elle se situe
         * @return Case
         */
	
	/*
        Case getCase() {
          return this.fourmi.getFourmiliere().getTerritoire().getCase(this.fourmi.getDeplacement().getEmplacement());
        }
        
        
        Position getPosition() {
          return this.fourmi.getDeplacement().getEmplacement();
        }
        
        List<Position> getPositionsFourmiliere(){
          return this.fourmi.getFourmiliere().getPosition();
        }

        List<Proie> getProiePresnte(){
          return this.getCase().getProies();
        }*/
	
	public Fourmi getFourmi() {
		return fourmi;
	}
	
	public abstract void evenement();

}
