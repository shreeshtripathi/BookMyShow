package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class Ticket extends BaseModel {
    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;
    private Double totalAmount;

    @ManyToOne
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

    @OneToMany(mappedBy="ticket")
    private List<Payment> payments;
}
