package com.company.Day0524;

import java.util.Scanner;

/*
키보드로 자동차번호(4자리), 주차시간(분)을 입력받아서 주차요금을 계산하여 출력하는 프ㅡ로그램
입력 : 3810 42

출력
자동차 번호 : 3810
주차요금 : 1500원
10분 미만을 무료,
30분까지는 500원
30분 이후부터는 10분당 500원
최대요금은 30000원
 */
public class Exam_08 {
    public static void main(String[] args) {
        int car_num, car_stay, car_pee;
        car_pee = 0;
        Scanner scanner = new Scanner(System.in);

        car_num = scanner.nextInt();
        car_stay = scanner.nextInt();

        if(10>car_stay){
            System.out.println("무료");
        }else if((30>=car_stay)&&(car_stay>=10)){
            car_pee = 500;
        }else{
            if((car_stay%10 >=1) && (car_stay%10 <=9)){
                car_stay = car_stay-10;
                car_pee = car_stay/10*500;
            }else{
                car_stay = car_stay-20;
                car_pee = (car_stay/10)*500;
            }

        }
        if(car_pee>=30000){
            car_pee = 30000;
        }

        System.out.printf("자동차 번호 : %d\n 주차요금 : %d원\n",car_num,car_pee);


    }
}
