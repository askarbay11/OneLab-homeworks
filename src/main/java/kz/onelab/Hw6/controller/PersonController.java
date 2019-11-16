package kz.onelab.Hw6.controller;

import kz.onelab.Hw6.entity.Person;
import kz.onelab.Hw6.entity.Phone;
import kz.onelab.Hw6.repo.PersonRepo;
import kz.onelab.Hw6.repo.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PersonController {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PhoneRepo phoneRepo;

//    @Autowired
//    public PersonController(PersonRepo repo) {
//        personRepo = repo;
//    }

    @PostMapping("/persons")
    Person savePerson(@RequestParam String name, @RequestParam int age){
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return personRepo.save(person);
    }

    @GetMapping("/persons")
    Iterable<Person> findByName(@RequestParam String name) {
            return personRepo.findByName(name);
    }

    @GetMapping("/persons/find")
    Iterable<Person> findByEnding(@RequestParam String end) {
        return personRepo.findByNameEndingWith(end);
    }

    @GetMapping("/persons/getSoldiers")
    Iterable<Person> findSoldiers() {
        return personRepo.findByAgeBetween(18, 27);
    }

    @GetMapping("/persons/getPhoneById")
    Iterable<Phone> findPhones(@RequestParam long id) {
        return phoneRepo.findPhonesByPersonId(id);
    }

    @GetMapping("/persons/getTimeWhenGetAll")
    Long getTime() {
        Long startTime = new Date().getTime();
        Iterable<Person> persons = personRepo.findAll();
        Long endTime = new Date().getTime();
        return endTime - startTime;
    }

}
