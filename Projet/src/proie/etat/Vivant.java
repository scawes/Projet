package proie.etat;

import fourmi.Fourmi;
import fourmi.role.Ouvriere;
import fourmi.role.Reine;
import fourmi.role.Role;
import rapports.Rapport;
import rapports.Trace;

public class Vivant extends Etat implements Trace {

	
	Tache role;
	int tempsDehors ; 

	Vivant(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
		role=getRole(this);//ajouter cette methode danss adulte
		timerNourriture = 60;
		this.tempsDehors=0;
	}
	
	public Role getTache(Etat etat) {
		if(etat.getFourmi().getFourmiliere().getListeFourmi().size()<1)
		return new Deplacer(etat);
		else return new Ouvriere(etat);
	}
	

	@Override
	public	void evenement() {

		role.evenement();
	}
	/*
	 * Renvoi un boolean
	 * Vrai : duree du trajet dépasse le temps limite
	 * Faux : Il reste du temps en exterieur
	 */
	
	public boolean dureetrajetLimite() {
        	if(this.getPosition()!=this.getPositionsFourmiliere()) {  // vérification que la fourmi sois bien a l'exterieur
          	  if(tempsDehors>600) {// 600 correspond a 10*60 minutes
          	    return true;
          	  }
          	  else {
          	    tempsDehors++;
          	    return false;
          	  }
        	}
        	else {
        	  tempsDehors=0;
        	  return false;
        	}
	}
	
	

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		role.trace(rapport);
	}
	
	/*
	 * Cette méthode augmente l'appetit de la fourmi dans le temps
	 */
	public void incrementeAppetit() {
	  
	  if(this.timerNourriture ==0) {
	    appetit += (this.fourmi.getPoid()/180);
	    timerNourriture =60;// 60 correspond à 60 minutes
	  }
	  else {
	    this.timerNourriture--;
	  }
	}
	/*
	 * Cette methode represente l'action de se nourir de la fourmi
	 */
	public void manger() {
	  int j =0;
	  double nourriture;
	  for (int i = 0 ; i< this.getPositionsFourmiliere().size(); i++) { //verification de la position de la fourmi
	    if(this.getPosition().equals(this.getPositionsFourmiliere().get(i))) {
	      while(j <this.getProiePresnte().size() && appetit !=0) {// parcours des proies disponible
	        if(appetit>this.getProiePresnte().get(j).getPoid()) {// la proie ne possede pas assez de poid et sera donc manger integralement
	          nourriture = this.getProiePresnte().get(j).getPoid();
	          this.getProiePresnte().get(j).decrementePoid(nourriture);
	          appetit -=nourriture;
	          j++;
	        }
	        else {//la proie peut satisfaire l'appetit de la fourmi et se vois donc retirer autant de poid que l'appetit
	          nourriture = appetit;
	          this.getCase().getProies().get(j).decrementePoid(nourriture);
                  appetit -=nourriture;
	          
	        }
	      }
	    
	    }
	  }
	}

}
