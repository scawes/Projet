package territoire.entite.fourmi;

public class Appetit {

	int appetit;
	
	public Appetit(int appetit){
		this.appetit=appetit;
	}
	
	public boolean decrementer(){
		appetit--;
		if(appetit<=0){
			return false;
		}
		return true;
	}
	
	public void manger(int nourriture){
		appetit+=nourriture;
	}
	
	public int faim(){
		return appetit;
	}
}
