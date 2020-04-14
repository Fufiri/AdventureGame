package backend;

import java.util.Scanner;

public class Game {

	private Player user;

	public Game() {

		OutdoorsArea field = new OutdoorsArea(
				"Centre of Town",
				"You stand in the middle of nowhere, your dragon is lost and you need to find him.",
				"You are back at the field", "Sunny");
		OutdoorsArea forrest = new OutdoorsArea(
				"The spooky forrest",
				"This forest feels very spooky and you don't really want to stay here. Hopefully you can leave soon.",
				"You are back at the forest (oh god why)", "Full of mist");
		Room home = new Room(
				"Home sweet home",
				"You are home, this is where you grew up. There's noone around",
				"You are back home", 50);
		Room bar = new Room(
				"Jungle Juice",
				"The local bar is kinda dead. There's no people around. Maybe there's some usefull stuff here",
				"You are back at the bar", 200);
		Room dragonPrison = new Room(
				"Behind bars",
				"Dragon Prison of doom. Your dragon is behind bars! Oh no! Save it! The door is locked.",
				"You are back at the dragon prison, the door is still locked.",
				600);
		WearableItem knife = new WearableItem("Knife", 2.0, 1);
		Torch torch = new Torch("Torch", 1.2);
		Key prisonKey = new Key("Key", 0.1);
		WearableItem cloak = new WearableItem("Lucky_Cloak", 5.0, 20);
		WearableItem amulet = new WearableItem("Amulet", 0.5, 10);

		field.setExit("west", forrest);
		field.setExit("south", bar);
		field.setExit("east", home);
		field.setExit("north", dragonPrison);
		field.addItem(cloak);

		forrest.setExit("east", field);
		forrest.addItem(amulet);

		home.setExit("west", field);
		home.addItem(prisonKey);

		bar.setExit("north", field);
		bar.addItem(torch);

		dragonPrison.setExit("south", field);
		dragonPrison.addItem(knife);

		user = new Player("name", field, 100);

	}

	public void run() {

		System.out.println("Welcome to the game! ");
		System.out.println("What is your name? ");

		Scanner kbd = new Scanner(System.in);
		user.setName(kbd.nextLine());
		while (user.getName().equals("help")) {
			user.getHelp();
			user.setName(kbd.nextLine());
		}

		System.out.println("Hello " + user.getName());
		System.out.println("Welcome to VÄRLDEN. ");

		user.getPosition().describeYourself();
		// Kommentar: Bra game-llop! Mycket bra att ni delegerar vidare
		// kommandot till users doCommand.
		while (user.hasMovementOptions()) {
			System.out.println("What do you want to do?");
			String in = (kbd.nextLine());
			if (in.equals("help")) {
				user.getHelp();
			} else {
				user.doCommand(in, user);
			}
						
		}

		kbd.close();
	}

}
