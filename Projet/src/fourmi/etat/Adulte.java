package fourmi.etat;

import fourmi.Fourmi;
import fourmi.role.Role;
import rapports.Rapport;
import rapports.Trace;

public class Adulte extends Etat implements Trace {

	Role role;
	
	
	public Adulte(Fourmi fourmi) {
		super(fourmi);
		vie=200;
		
		role=Role.getRole(this);//ajouter cette methode danss adulte
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
	
	public void manger() {
	  for (int i = 0 ; i< this.fourmi.getFourmiliere().getPosition().size(); i++) {
	    if(this.fourmi.getDeplacement().getEmplacement().equals(this.fourmi.getFourmiliere().getPosition().get(i))) {
	      
	    
	    }
	  }
	}

}
