package backend;



public class OutdoorsArea extends Location {
	
	private String weather;

	public OutdoorsArea(String name, String longDesc, String shortDesc, String weather) {
		super(name, longDesc, shortDesc);
		this.weather = weather;
	}
	

	
	public void describeYourself() {
		System.out.println("It is " + weather);
		super.describeYourself();
	}
		
	
	public void getKey() {
		
		for (java.lang.String key: getExits().keySet()) {
		System.out.println("There is a path leading " + key);
		}	
	}	
	
	public void doCommand() {
		
	}
}
