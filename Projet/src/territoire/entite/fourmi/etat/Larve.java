package territoire.entite.fourmi.etat;

import rapports.Rapport;
import rapports.Trace;
import territoire.entite.fourmi.Fourmi;

public class Larve extends Etat implements Trace{
  
  

	Larve(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(10);
		//this.setPoid(this.getPoid()*3);
		appetit =0;
		
	}
	/*
	 * Elle represente l'evolution de l'appetit dans le temps
	 */
	/*public void incrementeAppetit() {
          
          if(this.timerNourriture ==0) {
            appetit += (this.getPoid()/60);
            timerNourriture =60;
          }
          else {
            this.timerNourriture--;
          }
        }
        /*
         * Elle represente l'action de nourir la larve 
         * La fourmi en parametre est celle qui la nourrie
         *//*
        public void manger(Fourmi fourmi) {
          int j =0;
          double nourriture;
          for (int i = 0 ; i< this.getPositionsFourmiliere().size(); i++) {
            if(this.getPosition().equals(this.getPositionsFourmiliere().get(i))) {
              while(j <this.getProiePresnte().size() && appetit !=0) {
                if(appetit>this.getProiePresnte().get(j).getPoid()) {
                  nourriture = this.getProiePresnte().get(j).getPoid();
                  this.getProiePresnte().get(j).decrementePoid(nourriture);
                  appetit -=nourriture;
                }
                else {
                  nourriture = appetit;
                  this.getCase().getProies().get(j).decrementePoid(nourriture);
                  appetit -=nourriture;
                  
                }
              }
            
            }
          }
        }*/
	
	

	@Override
	public void evenement() {
		// TODO Auto-generated method stub
		this.decrementDureeDeVie();
		if(this.getDureeDeVie()<0) {
			fourmi.evolution(new Lymphe(fourmi));
		}
	}

	@Override
	public void trace(Rapport rapport) {
		rapport.traceForFourmiliere(this);
	}

}
