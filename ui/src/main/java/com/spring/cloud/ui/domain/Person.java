package com.spring.cloud.ui.domain;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    public Person() {
        super();
    }

    public Person(String name) {
        super();
        this.name = name;
    }
}
