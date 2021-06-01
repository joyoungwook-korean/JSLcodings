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
        int val[] ={87,85,67,74,88,84,86,90};
        int tot=0,avg;
        int savemin=0, savemax,save=0;
        for(int i : val){
            tot+=i;
            System.out.print(i + " ");
        }
        System.out.println();
        avg = tot/val.length;
        System.out.println(avg);

        save = val[0];
        savemax = avg-val[0];
        if(savemax < 0 ) savemax = savemax*-1;


        for(int i=1; i<val.length; i++){

            savemin = avg - val[i];
            if(savemin <0) savemin = savemin*-1;

            if((savemax > savemin) ) {
                savemax = savemin;
                save = val[i];
            }

            if (savemin == 0){
                save=val[i+1];
            }else if(savemax ==0){
                save=val[i];
            }
        }

        System.out.println(save);
    }
}
