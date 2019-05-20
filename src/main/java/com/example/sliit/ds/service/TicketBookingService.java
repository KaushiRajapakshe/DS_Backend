package com.example.sliit.ds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sliit.ds.entities.Ticket;

@Service("ticketService")
@Transactional
public interface TicketBookingService {
	Ticket findById(String tId);

	Ticket findByName(String name);

    List<Ticket> findPassengerName(String name);

    Optional<Ticket> findBookingDate(String date);

    void saveTicket(Ticket ticket);

    void updateTicket(Ticket ticketUpdate);

    void deleteTicketById(String tId);

    List<Ticket> findAllTicket();

    public boolean isFoodExist(Ticket ticket);
}
