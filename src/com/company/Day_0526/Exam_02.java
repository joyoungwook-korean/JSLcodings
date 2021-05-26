package com.company.Day_0526;

import java.util.Scanner;
/*
100까지 7개 입력 받아서 최대 최소값을 뺀 나머지 합계 평균을 구하여 출력
입력 점수의 범위를 벗어난 값이 입력될 경우 "입력오류 출력 후 재입력"
평균이 100~87 A 86~73 B 72~55 C 0~54 D 출력
 */
public class Exam_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0,min= 101;
        int tot=0;
        double avg=0.0;
        int cnt=0;
        String avg2 ="";
        while (cnt<7){
            System.out.println("입력점수:");
            int num = scanner.nextInt();
            if((num>100) && (num<1)) System.out.println("입력오류");
            if(max<num) max=num;
            if(min>num) min =num;
            tot += num;
            cnt++;
        }
        tot = tot-max-min;
        avg = tot/(float)cnt;
        if(100>=avg && avg>=87) avg2 = "A";
        else if(86>=avg && avg>=73) avg2 = "B";
        else if (72>=avg && avg>=55) avg2 = "C";
        else avg2="D";
        System.out.printf("최대 점수 : %d\n최소 점수 : %d\n합계 : %d\n평균 : %.1f %s\n",max,min,tot,avg,avg2);


    }
}

