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
		
		role=Role.getRole(fourmi);
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

}
