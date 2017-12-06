package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Lymphe extends Etat implements Trace{

	private final int VIE_LYMPHE = 20;
	
	Lymphe(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(VIE_LYMPHE);
	}

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		vieillir();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

	@Override
	void vieillir() {
		if(dureeDeVie.decrementer()) {
			fourmi.evolution(new Adulte(fourmi));
		}
	}

}
