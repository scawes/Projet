package territoire.zone.deplacement;

import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.zone.Position;

public class DeplacementFourmi extends Deplacement {

	Fourmi fourmi;

	public DeplacementFourmi(Fourmi fourmi, Position position) {
		this.fourmi = fourmi;
		emplacement = position;
		emplacementPrecedent = emplacement;
		changerCase(position);
	}

	Territoire getTerritoire() {
		return fourmi.getFourmiliere().getTerritoire();
	}

	public void changerCase(Position nouvellePosition) {
		emplacementPrecedent = emplacement;
		getTerritoire().getCase(emplacementPrecedent).supprimerEntite(fourmi);
		emplacement = nouvellePosition;
		getTerritoire().getCase(emplacement).ajouterEntite(fourmi);
	}
}
