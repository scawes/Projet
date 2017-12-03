package Vue;

import java.net.URL;
import java.util.ResourceBundle;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import observeur.TimeChange;
import rapports.Rapport;
import rapports.RapportGraphique;
import simulateur.Simulateur;
import territoire.Position;
import territoire.Territoire;

public class Controleur implements Initializable {
	
	
	@FXML
	Canvas affichage;

	static GraphicsContext gc ;
	
	
	@FXML
	public void rafraichir(){
		MiseAJour.graphique();
	}
	
	@FXML
	public void trace(){
		MiseAJour.trace();
	}
	
	@FXML
	public void zoom(){
		GestionVue.getInstance().setTaille(10);
		MiseAJour.graphique();
	}
	
	@FXML
	public void vite(){
		Simulateur.getInstance().setTimer(100);
	}
	
	@FXML
	public void lent(){
		Simulateur.getInstance().setTimer(1000);
	}
	
	@FXML
	public void dezoom(){
		GestionVue.getInstance().setTaille(3);
		MiseAJour.graphique();
	}
	
	@FXML
	public void NouvelleFourmiliere(){
		GestionVue.getInstance().NouvelleFourmiliere(new Position(10,10));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GestionVue.getInstance().setCanvas(affichage);
		GestionVue.getInstance().setTaille(3);
	}
	

	
}
