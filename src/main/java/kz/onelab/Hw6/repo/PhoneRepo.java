package kz.onelab.Hw6.repo;

import kz.onelab.Hw6.entity.Phone;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepo extends ElasticsearchRepository<Phone, Long> {
    Iterable<Phone> findPhonesByPersonId(long personId);
}
