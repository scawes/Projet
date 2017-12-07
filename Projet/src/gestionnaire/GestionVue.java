package gestionnaire;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import observeur.Evenement;
import observeur.Observeur;
import territoire.zone.Case;
import territoire.zone.Position;

public class GestionVue implements Observeur{
	
	final int SEUIL = 200;
	private Canvas canvas;
	private GraphicsContext gc ;
	private int taille;
	Gestionnaire gestionnaire;
	
	int decalageX;
	int decalageY;
	
	 GestionVue(Gestionnaire gestionnaire,Canvas canvas) {
		 this.gestionnaire=gestionnaire;
		setCanvas(canvas);
		decalageX=0;
		decalageY=0;
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
	
	public void zoom() {
		if(this.taille<20){
			taille+=5;
		}
	}
	
	public void dezoom() {
		if(this.taille>5){
			taille-=5;
		}
	}
	
	public void decalageDroite(){
		decalageX-=20;
		gestionnaire.getGestionRapport().graphique();
	}
	public void decalageGauche(){
		decalageX+=20;
		gestionnaire.getGestionRapport().graphique();
	}
	public void decalageBas(){
		decalageY-=20;
		gestionnaire.getGestionRapport().graphique();
	}
	public void decalageHaut(){
		decalageY+=20;
		gestionnaire.getGestionRapport().graphique();
	}
	
	double decalX(double valeur){
		return valeur+decalageX;
	}
	
	double decalY(double valeur){
		return valeur+decalageY;
	}
	
	boolean onCanvas(Position position){
		if(position.getX() < 1-decalageX/taille)return true;
		if(position.getX() > ((canvas.getWidth()/taille)-1)-decalageX/taille)return true;
		if(position.getY() < 1-decalageY/taille)return true;
		if(position.getY() > ((canvas.getHeight()/taille)-1)-decalageY/taille)return true;
		return false;
	}
	
	public void drawCase(Position position,int element) {
		if(onCanvas(position))return;
        if(this.taille>5) {
        	gc.setFill(Color.GRAY);
        	gc.fillRect(decalX(position.getX()*taille), decalY(position.getY()*taille), taille, taille);
        	gc.setFill(getColorCase(element));
            gc.fillRect(decalX(position.getX()*taille+1), decalY(position.getY()*taille+1), taille-2, taille-2); 
        } else {
        	gc.setFill(getColorCase(element));
            gc.fillRect(decalX(position.getX()*taille+1), decalY(position.getY()*taille+1), taille-2, taille-2); 
        }     
    }
	
	public void drawFourmi(Position position,int nombreFourmis) {
		if(onCanvas(position))return;
		gc.setFill(Color.BLACK);
		if(taille>5) {
			for(int index=0;index<nombreFourmis;index++) {
				gc.fillOval(decalX( (position.getX()*(taille)+(Math.random()*(taille-4))+2)),
						decalY( (position.getY()*(taille)+(Math.random()*(taille-4))+2)),
						taille/4, taille/4); 
			}
		} else {
			for(int index=0;index<nombreFourmis;index++) {
			gc.fillOval(decalX(position.getX()*(taille)+taille/2),
					decalY(position.getY()*(taille)+taille/2),
					taille/4, taille/4); 
			}
		}
	}
	
	public void drawProie(Position position,boolean vivant) {
		if(onCanvas(position))return;
		if(vivant) {
			gc.setFill(Color.BLUE);
		} else {
			gc.setFill(Color.RED);
		}
		if(taille>5) {
			gc.fillOval(decalX(position.getX()*(taille)+2),
					decalY(position.getY()*(taille)+2),
					taille/2, taille/2); 
		} else {
			gc.fillOval(decalX(position.getX()*(taille)+2),
					decalY(position.getY()*(taille)+2),
					taille/2, taille/2); 
		}
		
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
	
	Color getColorCase(int element){
		if(element > 0) {
			if(element < SEUIL)return Color.color(1-(double)element/SEUIL, 1, 1-(double)element/SEUIL);
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
		
		if(casemodif.getProies().size()>0) {
			drawProie(casemodif.getPosition(),casemodif.getProies().get(0).isVivant());
		}
		
		drawFourmi(casemodif.getPosition(),casemodif.getEntite().size());
	}
	
}
