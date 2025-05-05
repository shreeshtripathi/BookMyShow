package main.dto;

import lombok.Getter;
import lombok.Setter;
import main.models.Ticket;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
}
