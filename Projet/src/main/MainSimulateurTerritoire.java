package main;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import simulateur.Simulateur;
import territoire.Position;
import territoire.Territoire;

public class MainSimulateurTerritoire {

	public static void main(String[] args) {
		
		Fourmi reine = new Fourmi(null,new Position(0, 0));
		reine.evolution(new Adulte(reine));
		
		Territoire.getInstance().nouvelleFourmilliere(reine);
		
		Simulateur sim = new Simulateur(Territoire.getInstance());
		sim.start();

	}

}
