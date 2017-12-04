package fourmi.role;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Reine extends Role implements Trace {

	int delaisPonte;
	int dureeDeVie;
	private static int dureeDeVieMin = 4;
	private static int dureeDeVieMax = 10;
	
	
	public Reine(Fourmi fourmi) {
		super(fourmi);
		delaisPonte=5;
		dureeDeVie = (dureeDeVieMin + (int)Math.random()* ((dureeDeVieMax-dureeDeVieMin)+1));
		
	
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
	
	private void mortNaturelle() {
	  dureeDeVie--;
	  if(dureeDeVie < 0 ) {
	    
	  }
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
