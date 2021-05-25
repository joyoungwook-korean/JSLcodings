package com.company.Day_0525;

public class Exam_09 {
    public static void main(String[] args) {
        int i=0;
        int s=0;
        int sw=0;
        while (true){
            i = i+1;
            if(sw ==0){
                s = s+i;
                sw=1;
            }else{
                s = s-i;
                sw = 0;

            }
            if(i==10) break;

        }
        System.out.println(s);
    }
}
