package Default;

public abstract class BattleLoc extends Location {

	protected Obstacle obstacle;
	protected String award;

	public BattleLoc(Player player, String name, Obstacle obstacle,String award) {
		super(player, name);
		this.name = name;
		this.obstacle = obstacle;
		this.award=award;
	}

	public boolean onLocation() {
		int obsCount = obstacle.Count();
		System.out.println("Şuan buradasınız: " + this.getName());
		System.out.println("Dikkatli Ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor");
		System.out.println("<S>avaş veya <K>aç :");
		String selCase = input.nextLine().toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " Bölgesindeki Tüm canavarları öldürdünüz!");
				if(this.award.equals("Food") && player.getInventory().isFood()==false) {
					System.out.println(this.award + " kazandınız!");
					player.getInventory().setFood(true);
				}
				else if(this.award.equals("Firewood") && player.getInventory().isFirewood()==false) {
					System.out.println(this.award + " kazandınız!");
					player.getInventory().setFirewood(true);;
				}
				else if(this.award.equals("Water") && player.getInventory().isWater()==false) {
					System.out.println(this.award + " kazandınız!");
					player.getInventory().setWater(true);
				}
				return true;
			} else {
				
			}if(player.getHealth()<=0) {
				System.out.println("Öldünüz!");
				return false;
			}
		}
		return true;

	}

	public boolean combat(int obscount) {
		for (int i = 0; i < obscount; i++) {
			int defObsHealth=obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya K<aç> :");
				String selHit = input.nextLine().toUpperCase();
				if (selHit.equals("V")) {
					System.out.println("Siz canavara vurdunuz");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("Canavar size vurdu");
						player.setHealth(
								player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmorBlock()));
						afterHit();
					}

				} else {
					return false;
				}
			}
			if(obstacle.getHealth() < player.getHealth()) {
				System.out.println("canavarı öldürdünüz!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Güncel Paranız :"+player.getMoney());
				obstacle.setHealth(defObsHealth);
			}else {
				return false;
			}
			System.out.println("--------------------------");

		}
		return true;
	}

	public void afterHit() {
		System.out.println("Oyuncunun Canı: " + player.getHealth());
		System.out.println(obstacle.getName() + "Canı: " + obstacle.getHealth());
		System.out.println();
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Oyuncu Değerleri");
		System.out.println("-----------------------------");
		System.out.println("Can: " + player.getHealth());
		System.out.println("Hasar: " + player.getTotalDamage());
		System.out.println("Para: " + player.getMoney());
		if (player.getInventory().getWeaponDamage() > 0) {
			System.out.println("Silah: " + player.getInventory().getWeaponName());
		}
		if (player.getInventory().getArmorBlock() > 0) {
			System.out.println("Block: " + player.getInventory().getArmorBlock());
		}

	}

	public void enemyStats() {
		System.out.println();
		System.out.println(obstacle.getName() + " Değerleri");
		System.out.println("-----------------------------");
		System.out.println("Can: " + obstacle.getHealth());
		System.out.println("Hasar: " + obstacle.getDamage());
		System.out.println("Ödül: " + obstacle.getAward());

	}

}
