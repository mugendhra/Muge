package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.repository.TicketRepo;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    public Ticket addTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElse(null);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = ticketRepo.findById(id).orElse(null);
        if (ticket != null) {
            ticket.setTitle(updatedTicket.getTitle());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
            ticket.setPriority(updatedTicket.getPriority());
            return ticketRepo.save(ticket);
        }
        return null;
    }
}
