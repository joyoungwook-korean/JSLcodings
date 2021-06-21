package com.company.jsl_06.Day_0621;

import java.util.Scanner;

public class Exam_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt=0,temp;
        int[] a = new int[10];
        while(cnt<10){
            System.out.println("점수 : ");
            a[cnt] = scanner.nextInt();
            if(a[cnt]==0) break;
            cnt++;

        }

        System.out.print("학생 점수 : ");
        for(int i=0; i<cnt; i++){
            if(a[i] ==0){
                break;
            }else{
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        System.out.print("내림 차순 : ");

        for(int i=0; i<cnt; i++){
            for(int y=0; y<cnt-1;y++){
                if(a[y] < a[y+1]){
                    temp = a[y];
                    a[y] = a[y+1];
                    a[y+1] = temp;
                }
            }
        }
        for(int i=0; i<cnt; i++){
                System.out.print(a[i] + " ");
        }


    }
}
