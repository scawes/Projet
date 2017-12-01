package rapports;

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

public class RapportTrace implements Rapport{
	private Integer nombreOeuf;
	private Integer nombreLymphe;
	private Integer nombreLarve;
	private Integer nombreFourmi;
	private Integer nombreOuvriere;
	private Integer nombreSolda;
	private Integer nombreSexue;
	private Integer nombreAdult;
	
	public RapportTrace() {
		this.nombreOeuf = new Integer(0);
		this.nombreLymphe = new Integer(0);
		this.nombreLarve = new Integer(0);
		this.nombreFourmi = new Integer(0);
		this.nombreOuvriere = new Integer(0);
		this.nombreSolda = new Integer(0);
		this.nombreSexue = new Integer(0);
		this.nombreAdult = new Integer(0);
	}
	
	@Override
	public String toString() {
		String resultat = "";
		resultat += "Fourmis : "  + nombreFourmi +"\n";
		resultat += "Oeuf : "+ nombreOeuf +"\n" ;
		resultat += "Larve : "  + nombreLarve +"\n";
		resultat += "Lymphe : "  + nombreLymphe +"\n";
		resultat += "Adulte : "  + nombreAdult +"\n";
		resultat += "Ouvriere : "  + nombreOuvriere +"\n";
		resultat += "Soldat : "  + nombreSolda +"\n";
		resultat += "Sexue : "  + nombreSexue +"\n";
		
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
		this.nombreAdult++;
	}

	@Override
	public void traceForFourmiliere(Larve larve) {
		this.nombreLarve++;
	}

	@Override
	public void traceForFourmiliere(Oeuf oeuf) {
		this.nombreOeuf++;
	}

	@Override
	public void traceForFourmiliere(Lymphe lymphe) {
		this.nombreLymphe++;
	}

	@Override
	public void traceForFourmiliere(Reine reine) {
		
	}

	@Override
	public void traceForFourmiliere(Ouvriere ouvriere) {
		this.nombreOuvriere++;
	}

	@Override
	public void traceForFourmiliere(Sexue sexue) {
		this.nombreSexue++;
	}

	@Override
	public void traceForFourmiliere(Soldat solda) {
		this.nombreSolda++;
	}

	@Override
	public void traceForFourmiliere(Territoire territoire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void traceForFourmiliere(Case caseTerritoire) {
		// TODO Auto-generated method stub
		
	}
	
}
