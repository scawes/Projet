package fourmiliere;

import java.util.ArrayList;
import java.util.List;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;
import territoire.Position;

public class Fourmiliere implements Trace {
	

	List<Position> position;
	List<Fourmi> population;
	
	public Fourmiliere(Fourmi reine) {
		population=new ArrayList<Fourmi>();
		position=new ArrayList<Position>();
		reine.setFourmiliere(this);

		ajouterFourmi(reine);
		position.add(reine.getPosition());
		
	}
	
	public void ajouterFourmi(Fourmi fourmi){
		population.add(fourmi);
	}
	
	public void evenement() {
		
		for(int i=0;i<population.size();i++){
			population.get(i).evenement();
		}	
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		for(Fourmi fourmi : population) {
			fourmi.trace(rapport);
		}
	}
	
	
}
