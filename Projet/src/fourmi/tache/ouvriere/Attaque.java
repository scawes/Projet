package fourmi.tache.ouvriere;

import fourmi.Fourmi;
import fourmi.role.Ouvriere;
import proie.Proie;
import proie.etat.Vivant;
import territoire.Territoire;
import territoire.zone.DeplacementFourmi;

public class Attaque extends TacheOuvriere {

	Proie proie;
	
	public Attaque(Ouvriere role,Proie proie) {
		super(role);
		this.proie=proie;
		Vivant vivant = (Vivant)proie.getEtat().getVivant();//actionFourmi(this);
		vivant.actionFourmi(this);
	}

	Territoire getTerritoire() {
		return getFourmi().getFourmiliere().getTerritoire();
	}
	
	Fourmi getFourmi() {
		return role.getEtat().getFourmi();
	}
	
	DeplacementFourmi getDeplacement() {
		return getFourmi().getDeplacement();
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	public double getPoid() {
		return getFourmi().getPoid();
	}
	
	public void phaseAttaque() {
		getTerritoire().getCase(getDeplacement().getEmplacement()).addPheromone(role);
	}
	
	
	public void fuiteProie(){
		role.getTache();
		
	}
	

	@Override
	public void evenement() {
		phaseAttaque();
	}
	
}