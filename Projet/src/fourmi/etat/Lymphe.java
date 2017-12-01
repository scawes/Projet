package fourmi.etat;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Lymphe extends Etat implements Trace{

	Lymphe(Fourmi fourmi) {
		super(fourmi);
		vie = 20;
	}

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		vie--;
		if(vie<0) {
			fourmi.evolution(new Adulte(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
