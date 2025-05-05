package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    @ManyToOne
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private Double amount;
    private String referenceId;

    @ManyToOne
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;
}
