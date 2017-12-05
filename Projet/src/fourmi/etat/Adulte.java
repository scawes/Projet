package fourmi.etat;

import fourmi.Fourmi;
import fourmi.role.Role;
import rapports.Rapport;
import rapports.Trace;
import territoire.Case;

public class Adulte extends Etat implements Trace {

	Role role;

	
	public Adulte(Fourmi fourmi) {
		super(fourmi);

		vie=200;
		appetit = 0;
		role=Role.getRole(this);//ajouter cette methode danss adulte
		timerNourriture = 60;
	}
	
	Case getCase() {
	  return this.fourmi.getFourmiliere().getTerritoire().getCase(this.fourmi.getDeplacement().getEmplacement());
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
	  for (int i = 0 ; i< this.fourmi.getFourmiliere().getPosition().size(); i++) {
	    if(this.fourmi.getDeplacement().getEmplacement().equals(this.fourmi.getFourmiliere().getPosition().get(i))) {
	      while(j <this.getCase().getProies().size() && appetit !=0) {
	        if(appetit>this.getCase().getProies().get(j).getPoid()) {
	          nourriture = this.getCase().getProies().get(j).getPoid();
	          this.getCase().getProies().get(j).decrementePoid(nourriture);
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
