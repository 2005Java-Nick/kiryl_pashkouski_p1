package main.pashkouski.kiryl.p1.domain;

public class Request {

	private String lastName;
	private String firstName;
	private String event_name;
	private String date;
	private String requested_amount;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEventName() {
		return event_name;
	}
	public void setEventName(String event_name) {
		this.event_name = event_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRequestedAmount() {
		return requested_amount;
	}
	public void setRequestedAmount(String requested_amount) {
		this.requested_amount = requested_amount;
	}
	
	
}
