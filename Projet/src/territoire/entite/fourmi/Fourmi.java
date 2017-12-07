package territoire.entite.fourmi;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Position;
import territoire.zone.deplacement.DeplacementFourmi;

public class Fourmi implements Trace {

	/*
	 * Attributs
	 */

	private Fourmiliere fourmiliere;
	private Etat etat;
	private DeplacementFourmi deplacement;
	private Appetit appetit;

	/**
	 * Constructeur d'une fourmi, il initialise sa posotion sur la grille et son
	 * appetit.
	 * 
	 * @param fourmiliere
	 *            une fourmi connait sa fourmillière
	 * @param position
	 *            de la fourmis
	 */
	public Fourmi(Fourmiliere fourmiliere, Position position) {
		this.etat = new Oeuf(this);
		setFourmiliere(fourmiliere);
		this.deplacement = new DeplacementFourmi(this, position);
		this.appetit = new Appetit();
	}

	/*
	 * Getteurs et setteurs de la classe fourmie
	 */

	public DeplacementFourmi getDeplacement() {
		return deplacement;
	}

	public void setFourmiliere(Fourmiliere fourmiliere) {
		this.fourmiliere = fourmiliere;
	}

	public Fourmiliere getFourmiliere() {
		return fourmiliere;
	}

	public void setAppetit(double appetit) {
		this.appetit = new Appetit(appetit);
	}

	public Appetit getAppetit() {
		return appetit;
	}

	/**
	 * Fonction qui permet de decrementer l'appetit
	 */
	public void appetit() {
		if (this.appetit.decrementer()) {
			// A COMPLETER : mort fourmi
			// System.out.println("MORT");
		}
		;
	}

	/**
	 * Fonction qui permet la propagation de l'evenement TimeChange. La fourmi
	 * decremente son appetit La fourmi propage a son tour l'evenement a son etat.
	 */
	public void evenement() {
		appetit();
		etat.evenement();
	}

	/**
	 * Fonction qui permet de changer l'etat d'une fourmie
	 * 
	 * @param nouvelEtat
	 */
	public void evolution(Etat nouvelEtat) {
		etat = nouvelEtat;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		etat.trace(rapport);
		appetit.trace(rapport);
	}

}
