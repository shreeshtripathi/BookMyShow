package main.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String email;
}
