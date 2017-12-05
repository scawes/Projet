package fourmi.etat;

import fourmi.Fourmi;
import rapports.Trace;

public abstract class Etat implements Trace {

	Fourmi fourmi;
	int vie;
	double appetit;
	int timerNourriture;
	
	Etat(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	public Fourmi getFourmi() {
		return fourmi;
	}
	
	public abstract void evenement();

}
