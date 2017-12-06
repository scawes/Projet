package proie.etat.tache;

import fourmi.role.Role;
import proie.etat.Etat;

public abstract class Tache {
	
	Etat etat;

	public Tache(Etat etat) {
		this.etat=etat;
	}

	public static Tache getTache(Role role) {
		return new Deplacer(role);
	}
	
	public abstract void evenement();
}
