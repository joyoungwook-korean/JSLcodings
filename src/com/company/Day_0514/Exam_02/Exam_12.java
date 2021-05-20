package com.company.Day_0514.Exam_02;

import java.util.Scanner;

public class Exam_12 {
    public static void main(String[] args) {
        String name;
        int num, ko, math, eng, tot, avg;


        Scanner scanner = new Scanner(System.in);

        System.out.println("학생 등록");
        num = scanner.nextInt();
        name = scanner.next();
        ko = scanner.nextInt();
        math = scanner.nextInt();
        eng = scanner.nextInt();

        tot = ko + math + eng;
        avg = tot / 3;

        System.out.println("번호 : " + num);
        System.out.println("이름 : " + name);
        System.out.println("총점 : " + tot);
        System.out.println("평균 : " + avg);
        System.out.println(avg >= 85 ? "합격" : "불합격");

    }
}
