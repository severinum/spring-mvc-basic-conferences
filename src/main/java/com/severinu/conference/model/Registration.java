package com.severinu.conference.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Registration {

    private String name;
    @NotNull
    @Max(20)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
