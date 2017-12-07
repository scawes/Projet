package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.zone.Position;

public class Manger extends TacheOuvriere {

	/**
	 * Constructeur de Manger
	 * 
	 * @param role
	 *            le role connait sa tache
	 * 
	 */
	public Manger(Ouvriere role) {
		super(role);
	}

	/*
	 * Methodes
	 */

	/**
	 * regarde si des fourmie sur la case on faim
	 * 
	 * @param position
	 * @return Fourmi affamer ou null
	 */
	Fourmi chercherFourmiCase(Position position) {
		for (Fourmi fourmi : getTerritoire().getCase(position).getEntite()) {
			if (fourmi.getAppetit().besoin() > 0) {
				return fourmi;
			}
		}
		return null;
	}

	/**
	 * regarde la faim de toute les fourmis de la fourmiliere
	 * 
	 * @return Fourmi affamer ou null
	 */
	Fourmi chercherFourmi() {
		Fourmi fourmi;
		for (Position position : getFourmi().getFourmiliere().getPosition()) {
			fourmi = chercherFourmiCase(position);
			if (fourmi != null)
				return fourmi;
		}
		return null;
	}

	/**
	 * regarde si une proie peut etre consommer sur la case
	 * 
	 * @param position
	 * @return Proie consommable ou null
	 */
	Proie chercherProieCase(Position position) {
		for (Proie proie : getTerritoire().getCase(position).getProies()) {
			if (!proie.isVivant()) {
				if (proie.getPoid() > 0) {
					return proie;
				}
			}
		}
		return null;
	}

	/**
	 * regarde les proie consommable au nid
	 * 
	 * @return Proie consommable ou null
	 */
	Proie chercherProie() {
		Proie proie;
		for (Position position : getFourmi().getFourmiliere().getPosition()) {
			proie = chercherProieCase(position);
			if (proie != null)
				return proie;
		}
		return null;
	}

	/**
	 * cherche une fourmie a nourrir et une proie a consommer si ce n'est pas
	 * disponnible, va chasser sinon donne a manger a la fourmi et cherche une
	 * nouvelle tache
	 */
	void nourrir() {
		Fourmi fourmi = chercherFourmi();
		Proie proie = chercherProie();
		if (fourmi != null && proie != null) {

			double besoin = fourmi.getAppetit().besoin();
			double donner = proie.decrementePoid(besoin);
			fourmi.getAppetit().manger(donner);

			role.getTache();
			return;
		}
		role.getChasse();

	}

	/**
	 * action manger
	 */
	void phaseManger() {
		nourrir();
	}

	@Override
	public void evenement() {
		phaseManger();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
