package org.manganellidev.spring.boot.person;

import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    Person toPerson(PersonView personView);

    PersonView toPersonView(Person person);

    List<PersonView> toPersonView(Iterable<Person> personList);
}
