package Default;

import java.util.Random;

public class Obstacle {
	private String name;
	private int id,damage,health,award;
	private int maxNumber;
	
	public Obstacle(int id,String name, int damage, int health, int award, int maxNumber) {
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.award = award;
		this.maxNumber = maxNumber;
	}
	public int Count() {
		 Random r= new Random();
		 return r.nextInt(maxNumber) + 1;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getHealth() {
		if(health<0) {
			health=0;
		}
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
	

}
