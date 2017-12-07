package territoire.zone.pheromone;

import territoire.fourmiliere.Fourmiliere;

public abstract class Pheromone {
	Fourmiliere fourmiliere;
	boolean sexe;
	int dureeDAction = 100;
	final int RAFFRAICHISSEMENT = 30;
	final int MAX = 1000;

	public void passageFourmie() {
		if (dureeDAction + RAFFRAICHISSEMENT < MAX) {
			dureeDAction += RAFFRAICHISSEMENT;
		}
	}

	public int getPuissance() {
		return dureeDAction;
	}

	public void decrementPheromone() {
		if (dureeDAction > 500) {
			this.dureeDAction -= 50;
		} else if (dureeDAction > 0) {
			this.dureeDAction--;
		}
	}

	public boolean isFourmiliere(Fourmiliere fourmiliere) {
		return this.fourmiliere.equals(fourmiliere);
	}

	public boolean isSexue() {
		return sexe;
	}

}
