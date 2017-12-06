package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Vue.Gestionnaire;
import fourmiliere.Fourmiliere;
import observeur.Evenement;
import observeur.Observeur;
import proie.Proie;
import rapports.Rapport;
import rapports.Trace;
import territoire.zone.Case;
import territoire.zone.Position;

public class Territoire implements Observeur,Trace{

	Map<Integer, Map<Integer,Case>> grilleX;
	List<Fourmiliere> listeFourmiliere;
	List<Proie> listeProie;
	Gestionnaire gestionnaire;
	
	
	public Territoire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
		grilleX= new HashMap<Integer, Map<Integer,Case>>();
		listeFourmiliere=new ArrayList<Fourmiliere>();
		listeProie=new ArrayList<Proie>();
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
	
	
	
	public Fourmiliere nouvelleFourmilliere(Position position){
		Fourmiliere fourmiliere = new Fourmiliere(position,this);
		listeFourmiliere.add(fourmiliere);
		return fourmiliere;
	}
	
	public List<Fourmiliere> getFourmiliere(){
		return listeFourmiliere;
	}
	
	public Proie nouvelleProie(){
		
		Position positionRandom = new Position(20, 20);
		
		/*int randomKeySet = (int) (grilleX.keySet().size()*Math.random());
		Set<Integer> randomInt =grilleX.keySet();
		Object[] test = randomInt.toArray();
		List<Integer> test2 = new ArrayList<Integer>();
		test2.addAll(randomInt);
		System.out.println(test);
		/*Map<Integer, Case> getRandomX = grilleX.get(randomInt);
		int getRandomY = (int) (Math.random()* grilleX.get(getRandomX).keySet().size());
		Position positionRandom = new Position(getRandomX, getRandomY);
		
		return null;*/
		Proie proie = new Proie(this,positionRandom);
		listeProie.add(proie);
		return proie;
	}
	
	public List<Proie> getProie(){
		return listeProie;
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
		nouvelleProie();
		for(Fourmiliere fourmiliere : listeFourmiliere){
			fourmiliere.evenement();
		}
		for(Integer positionX : grilleX.keySet()){
			for(Integer PositionY:grilleX.get(positionX).keySet()){
				grilleX.get(positionX).get(PositionY).evenement();
			}
		}
	}
}
