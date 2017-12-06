package vue;

import java.net.URL;
import java.util.ResourceBundle;

import gestionnaire.Gestionnaire;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import territoire.zone.Position;

public class Controleur implements Initializable {
	
	Gestionnaire gestionnaire;
	
	@FXML
	Canvas canvas;
	
	
	@FXML
	public void rafraichir(){
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void trace(){
		gestionnaire.getGestionRapport().trace();
	}
	
	@FXML
	public void zoom(){
		gestionnaire.getGestionVue().setTaille(10);
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void vite(){
		gestionnaire.getSimulateur().setTimer(100);
	}
	
	@FXML
	public void lent(){
		gestionnaire.getSimulateur().setTimer(1000);
	}
	
	@FXML
	public void dezoom(){
		gestionnaire.getGestionVue().setTaille(5);
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void NouvelleFourmiliere(){
		gestionnaire.getGestionVue().NouvelleFourmiliere(new Position(10,10));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gestionnaire=new Gestionnaire(canvas);
		zoom();
	}
	

	
}
