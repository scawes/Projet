package fourmi.role;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Reine extends Role implements Trace {

	int delaisPonte;
	
	public Reine(Fourmi fourmi) {
		super(fourmi);
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
		fourmi.getFourmiliere().ajouterFourmi(new Fourmi(fourmi.getFourmiliere(),fourmi.getPosition()));
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
