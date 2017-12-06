package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.fourmi.role.Reine;
import territoire.entite.fourmi.role.Role;

public class Adulte extends Etat implements Trace {

	private final int VIE_ADULTE = 2000;
	private final double POID_MIN = 1.5;
	private final double POID_MAX = 2;
	
	Role role;
	int tempsDehors ; 

	
	public Adulte(Fourmi fourmi) {
		super(fourmi);
		setDureeDeVie(VIE_ADULTE);
		this.poid = (POID_MIN + (double)Math.random()* ((POID_MAX-POID_MIN)+1));
		getFourmi().setAppetit(poid/3);
		this.role=getRole(this);
	}
	
	public Role getRole(Etat etat) {
		if(etat.getFourmi().getFourmiliere().getListeFourmi().size()<1)
		return new Reine(etat);
		else return new Ouvriere(etat);
	}
	

	@Override
	public	void evenement() {
		vieillir();
		role.evenement();
	}
	
	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
		role.trace(rapport);
	}

	@Override
	void vieillir() {
		if(dureeDeVie.decrementer()) {
			//A COMPLETER : mort fourmi
		}
	}
	
}
	
	/*
	 * Renvoi un boolean
	 * Vrai : duree du trajet dépasse le temps limite
	 * Faux : Il reste du temps en exterieur
	 */
	
	/*public boolean dureetrajetLimite() {
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
	}*/
	
	

	
	
	/*
	 * Cette méthode augmente l'appetit de la fourmi dans le temps
	 */
	/*public void incrementeAppetit() {
	  
	  if(this.timerNourriture ==0) {
	    appetit += (this.fourmi.getPoid()/180);
	    timerNourriture =60;// 60 correspond à 60 minutes
	  }
	  else {
	    this.timerNourriture--;
	  }
	}*/
	/*
	 * Cette methode represente l'action de se nourir de la fourmi
	 */
	/*public void manger() {
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
	}*/

