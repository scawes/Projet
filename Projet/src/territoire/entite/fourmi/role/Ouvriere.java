package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.etat.Etat;
import territoire.entite.fourmi.tache.ouvriere.Attaque;
import territoire.entite.fourmi.tache.ouvriere.Chasser;
import territoire.entite.fourmi.tache.ouvriere.Manger;
import territoire.entite.fourmi.tache.ouvriere.RetourFourmiliere;
import territoire.entite.fourmi.tache.ouvriere.TacheOuvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.MortProie;
import territoire.zone.Position;

public class Ouvriere extends Role implements Trace {

	/*
	 * Attributs
	 */

	TacheOuvriere tache;

	/**
	 * Constructeur d'une ouvriere.
	 * 
	 * @param etat
	 *            le role connait sont etat
	 */
	public Ouvriere(Etat etat) {
		super(etat);
		tache = getTache();
	}
	
	
	/*
	 * Methodes
	 */

	@Override
	public void evenement() {
		tache.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		tache.trace(rapport);
	}

	/**
	 * Definie la prochaine tache d'une ouvriere.
	 * si elle se trouve dans le nid, elle donne a manger.
	 * sinon elle va chasser.
	 * @return
	 */
	public TacheOuvriere getTache() {
		for (Position position : getEtat().getFourmi().getFourmiliere().getPosition()) {
			if (position.equals(getEtat().getFourmi().getDeplacement().getEmplacement())) {
				tache = new Manger(this);
				return tache;
			}
		}
		return getChasse();
	}

	/**
	 * La fourmi va chasser.
	 * @return
	 */
	public TacheOuvriere getChasse() {
		tache = new Chasser(this);
		return tache;
	}

	
	/**
	 * La fourmi attaque une proie
	 * @param proie
	 * @return
	 */
	public Attaque tacheAttaque(Proie proie) {
		Attaque attaque = new Attaque(this, proie);
		tache = attaque;
		return attaque;
	}

	
	/**
	 * La fourmi ramene une proie
	 * @param proie
	 * @return
	 */
	public RetourFourmiliere tacheRamenerProie(MortProie proie) {
		RetourFourmiliere retourFourmiliere = new RetourFourmiliere(this, proie);
		tache = retourFourmiliere;
		return retourFourmiliere;
	}

}
