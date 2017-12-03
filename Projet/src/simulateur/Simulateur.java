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
	
	int TICK = 300;

	private Map<String, List<Observeur>> observers;
	
	static Simulateur simulateur = new Simulateur(100);
	Timeline timeline;
	
	public static Simulateur getInstance(){
		return simulateur;
	}

	Simulateur() {
		this.observers = new HashMap<>();
	}
	
	//simulateur temps optimiser canvas
	Simulateur(int time) {
		
		this.observers = new HashMap<>();
		timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0), 
                        event -> run()
                ),
                new KeyFrame(Duration.seconds((double)time/1000))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
		
	}
	
	public void setTimer(int temps){
		timeline.stop();
		timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0), 
                        event -> run()
                ),
                new KeyFrame(Duration.seconds((double)temps/1000))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
	}
	
	Simulateur(Observeur observer) {
		this.observers = new HashMap<>();
		this.record(TimeChange.class.getName(), observer);
	}

	/*@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(TICK);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.signal(new TimeChange(this));
		}

	}*/
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
