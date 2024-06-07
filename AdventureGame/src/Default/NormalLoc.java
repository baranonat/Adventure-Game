package Default;

public abstract class NormalLoc extends Location{

	public NormalLoc(Player player,String name) {
		super(player, name);
		this.name=name;
	}
  public boolean onLocation() {
	return true;
	 
 }
}
