package territoire.fourmiliere;

import java.util.ArrayList;
import java.util.List;

import rapports.Rapport;
import rapports.Trace;
import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.zone.Position;

public class Fourmiliere implements Trace {

	List<Position> surface;// represente la surface sur laquelle s'etend la fourmiliere
	List<Fourmi> population;

	Territoire territoire;

	public Fourmiliere(Position position, Territoire territoire) {
		this.territoire = territoire;
		population = new ArrayList<Fourmi>();
		surface = new ArrayList<Position>();
		// reine.setFourmiliere(this);

		// ajouterFourmi(reine);
		extentionConstruction(position);

	}

	public Territoire getTerritoire() {
		return territoire;
	}

	public void ajouterFourmi(Fourmi fourmi) {
		population.add(fourmi);
	}

	public List<Position> getPosition() {
		return surface;
	}

	public void evenement() {
		for (int i = 0; i < population.size(); i++) {
			population.get(i).evenement();
		}
	}

	public void extentionConstruction(Position position) {
		surface.add(position);
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		for (Fourmi fourmi : population) {
			fourmi.trace(rapport);
		}
	}

	public List<Fourmi> getListeFourmi() {
		// TODO Auto-generated method stub
		return population;
	}

}
