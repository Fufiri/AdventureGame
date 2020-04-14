package backend;

public abstract class Tool extends Item {

	public Tool(String name, double weight) {
		super(name, weight);
	}

	// TODO: Komplettering: För denna klassen och dess subklasser. doCommand för
	// dessa ska hantera och agera på det kommando som matchar dem (t ex
	// "light torch", "use ...", osv). 
	public void doCommand(String in, Player user) {
		super.doCommand(in, user);
	}

	public abstract void Use(String in, Player user);

}
