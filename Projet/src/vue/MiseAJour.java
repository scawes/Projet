package vue;

import javafx.scene.control.TextField;
import observeur.Evenement;
import observeur.Observeur;

public class MiseAJour implements Observeur {

	int temps;
	TextField textTemps;

	MiseAJour(TextField textTemps) {
		temps = 0;
		this.textTemps = textTemps;
	}

	@Override
	public void receive(Evenement evt) {
		temps++;
		textTemps.setText(String.valueOf(temps));
	}
}
