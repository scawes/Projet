package territoire.entite.fourmi.tache.ouvriere;

import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.Vivant;
import territoire.zone.deplacement.DeplacementFourmi;

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
	
}