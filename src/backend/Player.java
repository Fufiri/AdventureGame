package backend;

import java.util.Map.Entry;
import java.util.ArrayList;

public class Player {

	private String name;
	private Location position;
	private int health;
	private static ArrayList<Item> inventoryList;
	private ArrayList<Item> wearingList;

	public Player(String name, Location position, int health) {
		this.name = name;
		this.position = position;
		this.health = health;
		inventoryList = new ArrayList<Item>();
		wearingList = new ArrayList<Item>();

	}

	public void getHelp() {
		System.out.println("Choose one of the paths by typing the direction.");
		System.out
				.println("If you choose the wrong direction we will let you know and your health will get lower");
		System.out
				.println("You can pick up items with TAKE, and wear items with WEAR");
		System.out.println("Use LOOK to look around you.");
	}

	public ArrayList<Item> getInventoryList() {
		return inventoryList;
	}

	public ArrayList<Item> getWearingList() {
		return wearingList;
	}

	public void listItems() {

		if (inventoryList.isEmpty())
			System.out.println("No items in inventory");

		if (wearingList.isEmpty())
			System.out.println("Not wearing anything");

		for (Item str : inventoryList) {
			System.out.println("Your existing items: ");
			str.printYourself();
		}

		for (Item wearing : wearingList) {
			System.out.println("Your worn items: ");
			wearing.printYourself();
		}
	}

	public void addItem(ArrayList<Item> input, Item item) {
		input.add(item);
	}

	public void removeItem(ArrayList<Item> input, Item item) {
		input.remove(item);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Boolean isAlive() {
		if (health <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void quitGame() {
		System.exit(0);
	}

	public int getHealth() {
		return health;
	}

	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

	public Boolean hasMovementOptions() {
		return getPosition().getExits().values().size() > 0;
	}
	
			// TODO: Komplettering: Att hantera kommandot wear bör göras i en
			// doCommand för WearableItem-klassen. Det är att använda sig av
			// polymorfi på ett korrekt sätt: vi kan ha en metod med samma namn,
			// fast med olika funktionalitet beroende på vilken klass det är.
	


	// (!(itemObj instanceof WearableItem))

	public void tryMoveTo(String in) {

		Location targetPosition = null;
		for (Entry<String, Location> entry : this.position.getExits()
				.entrySet()) {
			if (entry.getKey().equals(in)) {
				targetPosition = entry.getValue();
				break;
			}
		}

		if (targetPosition == null) {
			System.out
					.println("you can't move in that direction from your current location!");
			System.out
					.println("You lost 10 health points because you hit your face in an invisible wall");
			setHealth(health - 10);
			System.out.println("Current health: " + health);
			if (isAlive() == false) {
				System.out.println("GAME OVER!");
				quitGame();
			}
		} else {
			setPosition(targetPosition);
			System.out.println("you've moved " + in + "!");
			targetPosition.describeYourself();
		}
	}

	public void doCommand(String in, Player user) {

		
		if(in == null || in == "") {
			System.out.println("invalid input.");
			return;
		}

		for (Item item : new ArrayList<>(inventoryList)) {
			item.doCommand(in, user);
		}

		for (Item item : new ArrayList<>(user.getPosition().getItems())) {
			item.doCommand(in, user);
		}

		if (in.equals("items")) {
			user.listItems();

			// TODO: Komplettering: Att agera på kommandot unlock är något som
			// bör utföras i en doCommand i er Key-klass.

		} else if (in.equals("look")) {
			System.out.println(position.getShortDesc());
			position.getKey();
			position.getItemName();

		} else if(in.equals("north") || in.equals("east") || in.equals("south") || in.equals("west")){
			tryMoveTo(in);
		//} else {
			// Kommandot finns inte eller har blivit hanterat av ett item.

			}
		}


//		for (Item it : inventoryList) {
//			it.doCommand(in, user, item);
//		}
		//	inventoryList.contains(this)
	}
