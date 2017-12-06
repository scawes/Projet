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
		simulateur =new Simulateur();
		
		territoire=new Territoire(this);
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
	
}
