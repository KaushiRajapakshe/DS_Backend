package com.example.sliit.ds.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {

	@Id
	private String ticketId;
	private String passengerName;
	private Date bookingDate;
	private String sourceStation;
	private String destStation;
	private String email;
	private double price;
	
	public Ticket() {}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
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
	
	public double getPriceOf(String ticketId){
		return price;
	}
	@Override
	public String toString(){
		return "Ticket [ticketId = "+ticketId+", passengerName = "+passengerName+", bookingDate = "+bookingDate+", sourceStation = "+sourceStation+", destStation = "+destStation+", email = "+email+"]";
	}
}
