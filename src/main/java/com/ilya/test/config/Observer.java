package com.ilya.test.config;

public abstract class Observer {
	public ConfigFile config;
	
	public abstract void update();
	
	public Observer(ConfigFile c) {
		config = c;
	}
}
