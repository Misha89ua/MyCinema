package ua.myCinema.entity.enumeration;

public enum Category {
	
	ACTION("Бойовик"), DRAMA("Драма"), FANTASTIC("Фантастика"), FANTASY("Фентезі"), UNKNOWN("Немає");
	
	private String val;
	
	Category(String val){
		this.val = val;
	}
	
	public String val() {
		return val;
	}

}
