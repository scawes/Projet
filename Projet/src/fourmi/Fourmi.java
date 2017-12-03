package fourmi;

import fourmi.etat.Etat;
import fourmi.etat.Oeuf;
import fourmiliere.Fourmiliere;
import rapports.Rapport;
import rapports.Trace;
import territoire.Position;

public class Fourmi implements Trace {
	
	Fourmiliere fourmiliere;
	Etat etat;
	Position position;

	public Fourmi(Fourmiliere fourmiliere,Position position) {
		etat=new Oeuf(this);
		setPosition(position);
		this.fourmiliere=fourmiliere;
	}
	
	public void setPosition(Position position){
		this.position=position;
	}
	
	public void setFourmiliere(Fourmiliere fourmiliere) {
		this.fourmiliere=fourmiliere;
	}
	
	public Fourmiliere getFourmiliere() {
		return fourmiliere;
	}
	
	public Position getPosition() {
		return position;
	}

	public void evenement() {
		etat.evenement();
	}
	
	public void evolution(Etat nouvelEtat) {
		etat=nouvelEtat;
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		etat.trace(rapport);
	}
	
}
