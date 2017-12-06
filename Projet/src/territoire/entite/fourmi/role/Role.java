package territoire.entite.fourmi.role;

import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.fourmiliere.Fourmiliere;

public abstract class Role implements Trace{

	Etat etat;
	
	public Role(Etat etat) {
		this.etat=etat;
	}

	public Etat getEtat() {
		return etat;
	}
	
	double getDureeDeVie() {
	  return this.etat.getFourmi().getDureeDeVie() ;
	}
	
	void setDureeDeVie(double duree) {
	  this.etat.getFourmi().setDureeDeVie(duree);
	}

        double getPoid() {
          return this.etat.getFourmi().getPoid() ;
        }
        
        void setPoid(double poid) {
          this.etat.getFourmi().setPoid(poid);
        }	
        
        Fourmiliere getFourmiliere() {
          return etat.getFourmi().getFourmiliere();
        }
	
	public abstract void evenement();

}