package main.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id // used to define Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

