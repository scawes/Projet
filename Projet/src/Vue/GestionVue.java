package Vue;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import observeur.TimeChange;
import simulateur.Simulateur;
import territoire.Position;
import territoire.Territoire;

public class GestionVue {
	
	private static GestionVue gestionVue = new GestionVue();
	private Canvas canvas;
	private GraphicsContext gc ;
	private int taille;
	
	 GestionVue() {
		taille = 10;
	}
	
	
	public static GestionVue getInstance(){
		return gestionVue;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas=canvas;
		gc = this.canvas.getGraphicsContext2D();
		clear();
	}
	
	public void setTaille(int taille) {
		this.taille=taille;
	}
	
	
	public void NouvelleFourmiliere(Position position){
		Fourmi reine = new Fourmi(null,position);
		reine.evolution(new Adulte(reine));
		Territoire.getInstance().getCase(reine.getPosition());
		Territoire.getInstance().nouvelleFourmilliere(reine);
		Simulateur.getInstance().record(TimeChange.class.getName(), Territoire.getInstance());
	}
	
	public void drawCase(Position position,int element) {
		if(position.getX()<1||position.getY()<1)return;
		if(position.getY()>(canvas.getHeight()/taille)-1||position.getX()>(canvas.getWidth()/taille)-1)return;
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
	
	public void clear(){
		
		gc.clearRect(0, 0,  canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.WHITE);
		gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
		
	}
	
	public void clearCase(Position position){
		gc.clearRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2);
	}
	
}
