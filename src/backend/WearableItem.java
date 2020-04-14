package backend;

public class WearableItem extends Item {

	private int effect;
	
	public WearableItem(String name, double weight, int effect) {
		super(name, weight);
		this.effect = effect;
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public void Use(String in, Player user) {	
		user.setHealth(user.getHealth()+effect);
		System.out.println("Current health: " + user.getHealth());
	}


	//TODO: Komplettering: Se komplettering i Player. Här bör vi hantera när input är lika med wear.
	public void doCommand(String in, Player user) {
		if (in.contains("take")) {
			super.doCommand(in, user);
			return;
		}

		if (!in.contains("wear")) {
			//incompatible command; return.
			return;
		}
		if (in.equals("wear")) {
			System.out.println("You need a second word");
			return;
		}

		if (!this.isInInventory(user, this)) {
			System.out.println("You tried to wear " + this.getName() + ", but noticed you don't have it in your backpack! Oops!");
			return;
		}

		user.addItem(user.getWearingList(), this);
		user.removeItem(user.getInventoryList(), this);

		System.out.println("You are now wearing " + this.getName());
		this.Use(in, user);
		}
}

	
	
	
	

	

			
	
	
	

