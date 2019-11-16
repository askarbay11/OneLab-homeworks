package kz.onelab.Hw6.util;

import kz.onelab.Hw6.entity.Person;
import kz.onelab.Hw6.entity.Phone;
import kz.onelab.Hw6.repo.PersonRepo;
import kz.onelab.Hw6.repo.PhoneRepo;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class PersonGenerator {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PhoneRepo phoneRepo;

    @PostConstruct
    private void generate(){
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setName("Person" + i);
            person.setAge((int)(Math.random()*53) + 10);//generate age between 10 and 63
            personRepo.save(person);
            log.info("Inserted " + person + " at " + new Date());
            int quantityOfPhones = (int)(Math.random()*4);
            for (int j = 0; j < quantityOfPhones; j++) {
                Phone phone = new Phone();
                phone.setNumber(UUID.randomUUID().toString());
                phone.setPerson(person);
                phoneRepo.save(phone);
                log.info("Inserted " + phone + " at " + new Date());
            }
        }
    }
}
