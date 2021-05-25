package com.company.Day_0525;

public class Exam_01 {
    public static void main(String[] args) {
        int i=0;
        int s =0;

        // 무한 loop
        while (true){
            i = i+1;
            s = s+i;
            if(i==10) break;
        }
        System.out.println(s);

        //do - while
        i=0;
        s=0;
        do{
            i = i+1;
            s = s+i;
        }while (i<10);
        System.out.println(s);

        //while
        i=0;
        s=0;
        while (i<10){
            i = i+1;
            s = s+i;
        }
        System.out.println(s);
    }
}
