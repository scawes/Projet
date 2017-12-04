package fourmi.tache;

import fourmi.role.Role;

public abstract class Tache {
	
	Role role;

	public Tache(Role role) {
		this.role=role;
	}

	public static Tache getTache(Role role) {
		return new Chasser(role);
	}
	
	public abstract void evenement();
}
