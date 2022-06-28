package com.mdval.ui.utils.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	
	private List<Observer> observers;
	
	private Boolean changed;

	public Observable() {
		super();
		observers = new ArrayList<>();
		changed = false;
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void setChanged() {
		changed = true;
	}
	
	public void notifyObservers(Object cmd) {
		if (changed) {
			for (Observer o : observers) {
				o.update(this, cmd);
			}
			
			changed = false;
		}
	}
}
