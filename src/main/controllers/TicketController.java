package main.controllers;

import main.dto.BookTicketRequestDto;
import main.dto.BookTicketResponseDto;
import main.exceptions.ShowSeatNotFoundException;
import main.models.Ticket;
import main.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto)
            throws ShowSeatNotFoundException  {
        Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds(),
                bookTicketRequestDto.getUserId(), bookTicketRequestDto.getShowId());

        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        responseDto.setTicket(ticket);
        return responseDto;
        //return null;
    }
}
