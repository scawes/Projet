package proie.etat.tache;

import proie.etat.Etat;
import territoire.Territoire;
import territoire.zone.DeplacementFourmi;
import territoire.zone.Position;

public class Deplacer extends Tache {

	final int NOMBRE_VOISIN = 4;
	final int DISTANCE_MAX = 200;
	
	public Deplacer(Etat etat) {
		super(etat);
	}

	Territoire getTerritoire() {
		return etat.getFourmiliere().getTerritoire();
	}
	
	Fourmi getFourmi() {
		return etat.getFourmi();
	}
	
	DeplacementFourmi getDeplacement() {
		return getFourmi().getDeplacement();
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	public void phaseChasse() {
		Position caseSuivante =nextCase(getDeplacement().getVoisin());
		getDeplacement().changerCase(caseSuivante);
		getTerritoire().getCase(caseSuivante).addPheromone(role);
	}
	
	
	Position nextCase(Position [] listeVoisin){
		int [] listeProbabilite = new int[NOMBRE_VOISIN];
		int total=0;
		
		for(int i=0;i<NOMBRE_VOISIN;i++){
			listeProbabilite[i] = importanceCase(listeVoisin[i]);
			total += listeProbabilite[i];
		}

		
		double random = Math.random()*total;
		
		int seuil=0;
		
		for(int i=0;i<NOMBRE_VOISIN;i++){
			if(random>seuil && random<listeProbabilite[i]+seuil){
				return listeVoisin[i];
			} else {
				seuil += listeProbabilite[i];
			}
		}
		return getDeplacement().getEmplacement();
		
	}
	
	
	
	int importanceCase(Position positionTest){
		if(positionTest.getX()>getFourmi().getFourmiliere().getPosition().get(0).getX()+DISTANCE_MAX)return 0; //fixe
		if(positionTest.getX()<getFourmi().getFourmiliere().getPosition().get(0).getX()-DISTANCE_MAX)return 0;
		if(positionTest.getY()>getFourmi().getFourmiliere().getPosition().get(0).getY()+DISTANCE_MAX)return 0;
		if(positionTest.getY()<getFourmi().getFourmiliere().getPosition().get(0).getY()-DISTANCE_MAX)return 0;
		if(positionTest.equals(getDeplacement().getEmplacementPrecedent()))return 10;	//pr�f�rence aucun retour en arriere
		int pheromone = getTerritoire().getCase(positionTest).getPheromone(role);
		//option case inataignable
		if(pheromone==-2)return 0;
		//case par defaut  
		if(pheromone<50)return 50;
		
		return pheromone;
	}

	@Override
	public void evenement() {
		phaseChasse();
	}
	
}