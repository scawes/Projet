package territoire.entite.fourmi.tache.ouvriere;

import rapports.Trace;
import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.zone.deplacement.DeplacementFourmi;

public abstract class TacheOuvriere implements Trace {

	/*
	 * Attributs
	 */

	Ouvriere role;

	/**
	 * Constructeur d'une TacheOuvriere
	 * 
	 * @param role
	 *            permet de faire le lien entre une TacheOuvriere et son role
	 */
	public TacheOuvriere(Ouvriere role) {
		this.role = role;
	}

	/*
	 * Getteurs
	 */

	Territoire getTerritoire() {
		return getFourmi().getFourmiliere().getTerritoire();
	}

	Fourmi getFourmi() {
		return role.getEtat().getFourmi();
	}

	DeplacementFourmi getDeplacement() {
		return getFourmi().getDeplacement();
	}

	int getIndexFourmiliere() {
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere()) + 1;
	}

	/*
	 * Methodes
	 */

	/**
	 * Fonction qui permet la propagation de l'evenement TimeChange. TacheOuvriere
	 * propage à son tour l'evenement.
	 */
	public abstract void evenement();
}
