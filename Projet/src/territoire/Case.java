package territoire;

import java.util.ArrayList;
import java.util.List;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Case implements Trace{

	Position position;
	List<Fourmi> fourmiPresente;
	Boolean marked;
	
	Case(Position position) {
		this.position = position;
		fourmiPresente = new ArrayList<Fourmi>();
		marked=false;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPheromone(){
		marked=true;
	}
	
	public boolean getPheromone(){
		return marked;
	}

	public void ajouterEntite(Fourmi fourmi){
		fourmiPresente.add(fourmi);
	}
	
	public void supprimerEntite(Fourmi fourmi){
		fourmiPresente.remove(fourmi);
	}
	
	
	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
}
