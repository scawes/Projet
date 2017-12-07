package territoire.entite.proie.etat;

import rapports.Trace;
import territoire.entite.proie.Proie;
import territoire.zone.Position;

public abstract class Etat implements Trace {

	Proie proie;

	Etat(Proie proie) {
		this.proie = proie;
	}

	Position getPosition() {
		return proie.getDeplacement().getEmplacement();
	}

	public Proie getProie() {
		return proie;
	}

	public abstract void setTache();

	public abstract Etat getVivant();

	public abstract boolean isVivant();

	public abstract void evenement();

}
