package fourmi.tache;

import fourmi.Fourmi;
import fourmi.role.Role;
import territoire.Case;
import territoire.Position;
import territoire.Territoire;

public class Chasser extends Tache {

	int NOMBRE_VOISIN = 4;
	
	Case emplacement;
	Case emplacementPrecedent;
	
	Territoire getTerritoire() {
		return role.getEtat().getFourmi().getFourmiliere().getTerritoire();
	}
	
	public Chasser(Role role) {
		super(role);
		emplacement = getTerritoire().getCase(role.getEtat().getFourmi().getPosition());
		emplacementPrecedent=emplacement;
	}

	public void changerCase(Case nouvellePosition){
		emplacementPrecedent=emplacement;
		emplacementPrecedent.supprimerEntite(role.getEtat().getFourmi());
		emplacement=nouvellePosition;
		emplacement.addPheromone(getIndexFourmiliere());
		emplacement.ajouterEntite(role.getEtat().getFourmi());
		role.getEtat().getFourmi().setPosition(emplacement.getPosition());
	}
	
	void deplacer(){
		int positionX = role.getEtat().getFourmi().getPosition().getX();
		int positionY = role.getEtat().getFourmi().getPosition().getY();
		Case [] listeVoisin = new Case[4];
		listeVoisin[0]  = getTerritoire().getCase(new Position(positionX+1,positionY));
		listeVoisin[1]  = getTerritoire().getCase(new Position(positionX-1,positionY));
		listeVoisin[2]  = getTerritoire().getCase(new Position(positionX,positionY+1));
		listeVoisin[3]  = getTerritoire().getCase(new Position(positionX,positionY-1));
		
		changerCase(nextCase(listeVoisin));
	}
	
	Case nextCase(Case [] listeVoisin){
		int [] listeProbabilite = new int[NOMBRE_VOISIN];
		int total=0;
		
		for(int i=0;i<NOMBRE_VOISIN;i++){
			listeProbabilite[i] = importanceCase(listeVoisin[i]);
			total += listeProbabilite[i];
		}
		
		double random = Math.random()*total;
		
		int seuil=0;
		
		for(int i=0;i<NOMBRE_VOISIN;i++){
			if(random>seuil && random<listeProbabilite[i]+seuil){
				return listeVoisin[i];
			} else {
				seuil += listeProbabilite[i];
			}
		}
		return emplacement;
		
	}
	
	int getIndexFourmiliere(){
		return getTerritoire().getFourmiliere().indexOf(role.getEtat().getFourmi().getFourmiliere())+1;
	}
	
	int importanceCase(Case caseTest){
		if(caseTest.getPosition().getX()<0 || caseTest.getPosition().getY()<0)return 0; //fixe
		if(caseTest.equals(emplacementPrecedent))return 1;	//pr�f�rence aucun retour en arriere
		
		if(caseTest.getPheromone()==getIndexFourmiliere()){	//pr�f�rence suivre ph�romone
			return 3;
		}
		//pr�f�rence a aller tout droit
		if(emplacementPrecedent.getPosition().getX()-emplacement.getPosition().getX()== emplacement.getPosition().getX()-caseTest.getPosition().getX() ||
				emplacementPrecedent.getPosition().getY()-emplacement.getPosition().getY()== emplacement.getPosition().getY()-caseTest.getPosition().getY() ){
			return 2;
		}
		//option case inataignable
		if(caseTest.getPheromone()==-2)return 0;
		
		//case par defaut
		return 1;
	}

	@Override
	public void evenement() {
		deplacer();
	}
	
}