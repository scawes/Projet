package territoire.entite.fourmi.role;

import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.fourmiliere.Fourmiliere;

public abstract class Role implements Trace {

	/*
	 * Attributs
	 */

	Etat etat;

	/**
	 * Constructeur de Role, il permet de creer le lien entre l'Etat et son Role
	 * 
	 * @param etat
	 *            etat lier à son Role
	 */
	public Role(Etat etat) {
		this.etat = etat;
	}

	/*
	 * Getteurs et Setteurs
	 */

	public Etat getEtat() {
		return etat;
	}

	Fourmiliere getFourmiliere() {
		return etat.getFourmi().getFourmiliere();
	}

	/**
	 * Fonction qui permet la propagation de l'evenement TimeChange. Le role propage
	 * à son tour l'evenement.
	 */
	public abstract void evenement();

}
