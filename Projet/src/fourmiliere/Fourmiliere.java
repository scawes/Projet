package fourmiliere;

import java.util.ArrayList;
import java.util.List;

import fourmi.Fourmi;
import observeur.Evenement;
import observeur.Observeur;
import rapports.Rapport;
import rapports.RapportTrace;
import rapports.Trace;

public class Fourmiliere implements Observeur,Trace {
	Fourmi reine;
	
	List<Fourmi> population;
	
	public Fourmiliere(Fourmi reine) {
		population=new ArrayList<Fourmi>();
		this.reine=reine;
		reine.setFourmiliere(this);
	}
	
	public void ajouterFourmi(Fourmi fourmi){
		population.add(fourmi);
	}
	
	void evenement() {
		reine.evenement();
	}

	@Override
	public void receive(Evenement evt) {
		reine.evenement();
		for(Fourmi fourmi : population) {
			fourmi.evenement();
		}
		Rapport rapport = new RapportTrace();
		trace(rapport);
		System.out.println(rapport);
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		reine.trace(rapport);
		for(Fourmi fourmi : population) {
			fourmi.trace(rapport);
		}
	}
	
	
}
