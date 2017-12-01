package territoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fourmi.Fourmi;
import fourmiliere.Fourmiliere;
import rapports.Rapport;
import rapports.Trace;

public class Territoire implements Trace{

	static Territoire territoire = new Territoire();
	Map<Position, Case> grille;
	List<Fourmiliere> listeFourmiliere;
	
	static Territoire getInstance(){
		return territoire;
	}
	
	Territoire() {
		grille= new HashMap<Position,Case>();
		listeFourmiliere=new ArrayList<Fourmiliere>();
		//creerCase(new Position(0, 0));
	}
	
	public Case creerCase(Position nouvellePosition){
		Case nouvelleCase = new Case(nouvellePosition);
		grille.put(nouvellePosition, nouvelleCase);
		return nouvelleCase;
	}
	
	public Case getCase(Position position){
		Case resultat = grille.get(position);
		if(resultat == null){
			resultat = creerCase(position);
		}
		return resultat;
	}
	
	public Fourmiliere nouvelleFourmilliere(Fourmi reine){
		Fourmiliere fourmiliere = new Fourmiliere(reine);
		listeFourmiliere.add(fourmiliere);
		return fourmiliere;
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
}
