package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.fourmi.role.Reine;
import territoire.entite.fourmi.role.Role;

public class Adulte extends Etat implements Trace {

	/*
	 * Attributs
	 */

	private final int VIE_ADULTE = 2000;
	private final double POID_MIN = 1.5;
	private final double POID_MAX = 2;

	Role role;
	int tempsDehors;

	/**
	 * Constructeur de l'etat Adulte.
	 * 
	 * @param fourmi
	 *            l'etat connait sa fourmi.
	 */
	public Adulte(Fourmi fourmi) {
		super(fourmi);
		setDureeDeVie(VIE_ADULTE);
		this.poid = (POID_MIN + (double) Math.random() * ((POID_MAX - POID_MIN) + 1));
		getFourmi().setAppetit(poid / 3);
		this.role = getRole(this);
	}

	/**
	 * choisi le role de la fourmie selon le nombre de fourmis dans la fourmiliere
	 * @param etat
	 * @return
	 */
	public Role getRole(Etat etat) {
		if (etat.getFourmi().getFourmiliere().getListeFourmi().size() < 1)
			return new Reine(etat);
		else
			return new Ouvriere(etat);
	}

	/*
	 * Methodes
	 */

	@Override
	public void evenement() {
		vieillir();
		role.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		role.trace(rapport);
	}

	@Override
	void vieillir() {
		if (dureeDeVie.decrementer()) {
			// A COMPLETER : mort fourmi
			// System.out.println("MORT VIEILESSE");
		}
	}

}