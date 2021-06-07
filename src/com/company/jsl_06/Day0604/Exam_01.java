package com.company.jsl_06.Day0604;

import java.util.Scanner;

/*
주차요금 계산
주차정보 : 3810 42
주차정보 : 3810 42
30대가 최대

주차정보 0 -> 입력종료

[출력예시 ]
자동차번호 주차시간 주차요금
3810    42  1500
3810    42  1500
 10분 미만을 무료,
30분까지는 500원
30분 이후부터는 10분당 500원
최대요금은 30000원
 */
public class Exam_01 {
    public static void main(String[] args) {
        int car_num=0, car_stay=0, car_pee;
        car_pee = 0;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        int car[][] = new int[30][3];
        int car_aa[]= new int[3];


        while (true){
            System.out.println("주차 정보 : ");
            car_num = scanner.nextInt();
            if (car_num == 0 ) break;
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
            car_aa[0] = car_num;
            car_aa[1] = car_stay;
            car_aa[2] = car_pee;

            for(int j=0; j<3; j++){
                car[i][j] = car_aa[j];
            }
            i++;
            if(i ==30) break;

        }


        System.out.printf("자동차번호\t 주차시간\t 주차요금\t\n");
        for(int k=0; k<i; k++){
            for(int j = 0; j<3;j++){
                System.out.printf(car[k][j] + "\t      ");
            }
            System.out.println();
        }


    }
}
