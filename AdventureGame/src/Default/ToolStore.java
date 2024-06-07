package Default;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Mağaza");

	}

	public boolean onLocation() {
		System.out.println("Para :" + player.getMoney());
		System.out.println("1- Silahlar");
		System.out.println("2- Zırhlar");
		System.out.println("3- Çıkış");
		System.out.print("Seçiminiz: ");
		int selMenu = input.nextInt();
		int selItemID;
		switch (selMenu) {
		case 1:
			selItemID = menuWeapon();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = menuArmor();
			buyArmor(selItemID);
			break;
		}

		return true;
	}

	public int menuWeapon() {
		System.out.println("1- Tabanca\t <Para : 25 - Hasar : 2>");
		System.out.println("2- Kılıç\t <Para : 35 - Hasar : 3>");
		System.out.println("3- Tüfek\t <Para : 45 - Hasar : 7>");
		System.out.println("4- Çıkış");
		System.out.print("Silah Seçiminiz: ");
		int selWeapon = input.nextInt();
		while (selWeapon < 1 || selWeapon > 4) {
			System.out.print("Geçersiz İşlem :");
			selWeapon = input.nextInt();
		}
		return selWeapon;

	}

	public void buyWeapon(int selItemID) {

		int damage = 0, price = 0;
		String wName = null;

		switch (selItemID) {
		case 1:
			damage = 2;
			price = 5;
			wName = "Tabanca";
			break;
		case 2:
			damage = 3;
			price = 35;
			wName = "Kılıç";
			break;
		case 3:
			damage = 7;
			price = 45;
			wName = "Tüfek";
			break;
		case 4:
			System.out.println("Çıkış yapılıyor...");
			break;

		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInventory().setWeaponDamage(damage);
				player.getInventory().setWeaponName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " Satın aldınız!, Önceki Hasar: " + player.getDamage() + " Yeni Hasar :"
						+ player.getTotalDamage());
			} else {
				System.out.println("Para yetersiz!");
			}

		}

	}
	public int menuArmor() {
		System.out.println("1- Hafif <Para : 15 - Block : 1>");
		System.out.println("2- Orta\t <Para : 25 - Block : 3>");
		System.out.println("3- Ağır\t <Para : 40 - Block : 5>");
		System.out.println("4- Çıkış");
		System.out.print("Zırh Seçiminiz: ");
		int SelArmor = input.nextInt();
		while (SelArmor < 1 || SelArmor > 4) {
			System.out.print("Geçersiz İşlem :");
			SelArmor = input.nextInt();
		}
		return SelArmor;
		
	}
	public void buyArmor(int selItemID) {
		int block = 0, price = 0;
		String aName = null;

		switch (selItemID) {
		case 1:
			block = 1;
			price = 15;
			aName = "Hafif";
			break;
		case 2:
			block = 3;
			price = 25;
			aName = "Orta";
			break;
		case 3:
			block = 5;
			price = 40;
			aName = "Ağır";
			break;
		case 4:
			System.out.println("Çıkış yapılıyor...");
			break;

		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setArmorBlock(block);;
				player.getInventory().setArmorName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " Satın aldınız!,  Bloklama: " + player.getInventory().getArmorBlock());
				System.out.println("Kalan Para : "+ player.getMoney());
						
			} else {
				System.out.println("Para yetersiz!");
			}

		}

	}

}
