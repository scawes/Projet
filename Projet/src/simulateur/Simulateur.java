package simulateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import observeur.Evenement;
import observeur.Observable;
import observeur.Observeur;
import observeur.TimeChange;

public class Simulateur extends Thread implements Observable {

	/*
	 * Attributs
	 */

	int vitesse;

	private Map<String, List<Observeur>> observers;

	Timeline timeline;

	/*
	 * Constructeurs
	 */

	/**
	 * Constructeur de Simulateur. Initialise la vitesse à 100
	 */
	public Simulateur() {
		this(100);
	}

	/**
	 * Constructeur de Simulateur.
	 * 
	 * @param time
	 */
	public Simulateur(int time) {
		vitesse = 100;
		this.observers = new HashMap<>();
		timeline = new Timeline(new KeyFrame(Duration.seconds(0), event -> run()),
				new KeyFrame(Duration.seconds((double) time / 1000)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}

	/**
	 * Modifier la valeur de vitesse
	 */
	public void plusVite() {
		if (vitesse > 100) {
			vitesse -= 100;
		}
		setTimer(vitesse);
	}

	/**
	 * Modifier la valeur de vitesse
	 */
	public void plusLent() {
		if (vitesse < 2000) {
			vitesse += 50;
		}
		setTimer(vitesse);
	}

	/**
	 * Stop la timeline puis, modifier la valeur de vittesse, et la relance
	 */
	public void setTimer(int temps) {
		timeline.stop();
		timeline = new Timeline(new KeyFrame(Duration.seconds(0), event -> run()),
				new KeyFrame(Duration.seconds((double) temps / 1000)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	/*
	 * Methodes
	 */

	@Override
	public void run() {
		this.signal(new TimeChange(this));
	}

	@Override
	public void record(String evtTypeName, Observeur o) {
		if (!observers.containsKey(evtTypeName)) {
			observers.put(evtTypeName, new ArrayList<Observeur>());
		}
		List<Observeur> l = observers.get(evtTypeName);
		l.add(o);
	}

	@Override
	public void signal(Evenement evt) {
		String evtName = evt.getClass().getName();
		if (!observers.containsKey(evtName)) {
			return;
		}
		List<Observeur> l = observers.get(evtName);
		for (Observeur o : l) {
			o.receive(evt);
		}
	}

}
