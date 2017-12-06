package territoire.entite.fourmi.tache.ouvriere;

import territoire.entite.fourmi.role.Ouvriere;

public abstract class TacheOuvriere {
	
	Ouvriere role;

	public TacheOuvriere(Ouvriere role) {
		this.role=role;
	}

	
	
	public abstract void evenement();
}
