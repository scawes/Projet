package fourmi.etat;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Oeuf extends Etat implements Trace{


	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(3);
	}

	
	
	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		this.decrementDureeDeVie();
		if(this.getDureeDeVie()<0) {
			fourmi.evolution(new Larve(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
