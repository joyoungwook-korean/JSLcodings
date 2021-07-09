package com.company.jsl_07.Day_0708;

import java.util.Set;
import java.util.TreeSet;

public class PersonExam {
    public static void main(String[] args) {
        TreeSet<Person> set = new TreeSet<>();
        set.add(new Person("김학생",30));
        set.add(new Person("이학생",19));
        set.add(new Person("살학생",22));
        set.add(new Person("오학생",23));
        for(Person person : set){
            System.out.println(person);
        }

    }
}
