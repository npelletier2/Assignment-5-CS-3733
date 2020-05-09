package edu.wpi.cs3733.entity;

/**
 * Message class to hold clear text; you must implement the rest of the class
 */
public class Message implements Observable {
	private String text;

	public void setText(String text){
		int max = 140;
		if(text.length() < max) max = text.length();
		this.text = text.substring(0, max);
	}

	public String getText(){
		return text;
	}

	@Override
	public void register(Observer o){

	}

	@Override
	public void notifyObservers(){

	}
}
