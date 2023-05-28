package ticket;

import java.sql.Date;

public class TicketReqBean {
	private String name;
	private String email;
	private String eventName;
	private int noOfTickets;
	private String payMethod;
	private String ticketId;
	private Date ticketDate;

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "TicketReqBean [name=" + name + ", email=" + email + ", eventName=" + eventName + ", noOfTickets="
				+ noOfTickets + ", payMethod=" + payMethod + ", ticketId=" + ticketId + ", ticketDate=" + ticketDate
				+ "]";
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}
