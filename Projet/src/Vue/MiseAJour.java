package Vue;

import observeur.Evenement;
import observeur.Observeur;
import rapports.Rapport;
import rapports.RapportGraphique;
import territoire.Territoire;

public class MiseAJour implements Observeur {

	@Override
	public void receive(Evenement evt) {
		//Controleur.clear();
		Rapport rapport = new RapportGraphique();
		Territoire.getInstance().trace(rapport);
		System.out.println(rapport);
	}

}
