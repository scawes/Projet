package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Vue.GestionVue;
import fourmi.Fourmi;
import fourmi.role.Ouvriere;
import fourmi.role.Role;
import fourmi.role.Sexue;
import fourmiliere.Fourmiliere;
import pheromone.Pheromone;
import pheromone.PheromoneFemelle;
import pheromone.PheromoneMale;
import rapports.Rapport;
import rapports.Trace;

public class Case implements Trace{

	Position position;
	List<Fourmi> fourmiPresente;
	int element;
	int vie = 20;
	Map<Fourmiliere,Pheromone> listePheromones ;
	
	Case(Position position) {
		this.position = position;
		fourmiPresente = new ArrayList<Fourmi>();
		element=0;
		listePheromones = new HashMap<Fourmiliere,Pheromone>();
		draw();
	}
	
	public Position getPosition(){
		return position;
	}
	
	
	
	public void addPheromone(Role maFourmi){
	      
	        if(this.listePheromones.containsKey(maFourmi.getEtat().getFourmi().getFourmiliere())){
                 this.listePheromones.get(maFourmi.getEtat().getFourmi().getFourmiliere()).passageFourmie();
                  draw();
                }
	        else {
	          Pheromone pheromone;
	          if(maFourmi instanceof Ouvriere)pheromone=new PheromoneMale(maFourmi.getEtat().getFourmi()) ;
	          if(maFourmi instanceof Sexue)pheromone=new PheromoneFemelle(maFourmi.getEtat().getFourmi()) ;
	          
	          this.listePheromones.put(maFourmi.getEtat().getFourmi().getFourmiliere(),pheromone );
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
			//addPheromone(0);
		}
	}
}
