package Vue;

import rapports.Rapport;
import rapports.RapportGraphique;
import rapports.RapportTrace;
import simulateur.Simulateur;
import territoire.Territoire;

public class MiseAJour {
	
	public static void trace(){
		Rapport rapport = new RapportTrace();
		Territoire.getInstance().trace(rapport);
		System.out.println(rapport);
		
	}
	
	public static void graphique(){
		Simulateur.getInstance().suspend();
		
		
		GestionVue.getInstance().clear();
		Rapport rapport = new RapportGraphique();
		Territoire.getInstance().trace(rapport);
		Simulateur.getInstance().resume();
		
	}

}
