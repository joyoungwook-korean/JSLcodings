package com.company.jsl_06.Day_0601;
/*
최대 최소값을 뺀 나머지 합계를 구하여 출력
 */

public class Exam_05 {
    public static void main(String[] args) {
        int var[] = {78,67,95,89,65,59,85};
        int save=0;
        for(int i = 0; i <var.length; i++){
            for(int j = i+1; j<var.length-1; j++){
                if(var[i]>var[j]){
                    save = var[i];
                    var[i] = var[j];
                    var[j] = save;
                }
            }
        }

        save=0;
        for(int i=1; i< var.length-1; i++){
            save += var[i];
        }

        System.out.println(save);

    }
}
