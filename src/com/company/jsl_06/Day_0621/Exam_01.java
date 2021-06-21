package com.company.jsl_06.Day_0621;

import java.util.Optional;
import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c, max = 0, mi=0 , min=0;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        if(a==b || a==c || b==c) {
            System.out.println("입력오류");

        }else {
            if(a>b){
                if(a>c){
                    max = a;

                }else{
                    if(b>c){
                        mi = b;
                        min = c;
                    }else{
                        mi=c;
                        min=b;
                    }
                }
            }
            else{
                if(b>c){
                    max=b;
                    if(a>c){
                        mi = a;
                        min = c;

                    }else{
                        mi = c;
                        min = a;

                    }
                }
            }
            System.out.printf("max : %d, med = %d, min = %d",max,mi,min);
        }


    }
}
