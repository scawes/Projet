package territoire.entite.fourmi;

import rapports.Rapport;
import rapports.Trace;

public class Appetit implements Trace {

	/*
	 * Attributs
	 */

	final int JOURNEE = 120;

	double faim;
	double appetit;

	/**
	 * Constructeur d'appetit.
	 * 
	 * @param appetit
	 *            dose de nouriture que mange une fourmi par jour
	 */
	public Appetit(double appetit) {
		this.appetit = appetit;
		faim = JOURNEE * appetit;
		if (appetit == 0) {
			faim = 1;
		}
	}

	/**
	 * Constructeur d'appetit.
	 */
	public Appetit() {
		faim = 1;
	}

	/*
	 * Methodes
	 */

	/**
	 * decremante la fain tant que elle est superrieur à 0
	 * 
	 * @return fasle quand on decremente
	 * @return true quand faim est à 0
	 */
	public boolean decrementer() {
		if (faim <= 0) {
			return true;
		}
		faim -= appetit;
		return false;
	}

	public void manger(double nourriture) {
		faim += nourriture * JOURNEE;
	}

	public double faim() {
		return faim / JOURNEE;
	}

	public double besoin() {
		double result = appetit - faim / JOURNEE;
		if (result < 0) {
			return 0;
		}
		return appetit - faim / JOURNEE;
	}

	public double capacite() {
		return appetit * JOURNEE;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
}
