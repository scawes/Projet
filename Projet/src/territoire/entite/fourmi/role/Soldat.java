package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;

public class Soldat extends Role implements Trace {

	public Soldat(Etat etat) {
		super(etat);
	}

	@Override
	public void evenement() {
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
