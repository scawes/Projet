package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Larve extends Etat implements Trace{
	
	/*
	 * Attributs
	 */
  
	private final int VIE_LARVE = 150;
	private final double POID = 6;
	
	/**
	 * Constructeur de l'etat Larve.
	 * @param fourmi l'etat connait sa fourmi
	 */
	Larve(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(VIE_LARVE);
		setPoid(POID);
		getFourmi().setAppetit(POID);
		
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
			fourmi.evolution(new Nymphe(fourmi));
		}
	}

}
