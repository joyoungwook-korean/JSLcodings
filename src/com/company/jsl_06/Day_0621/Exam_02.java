package com.company.jsl_06.Day_0621;

import java.util.Scanner;

public class Exam_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ko, math, eng, tot;
        double avg;
        String name;
        String a,b = null;
        name= scanner.next();
        ko = scanner.nextInt();
        math = scanner.nextInt();
        eng = scanner.nextInt();

        a = "합격";
        if(ko<40 || math<40 || eng< 40){
            a = "불합격";
            b = "과락";
        }
        avg = (ko+ math+ eng)/(float)3;
        if( avg<60){
            a = "불합격";
            b = "평균미만";
        }

        if(!(b==null)){
            System.out.printf("이름 : %s\n평균 : %.2f\n판정 : %s\n불합격이유 : %s",name,avg,a,b);
        }else{
            System.out.printf("이름 : %s\n평균 : %.2f\n판정 : %s\n",name,avg,a);
        }


    }
}
