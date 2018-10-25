package wp.model;

public class GuestBookEntry {
	private String name;
	private String message;
	public GuestBookEntry() {}
	public GuestBookEntry(String name, String message)
	{
		this.name=name;
		this.message=message;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
