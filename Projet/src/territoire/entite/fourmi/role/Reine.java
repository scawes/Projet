package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Etat;

public class Reine extends Role implements Trace {

	/*
	 * Attributs
	 */

	double delaisPonte;

	private final double DELAIS_PONTE = 5;

	private final double dureeDeVieMin = 4000;
	private final double dureeDeVieMax = 6000;
	// double poids;

	/**
	 * Constructeur d'une reine.
	 * 
	 * @param etat
	 *            le role connait sont etat
	 */
	public Reine(Etat etat) {
		super(etat);
		delaisPonte = DELAIS_PONTE;

		int dureeDeVie = ((int) (dureeDeVieMin + Math.random() * ((dureeDeVieMax - dureeDeVieMin) + 1)));
		etat.setDureeDeVie(dureeDeVie);
		etat.setPoid(15);

	}

	/*
	 * Methodes
	 */

	@Override
	public void evenement() {
		delaisPonte--;
		if (delaisPonte < 0) {
			ponte();
			delaisPonte = 5;
		}
		ajouterPheromone();
	}

	/**
	 * Ajoute un oeuf dans la fourmiliere
	 */
	private void ponte() {
		this.getFourmiliere()
				.ajouterFourmi(new Fourmi(this.getFourmiliere(), etat.getFourmi().getDeplacement().getEmplacement()));
	}

	/**
	 * Ajoute les pheromone
	 */
	void ajouterPheromone() {
		getFourmiliere().getTerritoire().getCase(getEtat().getFourmi().getDeplacement().getEmplacement())
				.addPheromone(getFourmiliere());
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
