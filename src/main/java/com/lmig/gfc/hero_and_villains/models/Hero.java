package com.lmig.gfc.hero_and_villains.models;

import java.util.Random;

public class Hero extends LivingThing {
	private String secretIdentity;

	public Hero(String name, int health, String secretIdentity) {
		super(name, health);
		this.secretIdentity = secretIdentity;
	}

	public void attack(LivingThing living) {
		//make the hero attack the living thing
		//take a random amount of damage (1-10) off the hero
		int heroDamage = getRandomNumberInRange(1,10);
		int livingThingDamage = getRandomNumberInRange(1,10);
			setHealth(getHealth() - heroDamage);
		//take a random amount of damage (1-10) off the living thing
			living.setHealth(living.getHealth() - livingThingDamage);  
		
	}
	
	private int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max-min)+1) + min;
	}

	public String getSecretIdentity() {
		return secretIdentity;
	}
	
}
