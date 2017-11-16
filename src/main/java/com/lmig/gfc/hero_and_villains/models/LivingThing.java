package com.lmig.gfc.hero_and_villains.models;

public class LivingThing {
	
	protected String name;
	protected int health;
	
	public LivingThing(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	public boolean isAlive() {
		return health > 0;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

}
