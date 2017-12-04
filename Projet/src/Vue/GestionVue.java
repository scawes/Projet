package Vue;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import observeur.Evenement;
import observeur.Observeur;
import observeur.TimeChange;
import simulateur.Simulateur;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class GestionVue implements Observeur{
	

	private Canvas canvas;
	private GraphicsContext gc ;
	private int taille;
	Gestionnaire gestionnaire;
	
	 GestionVue(Gestionnaire gestionnaire,Canvas canvas) {
		 this.gestionnaire=gestionnaire;
		setCanvas(canvas);
		taille = 10;
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
		gestionnaire.getTerritoire().getCase(reine.getPosition());
		gestionnaire.getTerritoire().nouvelleFourmilliere(reine);
		gestionnaire.getSimulateur().record(TimeChange.class.getName(), gestionnaire.getTerritoire());
	}
	
	public void drawCase(Position position,int element) {
		if(position.getX()<1||position.getY()<1)return;
		if(position.getY()>(canvas.getHeight()/taille)-1||position.getX()>(canvas.getWidth()/taille)-1)return;
        gc.setFill(Color.BLACK);

        gc.fillRect(position.getX()*taille, position.getY()*taille, taille, taille);
        
        gc.setFill(getColor2(element));
        
        gc.fillRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2);       
        gc.setFill(Color.BLACK);
        //gc.fillText(String.valueOf(Territoire.getInstance().getCase(position).getEntite().size()), position.getX()*taille+taille*0.25, position.getY()*taille+taille*0.75, taille/2);
        //gc.fillText(String.valueOf(Territoire.getInstance().getCase(position).getEntite().size()), position.getX()*taille+taille*0.25, position.getY()*taille+taille*0.75);
    }
	
	Color getColor(int element){
		if(element == 1) {
        	return Color.GREEN;
        } else if(element == -1) {
        	return Color.BROWN;
        } else if(element == -2) {
        	return Color.BLACK;
        } else {
        	return Color.WHITE;
        }
	}
	
	Color getColor2(int element){
		if(element > 0) {
			if(element < 1000)return Color.color(1-(double)element/1000, 1, 1-(double)element/1000);
			else return Color.color(0, 1, 0);
        } else if(element == -1) {
        	return Color.BROWN;
        } else if(element == -2) {
        	return Color.BLACK;
        } else {
        	return Color.WHITE;
        }
	}
	
	public void clear(){
		
		gc.clearRect(0, 0,  canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.WHITE);
		gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
		
	}
	
	public void clearCase(Position position){
		gc.clearRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2);
	}

	@Override
	public void receive(Evenement evt) {
		Case casemodif = (Case)evt.source();
		drawCase(casemodif.getPosition(),casemodif.getPheromone());
	}
	
}
