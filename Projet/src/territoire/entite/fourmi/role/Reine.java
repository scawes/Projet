package territoire.entite.fourmi.role;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Etat;

public class Reine extends Role implements Trace {

	double delaisPonte;
	
	private final double DELAIS_PONTE = 5;
	
	private final double dureeDeVieMin = 4000;
	private final double dureeDeVieMax = 6000;
	//double poids;
	
	
	public Reine(Etat etat) {
		super(etat);
		delaisPonte=DELAIS_PONTE;
		
		int dureeDeVie = ((int)(dureeDeVieMin + Math.random()* ((dureeDeVieMax-dureeDeVieMin)+1)));
		etat.setDureeDeVie(dureeDeVie);
		etat.setPoid(15);
		
	
	}

	@Override
	public	void evenement() {
		delaisPonte--;
		if(delaisPonte<0) {
			ponte();
			delaisPonte=5;
		}
		ajouterPheromone();
	}

	private void ponte() {
		this.getFourmiliere().ajouterFourmi(
				new Fourmi(this.getFourmiliere(),etat.getFourmi().getDeplacement().getEmplacement()));
	}
	
	void ajouterPheromone(){
		getFourmiliere().getTerritoire().getCase(getEtat().getFourmi().getDeplacement().getEmplacement()).addPheromone(getFourmiliere());
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
