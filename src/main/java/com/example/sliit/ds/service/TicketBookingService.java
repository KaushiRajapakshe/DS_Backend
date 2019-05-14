package com.example.sliit.ds.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sliit.ds.entities.Ticket;
import com.example.sliit.ds.repository.TicketRepository;

@Service
public class TicketBookingService {
	@Autowired
	private TicketRepository ticketRepository;

	// Create operation
	public Ticket create(Integer ticketId, String passengerName, Date bookingDate, String sourceStation, 
			String destStation, String email) {
		return ticketRepository.save(new Ticket(ticketId, passengerName, bookingDate, sourceStation, 
				destStation, email));
	}

	// Retrieve operation
	public List<Ticket> getAll() {
		return ticketRepository.findAll();
	}

	public List<Ticket> getByPassengerName(String passengerName) {
		return ticketRepository.findByPassengerName(passengerName);
	}

	public Ticket getByTicketId(Integer ticketId) {
		return ticketRepository.findByTicketId(ticketId);
	}
	
	// Update operation
	public Ticket update(Integer ticketId, String passengerName, Date bookingDate, String sourceStation, 
			String destStation, String email) {
		Ticket t = ticketRepository.findByTicketId(ticketId);
		t.setPassengerName(passengerName);
		t.setBookingDate(bookingDate);
		t.setEmail(email);
		t.setDestStation(destStation);
		t.setSourceStation(sourceStation);
		return ticketRepository.save(t);
	}

	// Delete operation
	public void deleteAll() {
		ticketRepository.deleteAll();
	}

	public void delete(Integer ticketId) {
		Ticket t = ticketRepository.findByTicketId(ticketId);
		ticketRepository.delete(t);
	}
}
