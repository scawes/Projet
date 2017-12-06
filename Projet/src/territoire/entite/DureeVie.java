package territoire.entite;

public class DureeVie {

	int tempVie;
	
	public DureeVie(int tempsVie){
		this.tempVie=tempsVie;
	}
	
	public boolean decrementer(){
		tempVie--;
		if(tempVie <= 0) {
			return true;
		}
		return false;
	}
}
