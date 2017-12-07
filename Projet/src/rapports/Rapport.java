package rapports;

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

public interface Rapport {
	void traceForFourmiliere(Fourmiliere fourmiliere);
	void traceForFourmiliere(Fourmi fourmi);
	
	void traceForFourmiliere(Adulte adulte);
	void traceForFourmiliere(Larve larve);
	void traceForFourmiliere(Oeuf oeuf);
	void traceForFourmiliere(Nymphe lymphe);
	
	void traceForFourmiliere(Reine reine);
	void traceForFourmiliere(Ouvriere ouvriere);
	void traceForFourmiliere(Soldat soldat);
	void traceForFourmiliere(Sexue sexue);
	
	void traceForFourmiliere(Attaque attaque);
	void traceForFourmiliere(Chasser chasser);
	void traceForFourmiliere(Manger manger);
	void traceForFourmiliere(RetourFourmiliere retourFourmiliere);
	
	void traceForFourmiliere(Territoire territoire);
	void traceForFourmiliere(Case caseTerritoire);
	void traceForFourmiliere(MortProie mortProie);
	void traceForFourmiliere(Vivant vivant);
	void traceForFourmiliere(EstAttaquer estAttaquer);
	void traceForFourmiliere(Deplacer deplacer);
	void traceForFourmiliere(Appetit appetit);
}
