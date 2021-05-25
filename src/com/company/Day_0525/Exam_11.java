package com.company.Day_0525;

public class Exam_11 {
    public static void main(String[] args) {
        int i=1;
        int j=1;
        int k=1;
        while (true){
            i = i+1;
            j = j*i;
            k = k+j;

            if(i>=10) break;
        }
        System.out.println(k);
    }
}
