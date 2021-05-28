package com.company.Day_0525;

public class Exam_10 {
    public static void main(String[] args) {
        int i=0;
        int j=1;
        int k=1;
        while (true){
            i = i+1;
            j = j+1;
            k = k+j;
            if(j==22) break;
        }
        System.out.println(k);
    }
}
