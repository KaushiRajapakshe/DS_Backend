package com.example.sliit.ds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sliit.ds.entities.Ticket;
import com.example.sliit.ds.repository.TicketRepository;

@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketBookingService{

	
	@Autowired
    private TicketRepository ticketRepository;

    private static List<Ticket> ticket;
    
	@Override
	public Ticket findById(String tId) {
		return ticketRepository.findByTicketId(tId);
	}

	@Override
	public Ticket findByName(String name) {
		return ticketRepository.findByPassengerName(name);
	}

	@Override
	public List<Ticket> findPassengerName(String name) {
		Iterable<Ticket> foodIterable = (Iterable<Ticket>) ticketRepository.findByPassengerName(name);
        List<Ticket> foodList = new ArrayList<>();

        foodIterable.forEach(foodList::add);
        return foodList;
	}

	@Override
	public Optional<Ticket> findBookingDate(String date) {
		Optional<Ticket> foodIterable = ticketRepository.findByBookingDate(date);
        return foodIterable;
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
		
	}

	@Override
	public void updateTicket(Ticket ticketUpdate) {
		Ticket ticketExisting = findById(ticketUpdate.getTicketId());

        // update the item we retrieved.
        if (ticketExisting != null) {
        	ticketExisting.setSourceStation(ticketUpdate.getSourceStation());
        	ticketExisting.setPassengerName(ticketUpdate.getPassengerName());
        	ticketExisting.setPassengerName(ticketUpdate.getPassengerName());
        	ticketExisting.setDestStation(ticketUpdate.getDestStation());
        	ticketExisting.setEmail(ticketUpdate.getEmail());
            saveTicket(ticketExisting);
        }
		
	}

	@Override
	public void deleteTicketById(String tId) {
		ticketRepository.findByTicketId(tId);
		
	}

	@Override
	public List<Ticket> findAllTicket() {
		return (List<Ticket>) ticketRepository.findAll();
	}

	@Override
	public boolean isFoodExist(Ticket ticket) {
		return ticketRepository.exists(ticket.getTicketId());
	}

	public double getPriceOf(String tId) {
		Ticket ticket = new Ticket();
		return ticket.getPriceOf(tId);
	}

}
