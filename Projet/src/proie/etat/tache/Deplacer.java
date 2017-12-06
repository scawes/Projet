package proie.etat.tache;

import proie.Proie;
import proie.etat.Etat;
import territoire.Territoire;
import territoire.zone.Deplacement;
import territoire.zone.Position;

public class Deplacer extends Tache {

	final int NOMBRE_VOISIN = 4;
	final int DISTANCE_MAX = 200;
	
	public Deplacer(Etat etat) {
		super(etat);
	}

	Proie getProie() {
		return etat.getProie();
	}
	
	Territoire getTerritoire() {
		return getProie().getTerritoire();
	}
	
	Deplacement getDeplacement() {
		return getProie().getDeplacement();
	}
	
	public void phaseDeplacement() {
		Position caseSuivante =nextCase(getDeplacement().getVoisin());
		getDeplacement().changerCase(caseSuivante);
	}
	
	
	Position nextCase(Position [] listeVoisin){
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
		return getDeplacement().getEmplacement();
		
	}
	
	int importanceCase(Position positionTest){
		if(positionTest.equals(getDeplacement().getEmplacementPrecedent()))return 10;	//pr�f�rence aucun retour en arriere
		
		return 50;
	}

	@Override
	public void evenement() {
		phaseDeplacement();
	}
	
}