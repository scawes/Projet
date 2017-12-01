package main;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import fourmiliere.Fourmiliere;
import simulateur.Simulateur;

public class MainTestSimulateurv {

	public static void main(String[] args) {
		
		Fourmi reine = new Fourmi(null);
		reine.evolution(new Adulte(reine));
		
		Fourmiliere fourmiliere = new Fourmiliere(reine);
		Simulateur sim = new Simulateur(fourmiliere);
		
		sim.start();

	}

}
