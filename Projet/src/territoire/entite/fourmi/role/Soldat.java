package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;

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
