package fourmi.role;

import fourmi.Fourmi;
import rapports.Trace;

public abstract class Role implements Trace{

	Fourmi fourmi;
	
	public Role(Fourmi fourmi) {
		this.fourmi=fourmi;
	}
	
	public static Role getRole(Fourmi fourmi) {
		if(fourmi.getFourmiliere()==null)
		return new Reine(fourmi);
		else return new Ouvriere(fourmi);
	}

	public abstract void evenement();

}
