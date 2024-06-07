package Default;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	
	Scanner input=new Scanner(System.in);
	
	public void start() {
		System.out.println("Macera oyununa Hoşgeldiniz!");
		System.out.println("Lüften bir isim giriniz");
		//String playerName=input.nextLine();
		player=new Player("Baran");
		System.out.println("Hoşgeldiniz " + player.getName());
		player.selectCha();
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		while(true) {
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz :");
			System.out.println("1- Güvenli Ev--> Size ait güvenli bir mekan,düşman yoktur!");
			System.out.println("2- Mağara--> Karşınıza belki zombi çıkabilir.Dikkatli olun!");
			System.out.println("3- Orman--> Karşınıza belki vampir çıkabilir.Dikkatli olun!");
			System.out.println("4- Nehir--> Karşınıza belki ayı çıkabilir.Dikkatli olun!");
			System.out.println("5- Mağaza--> Silah veya Zırh satın alabilirsiniz");
			System.out.print("Gitmek istediğiniz yer:");
			int selectLoc=input.nextInt();
			while(selectLoc<0 || selectLoc>5) {
				System.out.print("Lütfen doğru seçim yapınız:");
				selectLoc=input.nextInt();
			}
			switch(selectLoc) {
			case 1:
				location =new SafeHouse(player); 
				break;
			case 2:
				location =new Cave(player); 
				break;
			case 3:
				location =new Forest(player);
				break;
			case 4:
				location =new River(player);
				break;
			case 5:
				location =new ToolStore(player);
				break;
				default:
					location =new SafeHouse(player);
					break;
					
			}
			if(location.getName()=="Güvenli Ev") {
				if(player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()) {
					System.out.println("Tebrikler! Oyunu Kazandınız");
					break;
				}	
			}
			if(!location.onLocation()) {
				System.out.println("Game over");
				break;
			}
			
			
		}
		
		
	}
	

}
