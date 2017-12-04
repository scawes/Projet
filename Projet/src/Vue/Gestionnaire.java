package Vue;

import javafx.scene.canvas.Canvas;
import simulateur.Simulateur;
import territoire.Territoire;

public class Gestionnaire {

	Territoire territoire;
	Simulateur simulateur;
	GestionVue gestionVue;
	GestionRapport gestionRapport;
	
	public Gestionnaire(Canvas canvas) {
		territoire=new Territoire(this);
		simulateur =new Simulateur();
		gestionVue = new GestionVue(this,canvas);
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
	
}
