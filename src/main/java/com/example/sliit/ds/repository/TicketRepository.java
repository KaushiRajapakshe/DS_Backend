package com.example.sliit.ds.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sliit.ds.entities.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String>{
	@Override
	void delete(Ticket deleted);
	Ticket findByTicketId(String ticketId);
	Ticket findByPassengerName(String name);
	Optional<Ticket> findByBookingDate(String date);
}
