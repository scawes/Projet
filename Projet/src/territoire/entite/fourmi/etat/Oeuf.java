package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Oeuf extends Etat implements Trace{
	
	/**
	 * Attributs
	 */

	private final int VIE_OEUF = 3;
	
	/**
	 * Constructeur de l'etat Oeuf.
	 * @param fourmi l'etat connait sa fourmi
	 */
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(VIE_OEUF);
		this.setPoid(-1);
	}
	
	/*
	 * Methodes
	 */

	@Override
	public void evenement() {
		vieillir();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}


	@Override
	void vieillir() {
		if(dureeDeVie.decrementer()) {
			fourmi.evolution(new Larve(fourmi));
		}
	}

}
