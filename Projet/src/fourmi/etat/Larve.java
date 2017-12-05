package fourmi.etat;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Larve extends Etat implements Trace{
  
  

	Larve(Fourmi fourmi) {
		super(fourmi);
		this.fourmi.setDureeDeVie(10);
		appetit =0;
		
	}
	
	

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		this.decrementDureeDeVie();
		if(this.getDureeDeVie()<0) {
			fourmi.evolution(new Lymphe(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
