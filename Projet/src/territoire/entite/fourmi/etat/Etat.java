package territoire.entite.fourmi.etat;

import rapports.Trace;
import territoire.entite.DureeVie;
import territoire.entite.fourmi.Fourmi;

public abstract class Etat implements Trace {

	/*
	 * Attributs
	 */

	Fourmi fourmi;
	protected double poid;
	protected DureeVie dureeDeVie;

	/**
	 * Constructeur de Etat, il permet de creer le lien entre les etats et les
	 * fourmis
	 * 
	 * @param fourmi
	 *            fourmi lier à l'etat
	 */
	Etat(Fourmi fourmi) {
		this.fourmi = fourmi;
	}

	/*
	 * Getteur et Setteur
	 */

	public double getPoid() {
		return this.poid;
	}

	public void setPoid(double poid) {
		this.poid = poid;
	}

	public void setDureeDeVie(int duree) {
		dureeDeVie = new DureeVie(duree);
	}

	public Fourmi getFourmi() {
		return fourmi;
	}

	/*
	 * Methodes
	 */

	/**
	 * Fonction qui diminue l'esperance de vie de la fourmi. Et permet de changer
	 * l'etat de la fourmi
	 */
	abstract void vieillir();

	/**
	 * Fonction qui permet la propagation de l'evenement TimeChange. L'etat propage
	 * à son tour l'evenement.
	 */
	public abstract void evenement();

}
