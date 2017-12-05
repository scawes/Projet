package fourmi.tache;

import fourmi.Fourmi;
import fourmi.role.Role;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	int NOMBRE_VOISIN = 4;
	
	Territoire getTerritoire() {
		return role.getEtat().getFourmi().getFourmiliere().getTerritoire();
	}
	
	public Chasser(Role role) {
		super(role);
		
	}

	
	
	
	
	Case nextCase(Case [] listeVoisin){
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
		return emplacement;
		
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	int importanceCase(Case caseTest){
		if(caseTest.getPosition().getX()<0 || caseTest.getPosition().getY()<0)return 0; //fixe
		if(caseTest.equals(emplacementPrecedent))return 1;	//pr�f�rence aucun retour en arriere
		
		if(caseTest.getPheromone()==getIndexFourmiliere()){	//pr�f�rence suivre ph�romone
			return 3;
		}
		//pr�f�rence a aller tout droit
		if(emplacementPrecedent.getPosition().getX()-emplacement.getPosition().getX()== emplacement.getPosition().getX()-caseTest.getPosition().getX() ||
				emplacementPrecedent.getPosition().getY()-emplacement.getPosition().getY()== emplacement.getPosition().getY()-caseTest.getPosition().getY() ){
			return 2;
		}
		//option case inataignable
		if(caseTest.getPheromone()==-2)return 0;
		
		//case par defaut
		return 1;
	}
	
	int importanceCase2(Case caseTest){
		if(caseTest.getPosition().getX()<0 || caseTest.getPosition().getY()<0)return 0; //fixe
		if(caseTest.equals(emplacementPrecedent))return 1;	//pr�f�rence aucun retour en arriere
		
		//option case inataignable
		if(caseTest.getPheromone()==-2)return 0;
		
		//case par defaut
		return caseTest.getPheromone();
	}

	@Override
	public void evenement() {
		deplacer();
	}
	
}