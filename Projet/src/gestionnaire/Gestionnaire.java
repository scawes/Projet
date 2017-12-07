package gestionnaire;

import javafx.scene.canvas.Canvas;
import observeur.TimeChange;
import simulateur.Simulateur;
import territoire.Territoire;
import territoire.zone.Position;

public class Gestionnaire {

	/*
	 * Attributss
	 */

	Territoire territoire;
	Simulateur simulateur;
	GestionVue gestionVue;
	GestionRapport gestionRapport;

	/**
	 * Constructeur de Gestionnaire
	 * 
	 * @param canvas
	 *            canvas de la vue principale
	 */
	public Gestionnaire(Canvas canvas) {
		simulateur = new Simulateur();
		territoire = new Territoire(this);

		getSimulateur().record(TimeChange.class.getName(), getTerritoire());
		gestionVue = new GestionVue(this, canvas);
		gestionRapport = new GestionRapport(this);

	}

	/*
	 * Getteurs
	 */
	
	public Territoire getTerritoire() {
		return territoire;
	}

	public Simulateur getSimulateur() {
		return simulateur;
	}

	public GestionVue getGestionVue() {
		return gestionVue;
	}

	public GestionRapport getGestionRapport() {
		return gestionRapport;
	}

	public void NouvelleFourmiliere(Position position) {
		getTerritoire().nouvelleFourmilliere(position);
	}

}
