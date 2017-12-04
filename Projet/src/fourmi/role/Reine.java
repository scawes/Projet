package fourmi.role;

import fourmi.Fourmi;
import fourmi.etat.Etat;
import rapports.Rapport;
import rapports.Trace;

public class Reine extends Role implements Trace {

	int delaisPonte;
	
	public Reine(Etat etat) {
		super(etat);
		delaisPonte=5;
	}

	@Override
	public	void evenement() {
		delaisPonte--;
		if(delaisPonte<0) {
			ponte();
			delaisPonte=5;
		}
	}

	private void ponte() {
		etat.getFourmi().getFourmiliere().ajouterFourmi(new Fourmi(etat.getFourmi().getFourmiliere(),etat.getFourmi().getPosition()));
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
