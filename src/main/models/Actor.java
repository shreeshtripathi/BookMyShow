package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Actor extends BaseModel {
    private String name;
}
