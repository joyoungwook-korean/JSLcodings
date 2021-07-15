package com.company.jsl_07.Day_0709.trema;

public class Student implements Comparable<Student>{
    private int bun;
    private String name;


    public Student() {
    }

    public Student(int bun, String name) {
        this.bun = bun;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(bun,o.bun);
    }

    @Override
    public String toString() {
        return "Student{" +
                "bun=" + bun +
                ", name='" + name + '\'' +
                '}';
    }
}
