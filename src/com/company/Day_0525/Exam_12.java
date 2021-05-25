package com.company.Day_0525;

public class Exam_12   {
    public static void main(String[] args) {
        int a =1;
        int b=1;
        int t=2;
        int c;
        while (true){
            c = a+b;
            t=t+c;
            if(c==34) break;
            a = b;
            b=c;
        }
        System.out.println(t);
    }
}
