package territoire.entite.proie.etat.tache.vivant;

import java.util.ArrayList;
import java.util.List;

import territoire.entite.fourmi.tache.ouvriere.Attaque;
import territoire.entite.proie.Proie;
import territoire.entite.proie.etat.Vivant;

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
	
	public void fourmiArrive(Attaque nouvellefourmi) {
		listeFourmis.add(nouvellefourmi);
		int poidTotal = 0;
		for(Attaque fourmi : listeFourmis) {
			poidTotal+=fourmi.getPoid();
		}
		if(poidTotal>etat.getProie().getPoid()) {
			for(Attaque fourmi : listeFourmis) {
				fourmi.fuiteProie();
			}
			getProie().mortProie();
		}
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