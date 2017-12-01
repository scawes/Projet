package fourmi.role;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Ouvriere extends Role implements Trace{

	public Ouvriere(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public	void evenement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
