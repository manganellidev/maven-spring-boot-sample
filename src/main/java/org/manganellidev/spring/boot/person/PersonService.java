package org.manganellidev.spring.boot.person;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonView> findAll() {
        return personMapper.toPersonView(personRepository.findAll());
    }

    public PersonView findById(UUID id) throws Exception {
        return personMapper.toPersonView(personRepository.findById(id).orElseThrow(
            () -> new Exception("Person not found.")));
    }

    public PersonView save(PersonView personView) {
        Person newPerson = personMapper.toPerson(personView);
        newPerson.setId(UUID.randomUUID());
        return personMapper.toPersonView(personRepository.save(newPerson));
    }
}
