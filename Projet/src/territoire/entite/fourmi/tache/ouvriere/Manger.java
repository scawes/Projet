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
	 * 
	 * @param position
	 * @return
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
	 * 
	 * @return
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
	 * 
	 * @param position
	 * @return
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
	 * 
	 * @return
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
	 * 
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
	 * 
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
