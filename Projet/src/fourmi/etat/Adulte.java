package fourmi.etat;

import java.util.List;

import fourmi.Fourmi;
import fourmi.role.Role;
import proie.Proie;
import rapports.Rapport;
import rapports.Trace;
import territoire.Case;
import territoire.Position;

public class Adulte extends Etat implements Trace {

	Role role;

	
	public Adulte(Fourmi fourmi) {
		super(fourmi);

		
		appetit = 0;
		role=Role.getRole(this);//ajouter cette methode danss adulte
		timerNourriture = 60;
	}
	
	Case getCase() {
	  return this.fourmi.getFourmiliere().getTerritoire().getCase(this.fourmi.getDeplacement().getEmplacement());
	}
	
	Position getPosition() {
	  return this.fourmi.getDeplacement().getEmplacement();
	}
	
	List<Position> getPositionsFourmiliere(){
	  return this.fourmi.getFourmiliere().getPosition();
	}

	List<Proie> getProiePresnte(){
	  return this.getCase().getProies();
	}
	@Override
	public	void evenement() {

		role.evenement();
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		role.trace(rapport);
	}
	
	public void incrementeAppetit() {
	  
	  if(this.timerNourriture ==0) {
	    appetit += (this.fourmi.getPoid()/180);
	    timerNourriture =60;
	  }
	  else {
	    this.timerNourriture--;
	  }
	}
	
	public void manger() {
	  int j =0;
	  double nourriture;
	  for (int i = 0 ; i< this.getPositionsFourmiliere().size(); i++) {
	    if(this.getPosition().equals(this.getPositionsFourmiliere().get(i))) {
	      while(j <this.getProiePresnte().size() && appetit !=0) {
	        if(appetit>this.getProiePresnte().get(j).getPoid()) {
	          nourriture = this.getProiePresnte().get(j).getPoid();
	          this.getProiePresnte().get(j).decrementePoid(nourriture);
	          appetit -=nourriture;
	        }
	        else {
	          nourriture = appetit;
	          this.getCase().getProies().get(j).decrementePoid(nourriture);
                  appetit -=nourriture;
	          
	        }
	      }
	    
	    }
	  }
	}

}
