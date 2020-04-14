package backend;

public class Key extends Tool {

	public Key(String name, double weight) {
		super(name, weight);
	
	}

	@Override
	public void Use(String in, Player user) {
		
		if (user.getPosition().getName() !=("Behind bars")) {
			System.out.println("You can't use the key here");
		}
		
		if (user.getPosition().getName().equals("Behind bars")) {
		System.out.println("You unlocked the door");
		System.out.println("YOU WON");
		user.quitGame();						
		}	
	}

	@Override
	public void doCommand(String in, Player user) {
	 
        if (in.contains("take")) {
            //"take" command is handled by base implementation.
            super.doCommand(in, user);
            return;
        }

        if (!in.contains("unlock")) {
            //incompatible command; return.
            return;
        }

        if (!user.getInventoryList().contains(this)) {
            System.out.println("Can't use key; it's not in the inventory.");
            return;
        }

        this.Use(in, user);
    }
}

