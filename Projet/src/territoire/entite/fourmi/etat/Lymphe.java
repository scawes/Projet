package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Lymphe extends Etat implements Trace{

	Lymphe(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(20);
		
		
	}

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		this.decrementDureeDeVie();
		if(this.getDureeDeVie()<0) {
			fourmi.evolution(new Adulte(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
