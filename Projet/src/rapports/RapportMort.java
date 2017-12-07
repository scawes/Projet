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
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.MortProie;
import territoire.entite.proie.etat.Vivant;
import territoire.entite.proie.etat.tache.vivant.Deplacer;
import territoire.entite.proie.etat.tache.vivant.EstAttaquer;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Case;
import territoire.zone.Position;

public class RapportMort implements Rapport {
	private Integer nombreLarve;
	private Integer nombreFourmi;
	private Integer nombreAdult;

	public RapportMort() {
		this.nombreLarve = new Integer(0);
		this.nombreFourmi = new Integer(0);
		this.nombreAdult = new Integer(0);
	}

	@Override
	public String toString() {
		String resultat = "";
		resultat += "Fourmis MORT : " + nombreFourmi + "\n";
		resultat += "Larve MORT : " + nombreLarve + "\n";
		resultat += "Adulte MORT : " + nombreAdult + "\n";

		return resultat;
	}

	@Override
	public void traceForFourmiliere(Fourmiliere fourmiliere) {

	}

	@Override
	public void traceForFourmiliere(Fourmi fourmi) {
		if (fourmi.getAppetit().faim() == 0) {
			this.nombreFourmi++;
		}

	}

	@Override
	public void traceForFourmiliere(Adulte adulte) {
		if (adulte.getFourmi().getAppetit().faim() == 0) {
			this.nombreAdult++;
		}
	}

	@Override
	public void traceForFourmiliere(Larve larve) {
		if (larve.getFourmi().getAppetit().faim() == 0) {
			this.nombreLarve++;
		}

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
