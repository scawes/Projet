package territoire.entite.fourmi.tache.ouvriere;

import rapports.Rapport;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.proie.Proie;
import territoire.zone.Position;

public class Manger extends TacheOuvriere {

	public Manger(Ouvriere role) {
		super(role);
	}

	Fourmi chercherFourmiCase(Position position){
		for(Fourmi fourmi : getTerritoire().getCase(position).getEntite()){
			if (fourmi.getAppetit().besoin()>0){
				return fourmi;
			}
		}
		return null;
	}
	
	Fourmi chercherFourmi(){
		Fourmi fourmi;
		for(Position position : getFourmi().getFourmiliere().getPosition()){
			fourmi = chercherFourmiCase(position);
			if(fourmi!=null)return fourmi;
		}
		return null;
	}
	
	Proie chercherProieCase(Position position){
		for(Proie proie : getTerritoire().getCase(position).getProies()){
			if (!proie.isVivant()){
				if (proie.getPoid()>0){
					return proie;
				}
			}
		}
		return null;
	}
	
	Proie chercherProie(){
		Proie proie;
		for(Position position : getFourmi().getFourmiliere().getPosition()){
			proie = chercherProieCase(position);
			if(proie!=null)return proie;
		}
		return null;
	}
	
	void nourrir(){
		Fourmi fourmi = chercherFourmi();
		Proie proie = chercherProie();
		if(fourmi != null && proie != null){
			
			double besoin = fourmi.getAppetit().besoin();
			double donner = proie.decrementePoid(besoin);
			fourmi.getAppetit().manger(donner);
			
			role.getTache();
			return;
		}
		role.getChasse();
		
	}
	
	void phaseManger(){
		nourrir();
	}
	
	@Override
	public void evenement() {
		phaseManger();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
	
}
