package fourmi.role;

import fourmi.Fourmi;
import fourmi.tache.Tache;
import rapports.Rapport;
import rapports.Trace;

public class Ouvriere extends Role implements Trace{
	
	Tache tache;

	public Ouvriere(Fourmi fourmi) {
		super(fourmi);
		tache = Tache.getTache(fourmi);
	}

	@Override
	public	void evenement() {
		// TODO Auto-generated method stub
		tache.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
