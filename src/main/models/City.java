package main.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;

    @OneToMany
    private List<Theatre> theatres;
}
