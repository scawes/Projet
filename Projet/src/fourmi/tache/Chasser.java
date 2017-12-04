package fourmi.tache;

import fourmi.Fourmi;
import fourmi.role.Role;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	int NOMBRE_VOISIN = 4;
	
	Case emplacement;
	Case emplacementPrecedent;
	
	public Chasser(Role role) {
		super(role);
		emplacement = Territoire.getInstance().getCase(fourmi.getPosition());
		emplacementPrecedent=emplacement;
	}

	public void changerCase(Case nouvellePosition){
		emplacementPrecedent=emplacement;
		emplacementPrecedent.supprimerEntite(fourmi);
		emplacement=nouvellePosition;
		emplacement.setPheromone(getIndexFourmiliere());
		emplacement.ajouterEntite(fourmi);
		fourmi.setPosition(emplacement.getPosition());
	}
	
	void deplacer(){
		int positionX = fourmi.getPosition().getX();
		int positionY = fourmi.getPosition().getY();
		Case [] listeVoisin = new Case[4];
		listeVoisin[0]  = Territoire.getInstance().getCase(new Position(positionX+1,positionY));
		listeVoisin[1]  = Territoire.getInstance().getCase(new Position(positionX-1,positionY));
		listeVoisin[2]  = Territoire.getInstance().getCase(new Position(positionX,positionY+1));
		listeVoisin[3]  = Territoire.getInstance().getCase(new Position(positionX,positionY-1));
		
		changerCase(nextCase(listeVoisin));
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
		return Territoire.getInstance().getFourmiliere().indexOf(fourmi.getFourmiliere())+1;
	}
	
	int importanceCase(Case caseTest){
		if(caseTest.getPosition().getX()<0 || caseTest.getPosition().getY()<0)return 0; //fixe
		if(caseTest.equals(emplacementPrecedent))return 1;	//préférence aucun retour en arriere
		
		if(caseTest.getPheromone()==getIndexFourmiliere()){	//préférence suivre phéromone
			return 3;
		}
		//préférence a aller tout droit
		if(emplacementPrecedent.getPosition().getX()-emplacement.getPosition().getX()== emplacement.getPosition().getX()-caseTest.getPosition().getX() ||
				emplacementPrecedent.getPosition().getY()-emplacement.getPosition().getY()== emplacement.getPosition().getY()-caseTest.getPosition().getY() ){
			return 2;
		}
		//option case inataignable
		if(caseTest.getPheromone()==-2)return 0;
		
		//case par defaut
		return 1;
	}

	@Override
	public void evenement() {
		deplacer();
	}
	
}