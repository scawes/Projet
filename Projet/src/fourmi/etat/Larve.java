package fourmi.etat;

import fourmi.Fourmi;
import rapports.Rapport;
import rapports.Trace;

public class Larve extends Etat implements Trace{
  
  

	Larve(Fourmi fourmi) {
		super(fourmi);
		this.setDureeDeVie(10);
		this.setPoid(this.getPoid()*3);
		appetit =0;
		
	}
	
public void incrementeAppetit() {
          
          if(this.timerNourriture ==0) {
            appetit += (this.getPoid()/60);
            timerNourriture =60;
          }
          else {
            this.timerNourriture--;
          }
        }
        
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
        }
	
	

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
