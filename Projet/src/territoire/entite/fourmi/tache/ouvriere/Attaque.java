package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.Vivant;

public class Attaque extends TacheOuvriere {

	Proie proie;
	
	public Attaque(Ouvriere role,Proie proie) {
		super(role);
		this.proie=proie;
		Vivant vivant = (Vivant)proie.getEtat().getVivant();//actionFourmi(this);
		vivant.actionFourmi(this);
	}

	
	
	public double getPoid() {
		return role.getEtat().getPoid();
	}
	
	public void phaseAttaque() {
		getTerritoire().getCase(getDeplacement().getEmplacement()).addPheromone(getFourmi().getFourmiliere());
		if(!proie.getDeplacement().getEmplacement().equals(getDeplacement().getEmplacement())){
			fuiteProie();
		}
	}
	
	
	public void fuiteProie(){
		role.getTache();
		
	}
	

	@Override
	public void evenement() {
		phaseAttaque();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
	
}