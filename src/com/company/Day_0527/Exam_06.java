package com.company.Day_0527;

import java.util.Scanner;

/*
키보드로 이름, 등급, 근무시간을 입력받아서 주간 급여를 출력
 사원 입력 : 김사원 1 25
 이름 등급 시급 근무시간 주간급여
 김사원 1  10000 25    250000

 사원 입력 : 이사원 3 25
 이름 등급 시급 근무시간 주간급여
 이사원 3  2000 45    99000

 처리조건
 주급 = 근무시간*시급
 시급 = 1등급 10000 2등급 5000 3등급 2000
근무시간이 36시간 초과 한경우 초과근무 시간에 한하여 시급의 1.5배
최대 근무 시간은 50시간 까지만 인정
 */
public class Exam_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int day=0;
       double dayOver=0,ju=0;
       int save=0;
        while(true){
            System.out.print("사원 입력 : ");
            String name = scanner.next();
            int du = scanner.nextInt();
            int time = scanner.nextInt();
            save= time;
            System.out.println();

            if(name.equals("end")) {
                System.out.println("프로그램 종료합니다");
                break;
            }

            switch (du){
                case 1: day=10000; break;
                case 2: day=5000; break;
                case 3: day=2000; break;
            }
            if(time>50) time=50;
            if(time>36) {
                dayOver = day*1.5*(time-36);
                time=36;
            }
            ju= time*day+dayOver;
            System.out.println("이름 \t 등급 \t 시급 \t 근무시간 \t 주간급여");
            System.out.printf("%s \t %d \t\t %d \t %d \t\t %d\n",name,du,day,save,(int)ju);
            dayOver=0;

        }
    }
}
