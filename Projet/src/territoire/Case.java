package territoire;

import java.util.ArrayList;
import java.util.List;

import Vue.Controleur;
import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Case implements Trace{

	Position position;
	List<Fourmi> fourmiPresente;
	int element;
	
	Case(Position position) {
		this.position = position;
		fourmiPresente = new ArrayList<Fourmi>();
		element=0;
		draw();
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPheromone(int element){
		this.element=element;
		draw();
	}
	
	public int getPheromone(){
		return element;
	}

	public void ajouterEntite(Fourmi fourmi){
		fourmiPresente.add(fourmi);
	}
	
	public void supprimerEntite(Fourmi fourmi){
		fourmiPresente.remove(fourmi);
	}
	
	public List<Fourmi> getEntite(){
		return fourmiPresente;
	}
	
	void draw(){
		Controleur.drawCase(getPosition(),getPheromone());
	}
	
	
	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
}
