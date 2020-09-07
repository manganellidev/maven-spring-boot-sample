package org.manganellidev.spring.boot.person;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {}
