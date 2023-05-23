package com.example.ebook.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Person {

    private long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private int age;

    public Person() {
    }

    @JsonCreator
    public Person(@JsonProperty("id") final Long id,
                    @JsonProperty("name") final String name,
                    @JsonProperty("lastName") final String lastName,
                    @JsonProperty("email") final String email,
                    @JsonProperty("password") final String password,
                    @JsonProperty("age") final int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, password, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
