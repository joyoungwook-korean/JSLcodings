package com.company.jsl_07.Day_0706.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Student,Score> hashMap = new HashMap();
        int hak,kor,eng,math;
        String name;
        Student student;
        while (true){
            hak = scanner.nextInt();
            if(hak==0000) break;
            name = scanner.next();
            kor = scanner.nextInt();
            eng = scanner.nextInt();
            math= scanner.nextInt();
            student = new Student(hak,name);
            if(hashMap.containsKey(student)){
                System.out.println("이미 등록된 학생입니다.");
            }else {
                hashMap.put(student,new Score(kor,eng,math));
            }
        }
        Iterator<Student> iterator =   hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Student student1 = iterator.next();
            System.out.println( student1+" "+hashMap.get(student1));
        }
    }
}
