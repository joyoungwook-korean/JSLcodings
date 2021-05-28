package com.company.Day_0526;
/*
화폐 매수 출력
 */

import java.util.Scanner;

public class Exam_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 50000;
        int num = scanner.nextInt();
        int mok = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt == 0) {
                mok = num / a;
                num = num % a;

                System.out.print(a + " : ");
                System.out.println(mok);
                a = a / 5;
                cnt = 1;

            } else {
                mok = num / a;
                num = num % a;
                System.out.print(a + " : ");
                System.out.println(mok);
                a = a / 2;
                cnt = 0;

            }
        }


    }
}
