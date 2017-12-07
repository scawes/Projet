package rapports;

import gestionnaire.GestionRapport;
import territoire.Territoire;
import territoire.entite.fourmi.Appetit;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Adulte;
import territoire.entite.fourmi.etat.Larve;
import territoire.entite.fourmi.etat.Nymphe;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.fourmi.role.Reine;
import territoire.entite.fourmi.role.Sexue;
import territoire.entite.fourmi.role.Soldat;
import territoire.entite.fourmi.tache.ouvriere.Attaque;
import territoire.entite.fourmi.tache.ouvriere.Chasser;
import territoire.entite.fourmi.tache.ouvriere.Manger;
import territoire.entite.fourmi.tache.ouvriere.RetourFourmiliere;
import territoire.entite.proie.etat.MortProie;
import territoire.entite.proie.etat.Vivant;
import territoire.entite.proie.etat.tache.vivant.Deplacer;
import territoire.entite.proie.etat.tache.vivant.EstAttaquer;
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
	public void traceForFourmiliere(Nymphe lymphe) {
		
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

	@Override
	public void traceForFourmiliere(Attaque attaque) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(Chasser chasser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(Manger manger) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(RetourFourmiliere retourFourmiliere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(MortProie mortProie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(Vivant vivant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(EstAttaquer estAttaquer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(Deplacer deplacer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traceForFourmiliere(Appetit appetit) {
		// TODO Auto-generated method stub
		
	}
	
}
