package com.company.jsl_07.Day_0706.Test;

import java.util.Objects;

public class Student {
    private int hakbun;
    private String name;

    public Student(int hakbun, String name) {
        this.hakbun = hakbun;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return hakbun == student.hakbun && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hakbun, name);
    }

    /*
        @Override
        public boolean equals(Object o) {
            if(o instanceof Student){
                Student student = (Student) o;
                return hakbun == student.hakbun && name.equals(student.name);
            }else{
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(hakbun, name);
        }
    */
    @Override
    public String toString() {
        return "Student{" +
                "hakbun=" + hakbun +
                ", name='" + name + '\'' +
                '}';
    }

}
