package vue;

import java.net.URL;
import java.util.ResourceBundle;

import gestionnaire.Gestionnaire;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import observeur.TimeChange;
import territoire.zone.Position;

public class Controleur implements Initializable {
	
	Gestionnaire gestionnaire;
	
	@FXML
	Canvas canvas;
	
	@FXML
	TextField textTemps;
	
	
	@FXML
	public void rafraichir(){
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void trace(){
		gestionnaire.getGestionRapport().trace();
	}
	
	@FXML
	public void traceRole(){
		gestionnaire.getGestionRapport().traceTache();
	}
	
	@FXML
	public void traceMort(){
		gestionnaire.getGestionRapport().traceMort();
	}
	
	@FXML
	public void zoom(){
		gestionnaire.getGestionVue().zoom();;
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void dezoom(){
		gestionnaire.getGestionVue().dezoom();
		gestionnaire.getGestionRapport().graphique();
	}
	
	@FXML
	public void vite(){
		gestionnaire.getSimulateur().plusVite();
	}
	
	@FXML
	public void lent(){
		gestionnaire.getSimulateur().plusLent();
	}
	
	@FXML
	public void decalageDroite(){
		gestionnaire.getGestionVue().decalageDroite();
	}
	
	@FXML
	public void decalageGauche(){
		gestionnaire.getGestionVue().decalageGauche();
	}
	
	@FXML
	public void decalageBas(){
		gestionnaire.getGestionVue().decalageBas();
	}
	
	@FXML
	public void decalageHaut(){
		gestionnaire.getGestionVue().decalageHaut();
	}
	
	
	
	@FXML
	public void NouvelleFourmiliere(){
		gestionnaire.NouvelleFourmiliere(new Position(10,10));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gestionnaire=new Gestionnaire(canvas);
		gestionnaire.getSimulateur().record(TimeChange.class.getName(), new MiseAJour(textTemps));
		zoom();
	}
	

	
}
