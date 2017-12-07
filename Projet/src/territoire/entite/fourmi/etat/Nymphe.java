package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Nymphe extends Etat implements Trace{
	
	/*
	 * Attributs
	 */

	private final int VIE_LYMPHE = 20;
	
	/**
	 * Constructeur de l'etat Nymphe.
	 * @param fourmi l'etat connait sa fourmi
	 */
	Nymphe(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(VIE_LYMPHE);
		setPoid(-1);
	}
	
	/*
	 * Methodes
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
		if(dureeDeVie.decrementer()) {
			fourmi.evolution(new Adulte(fourmi));
		}
	}

}
