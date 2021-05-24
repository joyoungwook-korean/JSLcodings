package com.company.Day0524;
/*
키보드로 정수를 입력 받아서 합 평균을 출력
 */

import java.util.Scanner;

public class Exam_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int tot=0;
        double avg=0;
        int count=1;
        while (true){
            a = scanner.nextInt();
            if(a==-99){
                avg = (float)tot/count;
                break;
            }
            tot +=a;
            count++;
        }
        System.out.printf("tot %d\n" +
                "avg %f\n",tot,avg);
    }
}
