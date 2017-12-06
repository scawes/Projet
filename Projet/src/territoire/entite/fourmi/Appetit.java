package territoire.entite.fourmi;

public class Appetit {

	final int JOURNEE = 1000;
	
	double faim;
	double appetit;
	
	public Appetit(double appetit){
		
		this.appetit=appetit;
		faim = JOURNEE*appetit;
		if(appetit==0){
			faim = 1;
		}
	}
	
	public Appetit(){
		faim = 1;
	}
	
	public boolean decrementer(){
		faim-=appetit;
		if(faim<=0){
			return true;
		}
		return false;
	}
	
	public void manger(double nourriture){
		faim+=nourriture*JOURNEE;
	}
	
	public double faim(){
		return faim/JOURNEE;
	}
}
