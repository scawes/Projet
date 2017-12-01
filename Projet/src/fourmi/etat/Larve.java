package fourmi.etat;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Larve extends Etat implements Trace{

	Larve(Fourmi fourmi) {
		super(fourmi);
		vie = 15;
	}

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		vie--;
		if(vie<0) {
			fourmi.evolution(new Lymphe(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
