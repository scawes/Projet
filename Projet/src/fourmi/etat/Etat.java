package fourmi.etat;

import fourmi.Fourmi;
import rapports.Trace;

public abstract class Etat implements Trace {

	Fourmi fourmi;
	int vie;
	
	Etat(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	public abstract void evenement();

}
