package com.example.sliit.ds.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {

	@Id
	private Integer ticketId;
	private String passengerName;
	private Date bookingDate;
	private String sourceStation;
	private String destStation;
	private String email;
	
	public Ticket(int ticketId2, String passengerName2, Date bookingDate2, String sourceStation2, String destStation2,
			String email2) {
		this.ticketId = ticketId2;
		this.passengerName = passengerName2;
		this.bookingDate = bookingDate2;
		this.sourceStation = sourceStation2;
		this.destStation = destStation2;
		this.email = email2;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}
	public String getDestStation() {
		return destStation;
	}
	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString(){
		return "Ticket [ticketId = "+ticketId+", passengerName = "+passengerName+", bookingDate = "+bookingDate+", sourceStation = "+sourceStation+", destStation = "+destStation+", email = "+email+"]";
	}
}
