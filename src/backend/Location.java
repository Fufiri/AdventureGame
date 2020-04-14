package backend;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Location {

	private String name, longDesc, shortDesc;
	private HashMap<String, Location> exits;
	private ArrayList<Item> itemList;
	private boolean visited = false;

	public Location(String name, String longDesc, String shortDesc) {
		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		this.exits = new HashMap<String, Location>();
		itemList = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public void removeItem(Item item) {
		itemList.remove(item);
	}

	public ArrayList<Item> getItems() {
		return itemList;
	}

	public void getItemName() {
		for (Item obj : itemList) {
			if (obj != null) {
				System.out.println("These items are around: ");
				System.out.println(obj.getName());
			}
		}

	}

	public abstract void getKey();

	public HashMap<String, Location> getExits() {
		return exits;
	}

	public void setExit(String s, Location l) {
		exits.put(s, l);
	}

	// TODO: Komplettering: Det känns som att det finns gemensamma delar för
	// describeYourself i OutdoorsArea och Room. Dessa bör ligga i
	// describeYourself i Location. x
	public void describeYourself() {
		System.out.println("You are in " + getName());
		
		if (visited == false) {
			System.out.println(getLongDesc());
			getKey();
			System.out.println(" ");
			getItemName();
			visited = true;
		}
		else if (visited) {
			System.out.println(getShortDesc());
			getKey();
			System.out.println(" ");
			getItemName();
		}
	}
	

	public abstract void doCommand();

	public String getName() {
		return name;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

}
