package gestionnaire;

import rapports.Rapport;
import rapports.RapportGraphique;
import rapports.RapportMort;
import rapports.RapportTache;
import rapports.RapportTrace;

public class GestionRapport {

	Gestionnaire gestionnaire;

	GestionRapport(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public void trace() {
		Rapport rapport = new RapportTrace();
		gestionnaire.getTerritoire().trace(rapport);
		System.out.println(rapport);

	}

	public void traceTache() {
		Rapport rapport = new RapportTache();
		gestionnaire.getTerritoire().trace(rapport);
		System.out.println(rapport);
	}

	public void traceMort() {
		Rapport rapport = new RapportMort();
		gestionnaire.getTerritoire().trace(rapport);
		System.out.println(rapport);

	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	@SuppressWarnings("deprecation")
	public void graphique() {
		gestionnaire.getSimulateur().suspend();
		gestionnaire.getGestionVue().clear();
		Rapport rapport = new RapportGraphique(this);
		gestionnaire.getTerritoire().trace(rapport);
		gestionnaire.getSimulateur().resume();

	}

}
