package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Vue.Gestionnaire;
import fourmi.Fourmi;
import fourmiliere.Fourmiliere;
import observeur.Evenement;
import observeur.Observeur;
import rapports.Rapport;
import rapports.Trace;

public class Territoire implements Observeur,Trace{

	Map<Position, Case> grille;
	List<Fourmiliere> listeFourmiliere;
	Gestionnaire gestionnaire;
	
	
	public Territoire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
		grille= new HashMap<Position,Case>();
		listeFourmiliere=new ArrayList<Fourmiliere>();
	}
	
	
	public Case creerCase(Position nouvellePosition){
		Case nouvelleCase = new Case(nouvellePosition);
		grille.put(nouvellePosition, nouvelleCase);
		return nouvelleCase;
	}
	
	public Case getCase(Position position){

		for(Position key : grille.keySet()){
			if(key.equals(position)){
				return grille.get(key);
			}
		}
		return creerCase(position);
	}
	
	public void removeCase(Case maCase){
		grille.remove(maCase.getPosition());
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
		for(Iterator<Entry<Position, Case>> iterateur = grille.entrySet().iterator();iterateur.hasNext();){
			Map.Entry<Position, Case> emplacement = (Map.Entry<Position, Case>) iterateur.next();
			emplacement.getValue().trace(rapport);
		}
		/*for(Position position : grille.keySet()){
			grille.get(position).trace(rapport);
		}*/
	}

	@Override
	public void receive(Evenement evt) {
		for(Fourmiliere fourmiliere : listeFourmiliere){
			fourmiliere.evenement();;
		}
		Iterator<Entry<Position, Case>> iterateur = grille.entrySet().iterator();
		Map.Entry<Position, Case> emplacement  = (Map.Entry<Position, Case>) iterateur.next();
		Case temporaire = emplacement.getValue();
		while(iterateur.hasNext()){
			emplacement = (Map.Entry<Position, Case>) iterateur.next();
			temporaire.evenement();
			temporaire =  emplacement.getValue();
		}
		
		/*for(Iterator<Entry<Position, Case>> iterateur = grille.entrySet().iterator();iterateur.hasNext();){
			Map.Entry<Position, Case> emplacement = (Map.Entry<Position, Case>) iterateur.next();
			emplacement.getValue().evenement();
			iterateur.
		}*/
	}
}
