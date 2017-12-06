package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Oeuf extends Etat implements Trace{

	private final int VIE_OEUF = 3;
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(VIE_OEUF);
	}

	
	/**
	 * Cette methode déclenche l'eclosion de l'oeuf
	 */
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
		// TODO Auto-generated method stub
		if(dureeDeVie.decrementer()) {
			fourmi.evolution(new Larve(fourmi));
		}
	}

}
