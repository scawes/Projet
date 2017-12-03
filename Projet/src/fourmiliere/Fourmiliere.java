package fourmiliere;

import java.util.ArrayList;
import java.util.List;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;
import territoire.Position;
import territoire.Territoire;

public class Fourmiliere implements Trace {
	

	List<Position> surface;
	List<Fourmi> population;
	
	public Fourmiliere(Fourmi reine) {
		population=new ArrayList<Fourmi>();
		surface=new ArrayList<Position>();
		reine.setFourmiliere(this);

		ajouterFourmi(reine);
		extentionConstruction(reine.getPosition());
		
	}
	
	public void ajouterFourmi(Fourmi fourmi){
		population.add(fourmi);
	}
	
	public void evenement() {
		for(int i=0;i<population.size();i++){
			population.get(i).evenement();
		}	
	}
	
	public void extentionConstruction(Position position){
		surface.add(position);
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		for(Fourmi fourmi : population) {
			fourmi.trace(rapport);
		}
	}
	
	
}
