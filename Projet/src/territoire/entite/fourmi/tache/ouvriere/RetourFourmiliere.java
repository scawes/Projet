package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.etat.MortProie;
import territoire.zone.Position;

public class RetourFourmiliere extends TacheOuvriere {

	/*
	 * Attributs
	 */

	final int NOMBRE_VOISIN = 4;
	final int DISTANCE_MAX = 200;

	MortProie proie;

	/**
	 * Constructeur de Attaque
	 * 
	 * @param role
	 *            le role connait sa tache
	 * 
	 * @param proie
	 *            proie que la fourmi ramène à la fourmiliere
	 * 
	 */
	public RetourFourmiliere(Ouvriere role, MortProie proie) {
		super(role);
		this.proie = proie;
	}

	/**
	 * 1. deplace la fourmi 2. deplace la proie 3. regarde si la fourmi a atteind la
	 * fourmiliere
	 */
	public void phaseRentrer() {
		Position caseSuivante = nextCase(getDeplacement().getVoisin());
		getDeplacement().changerCase(caseSuivante);
		proie.actionFourmi(getDeplacement().getEmplacement());
		voirFourmiliere();
	}

	/**
	 * regarde si la fourmi a atteind la fourmiliere
	 * 
	 * @return
	 */
	public boolean voirFourmiliere() {
		for (Position positionFourmiliere : getFourmi().getFourmiliere().getPosition()) {
			if (positionFourmiliere.equals(getDeplacement().getEmplacement())) {
				role.getTache();
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param listeVoisin
	 * @return prochaine case
	 */
	Position nextCase(Position[] listeVoisin) {
		int[] listeProbabilite = new int[NOMBRE_VOISIN];
		int total = 0;

		for (int i = 0; i < NOMBRE_VOISIN; i++) {
			listeProbabilite[i] = importanceCase(listeVoisin[i]);
			total += listeProbabilite[i];
		}

		double random = Math.random() * total;

		int seuil = 0;

		for (int i = 0; i < NOMBRE_VOISIN; i++) {
			if (random > seuil && random < listeProbabilite[i] + seuil) {
				return listeVoisin[i];
			} else {
				seuil += listeProbabilite[i];
			}
		}
		return getDeplacement().getEmplacement();

	}

	/**
	 * 
	 * @param positionTest
	 * @return calcul la valeur d'importance de la casse en chasse
	 */
	int importanceCase(Position positionTest) {
		// la case se trouve trop loin de la fourmiliere : importance null
		if (positionTest.getX() > getFourmi().getFourmiliere().getPosition().get(0).getX() + DISTANCE_MAX)
			return 0;
		if (positionTest.getX() < getFourmi().getFourmiliere().getPosition().get(0).getX() - DISTANCE_MAX)
			return 0;
		if (positionTest.getY() > getFourmi().getFourmiliere().getPosition().get(0).getY() + DISTANCE_MAX)
			return 0;
		if (positionTest.getY() < getFourmi().getFourmiliere().getPosition().get(0).getY() - DISTANCE_MAX)
			return 0;
		// la case est la position precedente : importance tres faible

		if (positionTest.equals(getDeplacement().getEmplacementPrecedent()))
			return 1;
		int pheromone = getTerritoire().getCase(positionTest).getPheromone(role);
		// option case inataignable
		if (pheromone == -2)
			return 0;
		// case par defaut : importance tres faible
		if (pheromone == 0)
			return 1;
		// case avec pheromone : importance fort
		if (pheromone < 50)
			return 50;
		// case avec beaucoup de pheromone : importance tres fort
		return pheromone;
	}

	@Override
	public void evenement() {
		phaseRentrer();

	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
