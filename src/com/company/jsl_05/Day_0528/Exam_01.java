package com.company.jsl_05.Day_0528;

import java.util.Scanner;
/*
구구단 예제
 */
public class Exam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt=0;
        while (true){
            cnt = scanner.nextInt();
            if(cnt == 0) {
                System.out.println("프로그램 종료");
                break;
            }

            System.out.println("단 : " +cnt);
            System.out.println(cnt + "단 출력");
            for(int j = 2; j<=9; j++){
                System.out.printf("%d * %d = %d\n",cnt,j,cnt*j);
            }


        }
    }
}
