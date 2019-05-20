package com.example.sliit.ds.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sliit.ds.config.Config;
import com.example.sliit.ds.entities.Ticket;
import com.example.sliit.ds.repository.TicketRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = Config.allowedOrigin)
public class TickectBookingController {

	@Autowired
	private TicketRepository ticketRepository;

	// Retrieve operation
	@RequestMapping(method=RequestMethod.GET, value="/tickets")
    public Iterable<Ticket> ticket() {
        return ticketRepository.findAll();
    }
	
	// Create operation
    @RequestMapping(method=RequestMethod.POST, value="/tickets")
    public Ticket save(@RequestBody Ticket ticket) {
    	ticketRepository.save(ticket);

        return ticket;
    }

    @RequestMapping(method=RequestMethod.GET, value="/tickets/{id}")
    public Ticket show(@PathVariable String id) {
        return ticketRepository.findByTicketId(id);
    }

    // Update operation
    @RequestMapping(method=RequestMethod.PUT, value="/tickets/{id}")
    public Ticket update(@PathVariable String id, @RequestBody Ticket ticket) {
       Ticket optticket = ticketRepository.findByTicketId(id);
        Ticket t = optticket;
        if(ticket.getPassengerName() != null)
            t.setPassengerName(ticket.getPassengerName());
        if(ticket.getBookingDate() != null)
            t.setBookingDate(ticket.getBookingDate());
        if(ticket.getSourceStation() != null)
            t.setSourceStation(ticket.getSourceStation());
        if(ticket.getDestStation() != null)
            t.setDestStation(ticket.getDestStation());
        if(ticket.getEmail() != null)
            t.setEmail(ticket.getEmail());
        ticketRepository.save(t);
        return t;
    }

    // Delete operation
    @RequestMapping(method=RequestMethod.DELETE, value="/tickets/{id}")
    public String delete(@PathVariable String id) {
        //Ticket optticket = ticketRepository.findByTicketId(id);
        //ticketRepository.delete(optticket);

        return "";
    }
}
