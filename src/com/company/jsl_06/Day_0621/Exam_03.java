package com.company.jsl_06.Day_0621;

import java.util.Scanner;

public class Exam_03 {
    public static void main(String[] args) {
        int car_num, car_stay, car_pee, temp;
        car_pee = 0;
        Scanner scanner = new Scanner(System.in);

        car_num = scanner.nextInt();
        car_stay = scanner.nextInt();

        if(10>car_stay){
            car_pee = 0;
        }else if((30>=car_stay)&&(car_stay>=10)){
            car_pee = 500;
        }else{

            car_pee = ((car_stay-10)/10)*500;
        }
        if(car_pee>=30000){
            car_pee = 30000;
        }
        if(car_pee ==0){
            System.out.printf("자동차 번호 : %d\n주차요금 : 무료",car_num);
        }else{
            System.out.printf("자동차 번호 : %d\n주차요금 : %d원",car_num,car_pee);
        }


    }


}
