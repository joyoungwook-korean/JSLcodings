package com.company.jsl_06.Day_0609.jo;

public class Score {
    int arr[][] = new int[100][1000];
    int ab=0 ;
    int i=0;
    Score(int arraa[]){
        while (true){
            if(arraa[i]==0)break;
            arr[ab][i] = arraa[i];
            i++;
        }
        ab++;
    }






}
