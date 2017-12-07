package gestionnaire;

import javafx.scene.canvas.Canvas;
import observeur.TimeChange;
import simulateur.Simulateur;
import territoire.Territoire;
import territoire.zone.Position;

public class Gestionnaire {

	Territoire territoire;
	Simulateur simulateur;
	GestionVue gestionVue;
	GestionRapport gestionRapport;
	
	public Gestionnaire(Canvas canvas) {
		simulateur =new Simulateur();
		territoire=new Territoire(this);
		
		getSimulateur().record(TimeChange.class.getName(), getTerritoire());
		gestionVue = new GestionVue(this,canvas);
		gestionRapport= new GestionRapport(this);
		
	}
	
	public Territoire getTerritoire() {
		return territoire;
	}
	
	public Simulateur getSimulateur() {
		return simulateur;
	}
	
	public GestionVue getGestionVue() {
		return gestionVue;
	}
	
	public GestionRapport getGestionRapport() {
		return gestionRapport;
	}

	public void NouvelleFourmiliere(Position position) {
		getTerritoire().nouvelleFourmilliere(position);
	}
	
}
