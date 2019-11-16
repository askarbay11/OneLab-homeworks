package kz.onelab.Hw6.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;
    private String name;
    private int age;
//    @OneToMany(mappedBy = "person")
//    private Set<Phone> phones;

}
