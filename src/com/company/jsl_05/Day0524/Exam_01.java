package com.company.jsl_05.Day0524;

import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.next();

        int a = 75;
        int b=67;

        switch (scan){
            case "A":
                System.out.println(a+b);
                break;
            case "B":
                System.out.println(a-b);
                break;
            case "C":
                System.out.println(a*b);
                break;
            case "D":
                System.out.println(a/b);
                break;
            case "F":
                System.out.println(a%b);
                break;
            default:
                System.out.println("오류");
        }





    }
}
