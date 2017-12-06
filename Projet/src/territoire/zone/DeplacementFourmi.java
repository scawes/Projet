package territoire.zone;

import fourmi.Fourmi;
import territoire.Territoire;

public class DeplacementFourmi extends Deplacement {

	
	Fourmi fourmi;
	
	public DeplacementFourmi(Fourmi fourmi,Position position) {
		this.fourmi=fourmi;
		emplacement = position;
		emplacementPrecedent=emplacement;
		changerCase(position);
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
}
