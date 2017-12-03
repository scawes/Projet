package fourmi.tache;

import fourmi.Fourmi;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	int NOMBRE_VOISIN = 4;
	
	Case emplacement;
	Case emplacementPrecedent;
	
	public Chasser(Fourmi fourmi) {
		super(fourmi);
		emplacement = Territoire.getInstance().getCase(fourmi.getPosition());
	}

	void deplacer(){
		int positionX = fourmi.getPosition().getX();
		int positionY = fourmi.getPosition().getY();
		Case [] listeVoisin = new Case[4];
		listeVoisin[0]  = Territoire.getInstance().getCase(new Position(positionX+1,positionY));
		listeVoisin[1]  = Territoire.getInstance().getCase(new Position(positionX-1,positionY));
		listeVoisin[2]  = Territoire.getInstance().getCase(new Position(positionX,positionY+1));
		listeVoisin[3]  = Territoire.getInstance().getCase(new Position(positionX,positionY-1));
		
		emplacementPrecedent=emplacement;
		emplacementPrecedent.supprimerEntite(fourmi);
		emplacement=nextCase(listeVoisin);
		emplacement.setPheromone(getIndexFourmiliere());
		emplacement.ajouterEntite(fourmi);
		fourmi.setPosition(emplacement.getPosition());
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
		return null;
		
	}
	
	int getIndexFourmiliere(){
		return Territoire.getInstance().getFourmiliere().indexOf(fourmi.getFourmiliere())+1;
	}
	
	int importanceCase(Case caseTest){
		if(emplacementPrecedent.equals(caseTest))return 1;
		if(caseTest.getPheromone()==getIndexFourmiliere())return 10;
		if(caseTest.getPheromone()==-2)return 0;
		
		
		return 100;
	}

	@Override
	public void evenement() {
		deplacer();
	}
	
}