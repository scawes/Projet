package rapports;

import Vue.GestionRapport;
import Vue.GestionVue;
import fourmi.Fourmi;
import fourmi.etat.Adulte;
import fourmi.etat.Larve;
import fourmi.etat.Lymphe;
import fourmi.etat.Oeuf;
import fourmi.role.Ouvriere;
import fourmi.role.Reine;
import fourmi.role.Sexue;
import fourmi.role.Soldat;
import fourmiliere.Fourmiliere;
import territoire.Case;
import territoire.Territoire;

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
