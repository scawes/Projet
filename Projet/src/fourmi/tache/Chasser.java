package fourmi.tache;

import fourmi.Fourmi;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	Case emplacement;
	Case emplacementPrecedent;
	
	public Chasser(Fourmi fourmi) {
		super(fourmi);
		emplacement = Territoire.getInstance().getCase(fourmi.getPosition());
	}

	void deplacer(){
		int positionX = fourmi.getPosition().getX();
		int positionY = fourmi.getPosition().getY();
		Case VoisinDroite  = Territoire.getInstance().getCase(new Position(positionX+1,positionY));
		Case VoisinGauche  = Territoire.getInstance().getCase(new Position(positionX-1,positionY));
		Case VoisinHaut  = Territoire.getInstance().getCase(new Position(positionX,positionY+1));
		Case VoisinBas  = Territoire.getInstance().getCase(new Position(positionX,positionY-1));
		
		
	}
	
	int importanceCase(Case caseTest){
		if(caseTest.getPheromone())return 2;
		if(emplacementPrecedent.equals(caseTest))return 0;
		
		return 1;
	}
	
}
