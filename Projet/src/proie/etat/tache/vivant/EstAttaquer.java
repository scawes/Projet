package proie.etat.tache.vivant;

import java.util.ArrayList;
import java.util.List;

import fourmi.tache.ouvriere.Attaque;
import proie.Proie;
import proie.etat.Vivant;

public class EstAttaquer extends TacheProieVivant {
	
	final int TEMP_LIBERATION = 20;
	
	int liberation;
	List<Attaque> listeFourmis;
	
	public EstAttaquer(Vivant etat,Attaque fourmiAttaque) {
		super(etat);
		listeFourmis = new ArrayList<Attaque>();
		fourmiArrive(fourmiAttaque);
		liberation=TEMP_LIBERATION;
	}

	Proie getProie() {
		return etat.getProie();
	}
	
	public void fourmiArrive(Attaque fourmi) {
		listeFourmis.add(fourmi);
		liberation=TEMP_LIBERATION;
	}
	
	void fourmiPerdu(Attaque fourmi) {
		listeFourmis.remove(fourmi);
	}
	
	public void phaseAttaquer() {
		liberation--;
		if(liberation<=0 || listeFourmis.size()==0) {
			fuite();
		}
	}
	
	void fuite() {
		for(Attaque fourmi : listeFourmis) {
			fourmi.fuiteProie();
		}
		etat.setTache();
	}
	

	@Override
	public void evenement() {
		phaseAttaquer();
	}

	@Override
	public boolean estAttaquer() {
		// TODO Auto-generated method stub
		return true;
	}
	
}