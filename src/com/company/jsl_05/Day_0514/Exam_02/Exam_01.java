package com.company.jsl_05.Day_0514.Exam_02;

import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
      int max=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("3개의 정수 입력 : ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        max = a>b && a>c ? a: b>c ? b:c;
        System.out.println("입력 자료 : "+a+", "+b+", "+c);
        System.out.print("가장 큰 값은 : "+max+ " 입니다");





    }
}
