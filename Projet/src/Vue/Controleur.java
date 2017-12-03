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
		/*Rapport rapport = new RapportGraphique();
		Territoire.getInstance().trace(rapport);
		System.out.println(rapport);
		*/
		Simulateur.getInstance().record(TimeChange.class.getName(), new MiseAJour());
	}
	
	@FXML
	public void NouvelleFourmiliere(){
		Fourmi reine = new Fourmi(null,new Position(40, 30));
		reine.evolution(new Adulte(reine));
		Territoire.getInstance().getCase(reine.getPosition());
		
		Territoire.getInstance().nouvelleFourmilliere(reine);
		
		Simulateur.getInstance().record(TimeChange.class.getName(), Territoire.getInstance());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = affichage.getGraphicsContext2D();
		
	}
	
	public static void drawTest() {
		
		
		drawCase(new Position(10, 10),0);
		drawCase(new Position(11, 10),0);
		drawCase(new Position(9, 10),0);
		drawCase(new Position(10, 11),0);
		drawCase(new Position(10, 9),0);
        
    }
	
	
	public static void drawCase(Position position,int element) {
		int taille = 5;
        gc.setFill(Color.BLACK);

        gc.fillRect(position.getX()*taille, position.getY()*taille, taille, taille);
        if(element == 1) {
        	gc.setFill(Color.GREEN);
        } else if(element == -1) {
        	gc.setFill(Color.BROWN);
        } else if(element == -2) {
        	gc.setFill(Color.BLACK);
        } else {
        	gc.setFill(Color.WHITE);
        }
        gc.fillRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2);       
        gc.setFill(Color.BLACK);
        //gc.fillText(String.valueOf(Territoire.getInstance().getCase(position).getEntite().size()), position.getX()*taille+taille*0.25, position.getY()*taille+taille*0.75, taille/2);
        //gc.fillText(String.valueOf(Territoire.getInstance().getCase(position).getEntite().size()), position.getX()*taille+taille*0.25, position.getY()*taille+taille*0.75);
    }
	
	public static void clear(){
		gc.clearRect(0, 0, 2000, 2000);
	}
	
}
