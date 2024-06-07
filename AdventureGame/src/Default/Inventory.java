package Default;

public class Inventory {
	
	private boolean food;
	private boolean water;
	private boolean firewood;
	private String weaponName;
	private String armorName;
	private int weaponDamage;
	private int armorBlock;
	public Inventory() {
		this.food = false;
		this.water = false;
		this.firewood = false;
		this.weaponName = null;
		this.armorName = null;
		this.weaponDamage = 0;
		this.armorBlock = 0;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public boolean isFirewood() {
		return firewood;
	}
	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	public String getArmorName() {
		return armorName;
	}
	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}
	public int getWeaponDamage() {
		return weaponDamage;
	}
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	public int getArmorBlock() {
		return armorBlock;
	}
	public void setArmorBlock(int armorBlock) {
		this.armorBlock = armorBlock;
	}
	
	
	
	
	
	
	
}
  