package Vue;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import fourmiliere.Fourmiliere;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import observeur.Evenement;
import observeur.Observeur;
import observeur.TimeChange;
import territoire.zone.Case;
import territoire.zone.Position;

public class GestionVue implements Observeur{
	
	final int SEUIL = 200;
	private Canvas canvas;
	private GraphicsContext gc ;
	private int taille;
	Gestionnaire gestionnaire;
	
	 GestionVue(Gestionnaire gestionnaire,Canvas canvas) {
		 this.gestionnaire=gestionnaire;
		setCanvas(canvas);
		taille = 10;
		gestionnaire.getSimulateur().record(TimeChange.class.getName(), gestionnaire.getTerritoire());
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
		gestionnaire.getTerritoire().getCase(position);
		Fourmiliere fourmiliere = gestionnaire.getTerritoire().nouvelleFourmilliere(position);
		Fourmi reine = new Fourmi(fourmiliere,position);
		reine.evolution(new Adulte(reine));
		fourmiliere.ajouterFourmi(reine);
		
	}
	
	public void drawCase(Position position,int element) {
		if(position.getX()<1||position.getY()<1)return;
		if(position.getY()>(canvas.getHeight()/taille)-1||position.getX()>(canvas.getWidth()/taille)-1)return;
        if(this.taille>5) {
        	gc.setFill(Color.GRAY);
        	gc.fillRect(position.getX()*taille, position.getY()*taille, taille, taille);
        	gc.setFill(getColorCase(element));
            gc.fillRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2); 
        } else {
        	gc.setFill(getColorCase(element));
            gc.fillRect(position.getX()*taille+1, position.getY()*taille+1, taille-2, taille-2); 
        }

              
    }
	
	public void drawFourmi(Position position,int nombreFourmis) {
		if(position.getX()<1||position.getY()<1)return;
		if(position.getY()>(canvas.getHeight()/taille)-1||position.getX()>(canvas.getWidth()/taille)-1)return;
		gc.setFill(Color.BLACK);
		if(taille>5) {
			for(int index=0;index<nombreFourmis;index++) {
				gc.fillOval(position.getX()*(taille)+(Math.random()*(taille-4))+2,
						position.getY()*(taille)+(Math.random()*(taille-4))+2,
						taille/4, taille/4); 
			}
		} else {
			for(int index=0;index<nombreFourmis;index++) {
			gc.fillOval(position.getX()*(taille)+taille/2,
					position.getY()*(taille)+taille/2,
					taille/4, taille/4); 
			}
		}
		
	}
	
	public void drawProie(Position position,boolean vivant) {
		if(position.getX()<1||position.getY()<1)return;
		if(position.getY()>(canvas.getHeight()/taille)-1||position.getX()>(canvas.getWidth()/taille)-1)return;
		if(vivant) {
			gc.setFill(Color.BLUE);
		} else {
			gc.setFill(Color.RED);
		}
		if(taille>5) {
			
			gc.fillOval(position.getX()*(taille)+2,
					position.getY()*(taille)+2,
					taille/2, taille/2); 
			

		} else {
			
				gc.fillOval(position.getX()*(taille)+2,
						position.getY()*(taille)+2,
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
