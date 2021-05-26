package com.company.Day_0525;

import java.util.Scanner;

public class Exam_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ko,tot;
        double avg;
        tot=0;
        double i=1.00;

        while (true){
            System.out.print("국어 점수 : ");
            ko = scanner.nextInt();
            System.out.println();

            if(ko == -99){
                avg =  tot/i;
                avg = avg*100;
                if(avg>1)

                System.out.println();
                break;
            }

            tot+= ko;
            i++;

        }
    }
}
