package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @ManyToOne
    private SeatType seatType;

    private int row;
    private int column;

    @ManyToOne
    private SeatStatus seatStatus;

}
