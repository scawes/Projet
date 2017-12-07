package territoire.entite.fourmi.tache.ouvriere;

import java.util.List;

import rapports.Rapport;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.MortProie;
import territoire.zone.Position;

public class Chasser extends TacheOuvriere {

	/**
	 * Attributs
	 */

	final int NOMBRE_VOISIN = 4;
	final int DISTANCE_MAX = 200;

	/**
	 * Constructeur de Chasser
	 * 
	 * @param role
	 *            le role connait sa tache
	 * 
	 */
	public Chasser(Ouvriere role) {
		super(role);
	}

	/*
	 * Methodes
	 */

	/**
	 * Effectue une phase de chasse. 1. rechercher proie 2. deplacement 3. poser des
	 * pheromones 4. rechercher proie
	 */
	public void phaseChasse() {
		if (voirProie()) {
			return;
		}
		Position caseSuivante = nextCase(getDeplacement().getVoisin());
		getDeplacement().changerCase(caseSuivante);
		getTerritoire().getCase(caseSuivante).addPheromone(getFourmi().getFourmiliere());
		voirProie();

	}

	/**
	 * Permet de detecter une proie sur une ma case. definie la prochaine tache
	 * selon l'etat de la proie.
	 * 
	 * @return true si une proie est detecter
	 * @return false sinon
	 */
	public boolean voirProie() {
		List<Proie> listeProie = getTerritoire().getCase(getDeplacement().getEmplacement()).getProies();
		if (listeProie.size() > 0) {
			for (Proie proie : listeProie) {
				if (proie.isVivant() == true) {
					role.tacheAttaque(proie);
					return true;
				} else {
					for (Position positionFourmiliere : getFourmi().getFourmiliere().getPosition()) {
						if (positionFourmiliere.equals(getDeplacement().getEmplacement())) {
							return false;
						}
					}
					if (((MortProie) proie.getEtat()).estPrise()) {
						return false;
					}
					role.tacheRamenerProie((MortProie) proie.getEtat());
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * Determine la prochaine case
	 * 
	 * @param listeVoisin
	 *            liste des position voisine
	 * @return la position de la prochaine case
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
	 * @param position
	 *            de la case a tester
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

		// la case est la position precedente : importance faible
		if (positionTest.equals(getDeplacement().getEmplacementPrecedent()))
			return 10;

		int pheromone = getTerritoire().getCase(positionTest).getPheromone(role);
		// optionnel case inataignable
		if (pheromone == -2)
			return 0;
		// case avec beaucoup de pheromone : imortance fort
		if (pheromone > 20)
			return 50;
		// case normal ou avec peu de pheromone : importance normal
		if (pheromone < 20)
			return 20;
		// case avec des pheromone : importance normal a fort
		return pheromone;
	}

	@Override
	public void evenement() {
		phaseChasse();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}