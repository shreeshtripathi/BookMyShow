package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;

    @ManyToMany
    private List<Actor> actors;

    @ManyToMany
    private List<Feature> movieFeatures;

    @ManyToMany
    private List<Genre> genres;
}
