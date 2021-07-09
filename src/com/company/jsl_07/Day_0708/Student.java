package com.company.jsl_07.Day_0708;

import java.util.Objects;

public class Student implements Comparable<Student>{
    int num;
    String name;
    int kor,eng,mat;

    public Student(int num, String name, int kor, int eng, int mat) {
        this.num = num;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return num == student.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }



    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        if(num== o.num){
            System.out.println("같은 객체 입니다.");
            return 0;
        }else{
            return Integer.compare(num,o.num);
        }
    }
}
