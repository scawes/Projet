package fourmi;

import territoire.Case;
import territoire.Position;

public class Deplacement {

	int NOMBRE_VOISIN = 4;
	
	Case emplacement;
	Case emplacementPrecedent;
	Fourmi fourmi;
	
	public Deplacement(Fourmi fourmi) {
		this.fourmi=fourmi;
		emplacement = this.fourmi.getFourmiliere().getTerritoire().
				getCase(fourmi.getPosition());
		emplacementPrecedent=emplacement;
	}
	
	public void changerCase(Case nouvellePosition){
		emplacementPrecedent=emplacement;
		emplacementPrecedent.supprimerEntite(fourmi);
		emplacement=nouvellePosition;
		//emplacement.addPheromone(fourmi.);
		emplacement.ajouterEntite(fourmi);
		fourmi.setPosition(emplacement.getPosition());
	}
	
	public Case[] getVoisin(){
		int positionX = fourmi.getPosition().getX();
		int positionY = fourmi.getPosition().getY();
		Case [] listeVoisin = new Case[4];
		listeVoisin[0]  = fourmi.getFourmiliere().getTerritoire().getCase(new Position(positionX+1,positionY));
		listeVoisin[1]  = fourmi.getFourmiliere().getTerritoire().getCase(new Position(positionX-1,positionY));
		listeVoisin[2]  = fourmi.getFourmiliere().getTerritoire().getCase(new Position(positionX,positionY+1));
		listeVoisin[3]  = fourmi.getFourmiliere().getTerritoire().getCase(new Position(positionX,positionY-1));
		return listeVoisin;
		//changerCase(nextCase(listeVoisin));
	}
	
	public Position getEmplacement() {
		return emplacement.getPosition();
	}
	
	public Position getEmplacementPrecedent() {
		return emplacementPrecedent.getPosition();
	}
}
