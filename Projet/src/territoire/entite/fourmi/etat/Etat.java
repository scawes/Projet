package territoire.entite.fourmi.etat;

import rapports.Trace;
import territoire.entite.DureeVie;
import territoire.entite.fourmi.Fourmi;

public abstract class Etat implements Trace {

	private final double POID_MIN = 1.5;
	private final double POID_MAX = 2;
	
	Fourmi fourmi;
	protected double poid;
	protected DureeVie dureeDeVie;
	
	
	Etat(Fourmi fourmi){
		this.fourmi=fourmi;
	}
	
	public double getPoid() {
	 return this.poid;
	}
	
	public void setPoid(double poid) {
	  this.poid=poid;
	}
        
    public void setDureeDeVie(int duree) {
    	dureeDeVie = new DureeVie(duree);
    }
        
    abstract void vieillir() ;

        /*
        /**
         * retourne l'instance de la case sur la qu'elle elle se situe
         * @return Case
         */
	
	/*
        Case getCase() {
          return this.fourmi.getFourmiliere().getTerritoire().getCase(this.fourmi.getDeplacement().getEmplacement());
        }
        
        
        Position getPosition() {
          return this.fourmi.getDeplacement().getEmplacement();
        }
        
        List<Position> getPositionsFourmiliere(){
          return this.fourmi.getFourmiliere().getPosition();
        }

        List<Proie> getProiePresnte(){
          return this.getCase().getProies();
        }*/
	
	public Fourmi getFourmi() {
		return fourmi;
	}
	
	public abstract void evenement();

}
