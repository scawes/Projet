package Vue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import rapports.Rapport;
import rapports.RapportGraphique;
import territoire.Position;
import territoire.Territoire;

public class Controleur implements Initializable {

	
	@FXML
	Canvas affichage;

	static GraphicsContext gc ;
	
	
	@FXML
	public void rafraichir(){
		Rapport rapport = new RapportGraphique();
		Territoire.getInstance().trace(rapport);
		System.out.println(rapport);
		drawShapes();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = affichage.getGraphicsContext2D();
		
	}
	
	public static void drawShapes() {
		
		
		drawCase(new Position(10, 10));
		drawCase(new Position(11, 10));
		drawCase(new Position(9, 10));
		drawCase(new Position(10, 11));
		drawCase(new Position(10, 9));
        
    }
	
	
	public static void drawCase(Position position) {
		
		int taille = 15;
        gc.setFill(Color.BLACK);
        //gc.setLineWidth(1);
        
        //gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        //gc.strokeRoundRect(0, 0, taille, taille, taille, taille);
        gc.fillRect(position.getX()*taille, position.getY()*taille, taille, taille);
        gc.setFill(Color.WHITE);
        gc.fillRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2);       
        
    }
	
}
