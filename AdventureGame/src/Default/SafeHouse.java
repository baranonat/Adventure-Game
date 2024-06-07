package Default;

public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player,"Güvenli Ev");
	}
	
	 public boolean onLocation() {
		 	player.setHealth(player.getRhealth());	
		 	System.out.println("Güvenli Evdesiniz!!!");
		 	System.out.println("Canınız yenilendi!");
		 	 return true;
			 
		 }

}
