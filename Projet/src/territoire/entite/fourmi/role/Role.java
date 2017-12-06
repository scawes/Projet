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
        
    Fourmiliere getFourmiliere() {
      return etat.getFourmi().getFourmiliere();
    }
	
	public abstract void evenement();

}
