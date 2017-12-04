package fourmi.role;

import fourmi.Fourmi;
import fourmi.etat.Etat;
import rapports.Trace;

public abstract class Role implements Trace{

	Etat etat;
	
	public Role(Etat etat) {
		this.etat=etat;
	}
	
	public static Role getRole(Etat etat) {
		if(etat.getFourmi().getFourmiliere()==null)
		return new Reine(etat);
		else return new Ouvriere(etat);
	}

	public Etat getEtat() {
		return etat;
	}
	
	public abstract void evenement();

}
