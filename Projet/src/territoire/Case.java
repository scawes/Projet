package territoire;

import rapports.Rapport;
import rapports.Trace;

public class Case implements Trace{

	Position position;
	
	Case(Position position){
		this.position=position;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}
}
