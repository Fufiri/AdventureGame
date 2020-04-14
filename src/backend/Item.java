package backend;

public abstract class Item {

	private String name;
	private Double weight;

	public Item(String name, Double weight) {
		this.name = name;
		this.weight = weight;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public abstract void Use(String in, Player user);

	public void printYourself() {
		System.out.println(name + "(" + weight + " kgs)" );
	}

	public boolean isInInventory(Player user, Item item) {
		if (user.getInventoryList().contains(item)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLocatedAt(Location pos) {
		if (pos.getItems().contains(this)) {
			return true;
		} else {
			return false;
		}
	}

	//TODO: Komplettering: Om denna inte ska göra något, bör den inte vara abstrakt då eller inte existera? x

	public void doCommand(String in, Player user) {

		if(!in.contains("take")) {
			return;
		}

		String[] parts = in.split(" ", 2);

		if(in.equals("take"))  {
			System.out.println("you need a second word");
			return;
		}

		String targetItemName = parts[1];

		if(!this.getName().equals(targetItemName)) {
			//the command was meant for another item; ignore it and return.
			return;
		}

		if(this.isInInventory(user, this)) {
			System.out.println(this.getName() +" is already in your backpack, no need to pick it up again!");
			return;
		}

		if(!this.isLocatedAt(user.getPosition())) {
			System.out.println("You look around, but can't find a "+ this.getName() +" at your current location!");
			return;
		}

		user.addItem(user.getInventoryList(), this);
		user.getPosition().removeItem(this);

		System.out.println("You picked up " + this.getName() + "!");
	}
}