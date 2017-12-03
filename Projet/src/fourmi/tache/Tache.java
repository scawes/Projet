package fourmi.tache;

import fourmi.Fourmi;

public abstract class Tache {
	
	Fourmi fourmi;

	public Tache(Fourmi fourmi) {
		this.fourmi=fourmi;
	}

	public static Tache getTache(Fourmi fourmi) {
		return new Chasser(fourmi);
	}
	
	public abstract void evenement();
}
