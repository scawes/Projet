package fourmi.tache;

import fourmi.role.Role;
import territoire.Case;

public class RetourFourmiliere extends Tache{

	public RetourFourmiliere(Role role) {
		super(role);
	}
	
	public Case getNextCase() {
		
		return null;
	}

	@Override
	public void evenement() {

		
	}

}
