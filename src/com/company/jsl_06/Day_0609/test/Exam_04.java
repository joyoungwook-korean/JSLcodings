package com.company.jsl_06.Day_0609.test;

import java.util.Scanner;

public class Exam_04 {
    public static void main(String[] args) {
        zipin zipin;
        int cnt=0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("아이디 : ");
            String id = scanner.nextLine();
            System.out.print("이름 : ");
            String name= scanner.nextLine();
            System.out.print("우편번호 : ");
            String zipcode= scanner.nextLine();


            zipin = new zipin(id,name,zipcode);
            zipin.printZip();

            if(cnt==10){
                break;
            }
            cnt++;

        }

    }
}
