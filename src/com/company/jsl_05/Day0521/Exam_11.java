package com.company.jsl_05.Day0521;

import java.util.Scanner;

public class Exam_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        int max, me, min;

        if (a > b) {
            if (a > c) {
                max = a;
                if (b > c) {
                    me = b;
                    min = c;
                } else {
                    me = c;
                    min = b;

                }
            } else {
                max = c;
                me = a;
                min = b;
            }
        } else if (b > c) {
            max = b;
            if (a > c) {
                me = a;
                min = c;
            } else {
                me = c;
                min = a;
            }
        } else {
            max = c;
            me = b;
            min = a;
        }
        System.out.printf("Max : %d\n Me : %d\n, Min : %d\n", max, me, min);




    }

}
