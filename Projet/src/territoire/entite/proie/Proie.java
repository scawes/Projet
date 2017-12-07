package territoire.entite.proie;

import rapports.Rapport;
import rapports.Trace;
import territoire.Territoire;
import territoire.entite.proie.etat.Etat;
import territoire.entite.proie.etat.MortProie;
import territoire.entite.proie.etat.Vivant;
import territoire.zone.Position;
import territoire.zone.deplacement.Deplacement;
import territoire.zone.deplacement.DeplacementProie;

public class Proie implements Trace {

	/*
	 * Attributs
	 */

	Territoire territoire;
	Etat etat;
	DeplacementProie deplacement;

	double poid;
	private final double poidMin = 1.5;
	private final double poidMax = 5;

	/**
	 * Constructeur de proie.
	 * 
	 * @param territoire
	 *            la proie connait le territoire
	 * @param position
	 *            La position de la proie est initiliser
	 */
	public Proie(Territoire territoire, Position position) {
		this.territoire = territoire;
		deplacement = new DeplacementProie(this, position);
		etat = new Vivant(this);
		poid = (poidMin + (double) Math.random() * ((poidMax - poidMin) + 1));

	}

	/*
	 * Getteurs et Setteurs
	 */
	
	public Deplacement getDeplacement() {
		return this.deplacement;
	}

	public Territoire getTerritoire() {
		return this.territoire;
	}

	public boolean isVivant() {
		return etat.isVivant();
	}

	public Etat getVivant() {
		return etat.getVivant();
	}

	public Etat getEtat() {
		return etat;
	}

	public void mortProie() {
		etat = new MortProie(this);
	}

	public double getPoid() {
		return this.poid;
	}

	/*
	 * Methodes
	 */
	
	/**
	 * 
	 * @param manger
	 * @return
	 */
	public double decrementePoid(double manger) {
		if (this.poid - manger < 0) {
			manger = this.poid;
		}
		this.poid -= manger;
		return manger;
	}

	public void evenement() {
		etat.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		etat.trace(rapport);
	}

	/*
	 * public void deces() {
	 * 
	 * this.enVie= false; }
	 */
	/*
	 * public void decrementeFraicheur() { fraicheur--; }
	 */
}
