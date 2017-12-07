package territoire.entite.fourmi.tache.ouvriere;

import rapports.Trace;
import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.zone.deplacement.DeplacementFourmi;

public abstract class TacheOuvriere implements Trace {
	
	Ouvriere role;

	public TacheOuvriere(Ouvriere role) {
		this.role=role;
	}
	
	Territoire getTerritoire() {
		return getFourmi().getFourmiliere().getTerritoire();
	}
	
	Fourmi getFourmi() {
		return role.getEtat().getFourmi();
	}

	DeplacementFourmi getDeplacement() {
		return getFourmi().getDeplacement();
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	
	public abstract void evenement();
}
