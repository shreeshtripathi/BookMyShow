package main.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;
    private int column;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

}
