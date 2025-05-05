package main.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // create a table for this entity
@Setter
@Getter
public class Actor extends BaseModel {
    private String name;
}
