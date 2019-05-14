package com.example.sliit.ds.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sliit.ds.entities.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{
	public Ticket findByTicketId(Integer ticketId);
	public List<Ticket> findByPassengerName(String passengerName);
}
