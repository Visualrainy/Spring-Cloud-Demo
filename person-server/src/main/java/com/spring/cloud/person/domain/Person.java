package com.spring.cloud.person.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    public Person(String name) {
        super();
        this.name = name;
    }
}
