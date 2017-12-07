package territoire.zone.deplacement;

import territoire.Territoire;
import territoire.zone.Position;

public abstract class Deplacement {

	int NOMBRE_VOISIN = 4;

	Position emplacement;
	Position emplacementPrecedent;

	public Position[] getVoisin() {
		int positionX = emplacement.getX();
		int positionY = emplacement.getY();
		Position[] listeVoisin = new Position[4];
		listeVoisin[0] = new Position(positionX + 1, positionY);
		listeVoisin[1] = new Position(positionX - 1, positionY);
		listeVoisin[2] = new Position(positionX, positionY + 1);
		listeVoisin[3] = new Position(positionX, positionY - 1);
		return listeVoisin;
	}

	public Position getEmplacement() {
		return emplacement;
	}

	public Position getEmplacementPrecedent() {
		return emplacementPrecedent;
	}

	abstract Territoire getTerritoire();

	abstract public void changerCase(Position nouvellePosition);

}
