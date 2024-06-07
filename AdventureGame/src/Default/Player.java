package Default;

import java.util.Scanner;


public class Player {
	private  Inventory inventory;
	private int id;
	private int damage;
	private int health;
	private int rhealth;
	private int money;
	private String name;
	private String cName;
	Scanner input=new Scanner(System.in);
	public Player(String name) {
		this.name=name;
		this.inventory= new Inventory();
		
	}
	
	
	public void selectCha() {
		
		switch(chaMenu()) {
		case 1:
			initPlayer(1, 5, 21, 15, "Samuray");
			break;
		case 2:
			initPlayer(2, 7, 18, 20, "Okçu");
			break;
		case 3:
			initPlayer(3, 8, 24, 5, "Şövalye");
			break;
			default:
				initPlayer(1, 5, 21, 15, "Samuray");
				break;
		}
		System.out.println("Karakter Oluşturuldu!");
		System.out.println("ID : " + this.getId() + "\tKarakter :" + this.getcName() +"\tHasar :" +
		this.getDamage() + "\tSağlık :" + this.getHealth() + "\tPara : " + this.getMoney());
	}
	public void initPlayer(int id,int dmg,int hlth,int mny,String cname) {
		setId(id);
		setDamage(dmg);
		setHealth(hlth);
		setRhealth(hlth);
		setMoney(mny);
		setcName(cname);
		
	}
	public int chaMenu() {
		System.out.println("Lütfen bir karakter seçiniz!");
		System.out.println("ID : 1,\tKarakter : Samuray,\tHasar : 5,\tSağlık : 21,\tPara : 15");
		System.out.println("ID : 2,\tKarakter : Okçu,\tHasar : 7,\tSağlık : 18,\tPara : 20");
		System.out.println("ID : 3,\tKarakter : Şövalye,\tHasar : 8,\tSağlık : 24,\tPara : 5");
		System.out.print("Karakter seçiminiz :");
		int selectCha=input.nextInt();
		while(selectCha<1 || selectCha>3) {
			System.out.println("Lüften doğru bir sayı giriniz!");
			System.out.print("Karakter seçiminiz :");
			selectCha=input.nextInt();
		}
		return selectCha;
	}
	public int getTotalDamage() {
		return this.getDamage() + this.inventory.getWeaponDamage(); 
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int damage) {
		this.damage=damage;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}


	public int getRhealth() {
		return rhealth;
	}


	public void setRhealth(int rhealth) {
		this.rhealth = rhealth;
	}


	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
