package backend;

public class Room extends Location {
	
	private int size;
	private boolean visited = false;
	
	public Room(String name, String longDesc, String shortDesc, int size) {
		super(name, longDesc, shortDesc);
		this.size = size;
	}
	
	
	public void describeYourself() {
		System.out.println("The room you are standing in is " + size + "square meters big");
		super.describeYourself();
		
	}
	
	
	public void getKey() {
			
		for (java.lang.String key: getExits().keySet()) {
		System.out.println("There is a door leading " + key);
			}
		}
	
	
	public void doCommand() {
		
	}

}
