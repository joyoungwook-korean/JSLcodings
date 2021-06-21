package com.company.jsl_06.Day_0621;

import java.util.Scanner;

public class ParkingExam {
    public static void main(String[] args) {
        Parking[] parking = new Parking[100];
        int cnt=0;
        String name;
        int tot=0,stay;
        Scanner scanner = new Scanner(System.in);

        while (cnt<100){
            System.out.print("주차정보 : ");
            name = scanner.next();
            if(name.equals("0000")) {
                break;
            }
            stay = scanner.nextInt();
            parking[cnt] = new Parking(name,stay);
            tot += parking[cnt].getMoney();

            cnt++;
        }
        System.out.println("주차요금  주차시간  주차요금");
        for(int i=0; i<cnt;i++){
            parking[i].printCar();
        }
        System.out.print("요금 합계 : \t" + tot);
    }
}
