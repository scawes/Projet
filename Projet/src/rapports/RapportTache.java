package rapports;

import territoire.Territoire;
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
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Case;
import territoire.zone.Position;

public class RapportTache implements Rapport{
	private Integer nombreFourmi;
	private Integer nombreAttaque;
	private Integer nombreChasser;
	private Integer nombreManger;
	private Integer nombreRetourFourmiliere;

	
	public RapportTache() {
		this.nombreFourmi = new Integer(0);
		this.nombreAttaque = new Integer(0);
		this.nombreChasser = new Integer(0);
		this.nombreManger = new Integer(0);
		this.nombreRetourFourmiliere = new Integer(0);
	}
	
	@Override
	public String toString() {
		String resultat = "";
		resultat += "Total : "  + nombreFourmi +"\n";
		resultat += "Attaque : "  + nombreAttaque +"\n";
		resultat += "Chasser : "+ nombreChasser +"\n" ;
		resultat += "Manger : "  + nombreManger +"\n";
		resultat += "Retour Fourmiliere : "  + nombreRetourFourmiliere +"\n";

		
		return resultat;
	}

	@Override
	public void traceForFourmiliere(Fourmiliere fourmiliere) {
		
	}

	@Override
	public void traceForFourmiliere(Fourmi fourmi) {
		this.nombreFourmi++;
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

	}

	@Override
	public void traceForFourmiliere(Attaque attaque) {
		nombreAttaque++;
	}

	@Override
	public void traceForFourmiliere(Chasser chasser) {
		nombreChasser++;
		
	}

	@Override
	public void traceForFourmiliere(Manger manger) {
		nombreManger++;
	}

	@Override
	public void traceForFourmiliere(RetourFourmiliere retourFourmiliere) {
		nombreRetourFourmiliere++;
	}
	
}
