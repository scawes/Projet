package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.Vivant;

public class Attaque extends TacheOuvriere {

	/*
	 * Atributs
	 */

	Proie proie;

	/**
	 * Constructeur de Attaque
	 * 
	 * @param role
	 *            le role connait sa tache
	 * 
	 * @param proie
	 *            proie que la fourmi attaque
	 * 
	 */
	public Attaque(Ouvriere role, Proie proie) {
		super(role);
		this.proie = proie;
		Vivant vivant = (Vivant) proie.getEtat().getVivant();// actionFourmi(this);
		vivant.actionFourmi(this);
	}

	
	/*
	 * Getteurs et Setteurs
	 */
	
	public double getPoid() {
		return role.getEtat().getPoid();
	}

	
	/*
	 * Methodes
	 */
	
	/**
	 * 
	 */
	public void phaseAttaque() {
		getTerritoire().getCase(getDeplacement().getEmplacement()).addPheromone(getFourmi().getFourmiliere());
		if (!proie.getDeplacement().getEmplacement().equals(getDeplacement().getEmplacement())) {
			fuiteProie();
		}
	}

	/**
	 * 
	 */
	public void fuiteProie() {
		role.getTache();

	}

	@Override
	public void evenement() {
		phaseAttaque();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}