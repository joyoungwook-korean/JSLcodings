package com.company.jsl_06.Day_0601;

import java.awt.*;
/*
점수 번호 출력
 */
public class Exam_10 {
    public static void main(String[] args) {
        int num[] = {7,3,5,6,2,1};
        int tot[] = {70,85,90,88,85,79};
        int suk[] = new int[6];
        int r,save;
        for(int i=0; i<num.length; i++){
            r=1;
            for(int j=0; j<num.length; j++){
                if(tot[i]<tot[j]) r++;
            }
            suk[i] = r;

            System.out.print(num[i] + " "+ tot[i] +" "+ suk[i] +"\n");
        }
        System.out.println();
        for(int i =0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                if(suk[i]> suk[j]){
                    save = suk[i];
                    suk[i] = suk[j];
                    suk[j] = save;

                    save = tot[i];
                    tot[i] = tot[j];
                    tot[j] = save;

                    save = num[i];
                    num[i] = num[j];
                    num[j] = save;

                }
            }

            System.out.print(num[i] + " "+ tot[i] +" "+ suk[i] +"\n");
        }


    }
}
