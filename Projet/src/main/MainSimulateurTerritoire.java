package main;

import Vue.LanceurVue;
import simulateur.Simulateur;

public class MainSimulateurTerritoire {

	public static void main(String[] args) {
		
		/*Fourmi reine = new Fourmi(null,new Position(40, 30));
		reine.evolution(new Adulte(reine));
		Territoire.getInstance().getCase(reine.getPosition());
		
		//Territoire.getInstance().getCase(new Position(14, 15)).setPheromone(-2);
		//Territoire.getInstance().getCase(new Position(14, 14)).setPheromone(-2);
		
		Territoire.getInstance().nouvelleFourmilliere(reine);
		
		Simulateur.getInstance().record(TimeChange.class.getName(), Territoire.getInstance());
		*/
		//Simulateur.getInstance().start();

		
		LanceurVue.getVue().lancer(args);
		
	}

}
