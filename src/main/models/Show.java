package main.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
     @ManyToOne
     private Movie movie;

     private Date startTime;
     private Date endTime;

     @ManyToOne
     private Auditorium auditorium;

     @ElementCollection
     @Enumerated(EnumType.ORDINAL)
     private List<Feature> showFeatures;
}
