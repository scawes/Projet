package simulateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import observeur.Evenement;
import observeur.Observable;
import observeur.Observeur;
import observeur.TimeChange;

public class Simulateur extends Thread implements Observable {

	private Map<String, List<Observeur>> observers;

	public Simulateur(Observeur observer) {
		this.observers = new HashMap<>();
		this.record(TimeChange.class.getName(), observer);
	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.signal(new TimeChange(this));
		}

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
