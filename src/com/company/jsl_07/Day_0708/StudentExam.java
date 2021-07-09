package com.company.jsl_07.Day_0708;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Student> treeSet = new TreeSet<>();
        while (true) {
            int num = scanner.nextInt();
            if (num == 0000) break;
            String name = scanner.next();
            int kor = scanner.nextInt();
            int eng = scanner.nextInt();
            int mat = scanner.nextInt();
            if (treeSet.isEmpty()) {
                treeSet.add(new Student(num, name, kor, eng, mat));
                continue;
            } else {
                if (treeSet.equals(num)) {
                    System.out.println("같은 객체 입니다.");
                } else {
                    treeSet.add(new Student(num, name, kor, eng, mat));
                }
            }


        }
        for (Student student : treeSet) {
            System.out.println(student);
        }

    }
}



