package com.company.Day_0526;

import java.util.Scanner;

public class Exam_03 {
    public static int a=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt=0;
        int tot=0;


        while (cnt<10){
            int num = scanner.nextInt();
            tot += toto(num);
            cnt++;
        }
        System.out.println(a);

        a=0;
        for(int i=0; i<10; i++){
            int num = scanner.nextInt();
            tot += toto(num);
        }
        System.out.println(a);




    }

    public static int toto(int num){

        if(num%2==1) {
            a++;
            return num;
        }
        else return 0;
    }
}
