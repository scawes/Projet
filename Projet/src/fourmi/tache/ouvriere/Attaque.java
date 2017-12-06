package fourmi.tache.ouvriere;

import fourmi.Fourmi;
import fourmi.role.Ouvriere;
import proie.Proie;
import territoire.Territoire;
import territoire.zone.DeplacementFourmi;

public class Attaque extends TacheOuvriere {

	Proie proie;
	
	public Attaque(Ouvriere role,Proie proie) {
		super(role);
		this.proie=proie;
		proie.getEtat().actionFourmi(this);
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