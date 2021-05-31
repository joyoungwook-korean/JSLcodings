package com.company.jsl_05.Day_0531;

import java.awt.*;

/*
      평균에 가장 가까운 수 찾기
     출력예시
     Data
     평균 :
     가까운 수 :
 */
public class Exam_05 {
    public static void main(String[] args) {
        int val[] ={87,90,67,59,88,76,95,87};
        int tot=0,avg;
        int savemin=0, savemax,save=0;
        for(int i : val){
            tot+=i;
            System.out.print(i + " ");
        }
        System.out.println();
        avg = tot/val.length;
        System.out.println(avg);

        for(int i=0; i<val.length-1; i++){
            savemax  = avg -val[i];
            savemin = avg - val[i+1];
            if((savemax > savemin) && savemax>0){
                save=val[i];
            }
            if(savemin<savemax && savemax<0) save = val[i];
            if (savemin == 0){
                save=val[i+1];
            }
        }

        System.out.println(save);
    }
}
