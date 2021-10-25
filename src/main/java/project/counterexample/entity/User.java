package project.counterexample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity{

    @GeneratedValue @Id
    private Long userId;
    private String name;

}
