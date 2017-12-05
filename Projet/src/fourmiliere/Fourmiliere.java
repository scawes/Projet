package fourmiliere;

import java.util.ArrayList;
import java.util.List;

import fourmi.Fourmi;
import proie.Proie;
import rapports.Rapport;
import rapports.Trace;
import territoire.Position;
import territoire.Territoire;

public class Fourmiliere implements Trace {
	

	List<Position> surface;
	List<Fourmi> population;
	
	Territoire territoire;
	
	public Fourmiliere(Fourmi reine,Territoire territoire) {
		this.territoire=territoire;
		population=new ArrayList<Fourmi>();
		surface=new ArrayList<Position>();
		reine.setFourmiliere(this);

		ajouterFourmi(reine);
		extentionConstruction(reine.getDeplacement().getEmplacement());
		
	}
	
	public Territoire getTerritoire() {
		return territoire;
	}
	
	public void ajouterFourmi(Fourmi fourmi){
		population.add(fourmi);
	}
	
	public List<Position> getPosition(){
	  return surface;
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
