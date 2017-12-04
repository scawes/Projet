package territoire;

import java.util.ArrayList;
import java.util.List;

import Vue.GestionVue;
import fourmi.Fourmi;
import pheromone.Pheromone;
import rapports.Rapport;
import rapports.Trace;

public class Case implements Trace{

	Position position;
	List<Fourmi> fourmiPresente;
	int element;
	int vie = 20;
	List<Pheromone> listePheromones ;
	
	Case(Position position) {
		this.position = position;
		fourmiPresente = new ArrayList<Fourmi>();
		element=0;
		listePheromones = new ArrayList<Pheromone>();
		draw();
	}
	
	public Position getPosition(){
		return position;
	}
	
	
	
	public void setPheromone(int element){
		if(this.element!=element){
			this.element=element;
			draw();
		}
		vie=100;
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
		GestionVue.getInstance().drawCase(getPosition(),getPheromone());
	}
	
	
	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

	
	public void evenement() {
		if(fourmiPresente.size()<=0||element>0)vie--;
		if(vie<0){
			//Controleur.clearCase(position);
			//Territoire.getInstance().removeCase(this);
			setPheromone(0);
		}
	}
}
