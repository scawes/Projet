package territoire.entite.fourmi.tache.ouvriere;

import rapports.Trace;
import territoire.entite.fourmi.role.Ouvriere;

public abstract class TacheOuvriere implements Trace {
	
	Ouvriere role;

	public TacheOuvriere(Ouvriere role) {
		this.role=role;
	}

	
	
	public abstract void evenement();
}
