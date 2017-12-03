package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fourmi.Fourmi;
import fourmiliere.Fourmiliere;
import observeur.Evenement;
import observeur.Observeur;
import rapports.Rapport;
import rapports.RapportGraphique;
import rapports.RapportTrace;
import rapports.Trace;

public class Territoire implements Observeur,Trace{

	static Territoire territoire = new Territoire();
	HashMap<Position, Case> grille;
	List<Fourmiliere> listeFourmiliere;
	
	public static Territoire getInstance(){
		return territoire;
	}
	
	Territoire() {
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
	
	public Fourmiliere nouvelleFourmilliere(Fourmi reine){
		Fourmiliere fourmiliere = new Fourmiliere(reine);
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
		for(Position position : grille.keySet()){
			grille.get(position).trace(rapport);
		}
	}

	@Override
	public void receive(Evenement evt) {
		for(Fourmiliere fourmiliere : listeFourmiliere){
			fourmiliere.evenement();;
		}
	}
}
