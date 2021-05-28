package com.company.jsl_05.Day_0528;

import java.util.Scanner;

/*
화폐 단위별 매수 출력

출력 예시
급여 오만 일만 오천 일천 오백 일백 일십 오 일

 */
public class Exam_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0, at = 0;
        int mok = 0;
        int cnt = 0, sum = 0;
        while (true) {
            num = scanner.nextInt();
            sum += num;
            int a = 50000;

            if(at==0) {
                System.out.println("급여 오만 일만 오천 천 오백 오십 오 일");
                at=1;
            }

            if (num == -99) {
                System.out.println(sum + 99);
                break;
            }
            for (int i = 0; i < 10; i++) {
                if (cnt == 0) {
                    mok = num / a;
                    num = num % a;
                    System.out.print(mok+ "\t");
                    a = a / 5;
                    cnt = 1;

                } else {
                    mok = num / a;
                    num = num % a;
                    System.out.print(mok + "\t");
                    a = a / 2;
                    cnt = 0;
                }

            }
            System.out.println();
        }

    }


}

