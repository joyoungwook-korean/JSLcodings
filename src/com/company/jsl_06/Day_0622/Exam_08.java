package com.company.jsl_06.Day_0622;

import java.util.Objects;

class Person{
    String name;
    int bun;
    int age;

    public Person() {
    }

    public Person(int bun, String name,  int age) {
        this.name = name;
        this.bun = bun;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return bun == person.bun && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bun);
    }
}

public class Exam_08 {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person(1,"김학생",28);
        Person p3 = new Person(1,"김학생",30);
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p1.hashCode());
    }
}
