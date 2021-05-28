package com.company.jsl_05.Day_0514.Exam_02;

import java.util.Scanner;

public class main210520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if((80<=num) && (num<= 90) ||(num%7==0)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


        System.out.println(num%2==0 ? "짝수":"홀수");

    }
}
