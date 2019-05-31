package com.spring.cloud.person;

import com.spring.cloud.person.dao.PersonRepository;
import com.spring.cloud.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName) {
        Person p = new Person(personName);
        personRepository.save(p);

        List<Person> personList = personRepository.findAll(PageRequest.of(0, 10)).getContent();

        return personList;
    }
}
