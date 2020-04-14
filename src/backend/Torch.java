package backend;

public class Torch extends Tool {

	public Torch(String name, double weight) {
		super(name, weight);
	}

	//TODO: Komplettering: 
	@Override
	public void doCommand(String in, Player user) {
		 if(in.contains("take")) {
	            super.doCommand(in, user);
	            this.Use(in, user);
	            return;
	     }
	 }
		

	@Override
	public void Use(String in, Player user) {
		System.out.println("You lit your torch, things look brighter");
		
	}





}
