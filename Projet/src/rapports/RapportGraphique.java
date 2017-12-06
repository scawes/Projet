package rapports;

import gestionnaire.GestionRapport;
import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Adulte;
import territoire.entite.fourmi.etat.Larve;
import territoire.entite.fourmi.etat.Lymphe;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.fourmi.role.Reine;
import territoire.entite.fourmi.role.Sexue;
import territoire.entite.fourmi.role.Soldat;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Case;

public class RapportGraphique implements Rapport{
	
	GestionRapport gestionRapport;
	
	public RapportGraphique(GestionRapport gestionRapport) {
		this.gestionRapport=gestionRapport;
	}
	
	@Override
	public String toString() {
		
		return "";
	}

	@Override
	public void traceForFourmiliere(Fourmiliere fourmiliere) {
		
	}

	@Override
	public void traceForFourmiliere(Fourmi fourmi) {
		
	}

	@Override
	public void traceForFourmiliere(Adulte adulte) {
		
	}

	@Override
	public void traceForFourmiliere(Larve larve) {
		
	}

	@Override
	public void traceForFourmiliere(Oeuf oeuf) {
		
	}

	@Override
	public void traceForFourmiliere(Lymphe lymphe) {
		
	}

	@Override
	public void traceForFourmiliere(Reine reine) {
		
	}

	@Override
	public void traceForFourmiliere(Ouvriere ouvriere) {
		
	}

	@Override
	public void traceForFourmiliere(Sexue sexue) {
		
	}

	@Override
	public void traceForFourmiliere(Soldat solda) {

	}

	@Override
	public void traceForFourmiliere(Territoire territoire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void traceForFourmiliere(Case caseTerritoire) {
		// TODO Auto-generated method stub
		gestionRapport.getGestionnaire().getGestionVue().drawCase(caseTerritoire.getPosition(),caseTerritoire.getPheromone());
	}
	
}
