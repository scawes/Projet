package fourmi.role;

import fourmi.etat.Etat;
import rapports.Rapport;
import rapports.Trace;

public class Soldat extends Role implements Trace {

	public Soldat(Etat etat) {
		super(etat);
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
