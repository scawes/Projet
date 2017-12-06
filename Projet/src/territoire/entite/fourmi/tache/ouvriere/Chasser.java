package territoire.entite.fourmi.tache.ouvriere;

import java.util.List;

import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.MortProie;
import territoire.zone.Position;
import territoire.zone.deplacement.DeplacementFourmi;

public class Chasser extends TacheOuvriere {

	final int NOMBRE_VOISIN = 4;
	final int DISTANCE_MAX = 200;
	
	public Chasser(Ouvriere role) {
		super(role);
	}

	Territoire getTerritoire() {
		return getFourmi().getFourmiliere().getTerritoire();
	}
	
	Fourmi getFourmi() {
		return role.getEtat().getFourmi();
	}
	
	DeplacementFourmi getDeplacement() {
		return getFourmi().getDeplacement();
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	public void phaseChasse() {
		if(voirProie()) {
			return;
		};
		Position caseSuivante =nextCase(getDeplacement().getVoisin());
		getDeplacement().changerCase(caseSuivante);
		getTerritoire().getCase(caseSuivante).addPheromone(getFourmi().getFourmiliere());
		voirProie();
		
	}
	
	public boolean voirProie() {
		List<Proie> listeProie = getTerritoire().getCase(getDeplacement().getEmplacement()).getProies();
		if(listeProie.size()>0) {
			for(Proie proie : listeProie) {
				if(proie.isVivant()==true) {
					role.tacheAttaque(proie);
					return true;
				} else {
					for(Position positionFourmiliere : getFourmi().getFourmiliere().getPosition()){
						if(positionFourmiliere.equals(getDeplacement().getEmplacement())) {
							return false;
						}
					}
					if(((MortProie)proie.getEtat()).estPrise()){
						return false;
					}
					role.tacheRamenerProie((MortProie) proie.getEtat());
					return true;
					
					
				}
			}
		}
		return false;
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
		if(pheromone>20)return 50;
		if(pheromone<20)return 20;
		return pheromone;
	}

	@Override
	public void evenement() {
		phaseChasse();
	}
	
}