package com.company.Day_0526;

import java.util.Scanner;
/*
소수문제
 */

public class Exam_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n=0;
        for(int i=2;i<a+1; i++){
            n = a%i;
            if(n==0) {
                if(a==i) {
                    System.out.println("소수");
                    break;
                }
                else {
                    System.out.println("소수아님");
                    break;
                }

            }
        }

    }
}
