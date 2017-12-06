package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.zone.Position;

public class Manger extends TacheOuvriere {

	public Manger(Ouvriere role) {
		super(role);
		// TODO Auto-generated constructor stub
	}

	void chercherFourmi(Position position){
		
	}
	
	void phaseManger(){
		
	}
	
	@Override
	public void evenement() {
		phaseManger();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
	
}
