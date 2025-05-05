package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

     @ManyToMany
     private List<Feature> showFeatures;
}
