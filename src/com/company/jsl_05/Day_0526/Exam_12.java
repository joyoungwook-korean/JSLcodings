package com.company.Day_0526;

public class Exam_12 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) a += i;
            else b += i;
        }
        System.out.printf("홀수 합 : %d\n짝수 합 : %d\n",b,a);

    }


}
