package edu.wpi.cs3733.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Message class to hold clear text; you must implement the rest of the class
 */
public class Message implements Observable {

	private String text;
	private List<Observer> observers = new ArrayList<Observer>();

	public void setText(String text){
		this.text = text;
		notifyObservers();
	}

	public String getText(){
		return text;
	}

	@Override
	public void register(Observer o){
		observers.add(o);
	}

	@Override
	public void notifyObservers(){
		for (Observer observer : observers) {
			observer.notify(text);
		}
	}
}
