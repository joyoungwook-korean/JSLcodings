package com.company.Day_0525;

public class Exam_08 {
    public static void main(String[] args) {
        int i=0;
        int s=0;
        int y=1;
        int m=0;
        while (true){
            i = i+1;
            m = i*y;
            s = s+m;
            if(i==10) break;
            y=y*(-1);
        }
        System.out.println(s);
    }
}
