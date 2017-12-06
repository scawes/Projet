package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Etat;

public class Reine extends Role implements Trace {

	int delaisPonte;
	
	private static double dureeDeVieMin = 4;
	private static double dureeDeVieMax = 10;
	//double poids;
	
	
	public Reine(Etat etat) {
		super(etat);
		delaisPonte=5;
		
		double dureeDeVie = (dureeDeVieMin + (double)Math.random()* ((dureeDeVieMax-dureeDeVieMin)+1));
		this.setDureeDeVie(dureeDeVie);
		this.setPoid(15);
		
	
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
		this.getFourmiliere().ajouterFourmi(
				new Fourmi(this.getFourmiliere(),etat.getFourmi().getDeplacement().getEmplacement()));
	}
	


	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
