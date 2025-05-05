package main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String email;
}
