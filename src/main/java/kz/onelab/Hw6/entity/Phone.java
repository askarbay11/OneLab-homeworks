package kz.onelab.Hw6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;
    private String number;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonIgnore
    private Person person;
}
