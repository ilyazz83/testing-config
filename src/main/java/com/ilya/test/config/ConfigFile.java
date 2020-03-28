package com.ilya.test.config;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class ConfigFile {
	
	List<Observer> observers;
	String checkSum;
	long lastChanged;
	File f;
	
	public String fileName;
		
	public ConfigFile(String fileName)  {
		this.fileName = fileName;
		f = new File(fileName);
		lastChanged = f.lastModified();	
		observers = new ArrayList<Observer>();
	}
	
	public void subscribe(Observer o) {		
		observers.add(o);		
	}
	
	public void unsubscribe(Observer o) {
		observers.remove(o);		
	}
	
	public void trackChanges() {
		if (f.lastModified() > lastChanged) {
			lastChanged = f.lastModified();
			
			// Notify observers
			for(Observer o: observers) {
				o.update();
			}
		}
	}
	
}
