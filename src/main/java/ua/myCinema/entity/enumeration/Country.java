package ua.myCinema.entity.enumeration;

public enum Country {
	
	UKRAINE("Україна"), POLAND("Польща"), GERMANY("Німеччина"), GREECE("Греція"), ITALY("Італія"),
	ENGLAND("Англія"), USA("США"), AUSTRALIA("Австралія"), UNKNOWN("Немає");
	
	private String val;
	
	Country(String val){
		this.val = val;
	}
	
	public String val() {
		return val;
	}
}
