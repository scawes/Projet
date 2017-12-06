package territoire.zone;

import proie.Proie;
import territoire.Territoire;

public class DeplacementProie extends Deplacement {

	Proie proie;
	
	public DeplacementProie(Proie proie,Position position) {
		this.proie=proie;
		emplacement = position;
		emplacementPrecedent=emplacement;
		changerCase(position);
	}
	
	@Override
	Territoire getTerritoire() {
		return proie.getTerritoire();
	}

	@Override
	public void changerCase(Position nouvellePosition) {
		emplacementPrecedent=emplacement;
		getTerritoire().getCase(emplacementPrecedent).supprimerEntite(proie);
		emplacement=nouvellePosition;
		getTerritoire().getCase(emplacement).ajouterEntite(proie);
	}

}
