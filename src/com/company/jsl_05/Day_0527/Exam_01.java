package com.company.jsl_05.Day_0527;
/*
구구단
 */
public class Exam_01 {
    public static void main(String[] args) {
        int cnt=0;
        for(int i =2; i<=9; i++){
            for(int j = 2; j<=9; j++){
                if(cnt%8==0 && !(cnt==0)) System.out.println();
                System.out.printf("%d * %d = %d ",i,j,i*j);
                cnt++;
            }
        }
    }
}
