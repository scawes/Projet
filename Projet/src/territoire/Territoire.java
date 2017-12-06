package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Vue.Gestionnaire;
import fourmi.Fourmi;
import fourmiliere.Fourmiliere;
import observeur.Evenement;
import observeur.Observeur;
import rapports.Rapport;
import rapports.Trace;

public class Territoire implements Observeur,Trace{

	Map<Integer, Map<Integer,Case>> grilleX;
	List<Fourmiliere> listeFourmiliere;
	Gestionnaire gestionnaire;
	
	
	public Territoire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
		grilleX= new HashMap<Integer, Map<Integer,Case>>();
		listeFourmiliere=new ArrayList<Fourmiliere>();
	}
	
	
	
	
	public Case getCase(Position position){

		Map<Integer,Case> positionX = getX(position.getX());
		Case positionY =  getY(position,positionX);
		return positionY;
	}
	
	public Map<Integer,Case> getX(Integer positionX){

		for(Integer key : grilleX.keySet()){
			if(key.equals(positionX)){
				return grilleX.get(key);
			}
		}
		return creerX(positionX);
	}
	public Case getY(Position position ,Map<Integer,Case> grilleY){

		for(Integer key : grilleY.keySet()){
			if(key.equals(position.getY())){
				return grilleY.get(key);
			}
		}
		return creerY(position,grilleY);
	}
	
	public Map<Integer,Case> creerX(Integer positionX){
		grilleX.put(positionX, new HashMap<Integer,Case>());
		return grilleX.get(positionX);
	}
	
	public Case creerY(Position position,Map<Integer,Case> grilleY){
		grilleY.put(position.getY(), new Case(position,gestionnaire.getGestionVue()));
		return grilleY.get(position.getY());
	}
	
	
	
	public Fourmiliere nouvelleFourmilliere(Fourmi reine){
		Fourmiliere fourmiliere = new Fourmiliere(reine,this);
		listeFourmiliere.add(fourmiliere);
		return fourmiliere;
	}
	
	public List<Fourmiliere> getFourmiliere(){
		return listeFourmiliere;
	}

	
	
	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		for(Fourmiliere fourmiliere : listeFourmiliere){
			fourmiliere.trace(rapport);
		}
		for(Integer positionX : grilleX.keySet()){
			for(Integer PositionY:grilleX.get(positionX).keySet()){
				grilleX.get(positionX).get(PositionY).trace(rapport);
			}
		}
	}

	@Override
	public void receive(Evenement evt) {
		for(Fourmiliere fourmiliere : listeFourmiliere){
			fourmiliere.evenement();;
		}
		for(Integer positionX : grilleX.keySet()){
			for(Integer PositionY:grilleX.get(positionX).keySet()){
				grilleX.get(positionX).get(PositionY).evenement();
			}
		}
	}
}
