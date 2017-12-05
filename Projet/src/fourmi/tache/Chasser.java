package fourmi.tache;

import fourmi.Deplacement;
import fourmi.Fourmi;
import fourmi.role.Role;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	final int NOMBRE_VOISIN = 4;
	
	public Chasser(Role role) {
		super(role);
	}

	Territoire getTerritoire() {
		return getFourmi().getFourmiliere().getTerritoire();
	}
	
	Fourmi getFourmi() {
		return role.getEtat().getFourmi();
	}
	
	Deplacement getDeplacement() {
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
		//if(positionTest.getX()<0 || positionTest.getY()<0)return 0; //fixe
		if(positionTest.equals(getDeplacement().getEmplacementPrecedent()))return 1;	//pr�f�rence aucun retour en arriere
		int pheromone = getTerritoire().getCase(positionTest).getPheromone(role);
		//option case inataignable
		if(pheromone==-2)return 0;
		
		//case par defaut 
		return pheromone;
	}

	@Override
	public void evenement() {
		phaseChasse();
	}
	
}