package com.company.Day_0526;

import java.util.Scanner;

/*
[키보드 점수 1~100 사이를 입력받아서 최대점수 최소점수를 구하여 출력하는 프로그램

 */
public class Exam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max=0;
        int min=101;
        while (true){
            int num = scanner.nextInt();
            if(num==-99) break;
            if(max<num) max=num;
            if(min>num) min=num;
        }
        System.out.printf("max : %d\nmin : %d\n",max,min);
    }
}
