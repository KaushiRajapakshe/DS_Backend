package com.example.sliit.ds.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sliit.ds.entities.Ticket;
import com.example.sliit.ds.service.TicketBookingService;

@RestController
public class TickectBookingController {

	@Autowired
	private TicketBookingService ticketService;
	
	@RequestMapping("/create")
	public String create(@RequestParam Integer ticketId, @RequestParam String passengerName, @RequestParam Date bookingDate, @RequestParam String sourceStation, 
			@RequestParam String destStation, @RequestParam String email){
		Ticket t = ticketService.create(ticketId, passengerName, bookingDate, sourceStation, destStation, email);
		return t.toString();
	}
	
	@RequestMapping("/get")
	public Ticket getTicket(@RequestParam Integer ticketId){
		return ticketService.getByTicketId(ticketId);
	}
	
	@RequestMapping("/getAll")
	public List<Ticket> getAll(){
		return ticketService.getAll();
	}
	
	@RequestMapping("/getPassenger")
	public List<Ticket> getPassenger(@RequestParam String passengerName){
		return ticketService.getByPassengerName(passengerName);
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Integer ticketId, @RequestParam String passengerName, @RequestParam Date bookingDate, @RequestParam String sourceStation, 
			@RequestParam String destStation, @RequestParam String email){
		Ticket t = ticketService.update(ticketId, passengerName, bookingDate, sourceStation, destStation, email);
		return t.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer ticketId){
		ticketService.delete(ticketId);
		return "Deleted "+ticketId;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll(){
		ticketService.deleteAll();
		return "Deleted All Records.";
	}
}
