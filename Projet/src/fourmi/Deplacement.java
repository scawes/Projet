package fourmi;

import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Deplacement {

	int NOMBRE_VOISIN = 4;
	
	Position emplacement;
	Position emplacementPrecedent;
	Fourmi fourmi;
	
	public Deplacement(Fourmi fourmi,Position position) {
		this.fourmi=fourmi;
		emplacement = position;
		emplacementPrecedent=emplacement;
	}
	
	Territoire getTerritoire() {
		return fourmi.getFourmiliere().getTerritoire();
	}
	
	public void changerCase(Position nouvellePosition){
		emplacementPrecedent=emplacement;
		getTerritoire().getCase(emplacementPrecedent).supprimerEntite(fourmi);
		emplacement=nouvellePosition;
		getTerritoire().getCase(emplacement).ajouterEntite(fourmi);
	}
	
	public Position[] getVoisin(){
		int positionX = fourmi.getPosition().getX();
		int positionY = fourmi.getPosition().getY();
		Position [] listeVoisin = new Position[4];
		listeVoisin[0]  = new Position(positionX+1,positionY);
		listeVoisin[1]  = new Position(positionX-1,positionY);
		listeVoisin[2]  = new Position(positionX,positionY+1);
		listeVoisin[3]  = new Position(positionX,positionY-1);
		return listeVoisin;
	}
	
	public Position getEmplacement() {
		return emplacement;
	}
	
	public Position getEmplacementPrecedent() {
		return emplacementPrecedent;
	}
}
