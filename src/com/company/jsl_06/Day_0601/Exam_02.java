package com.company.jsl_06.Day_0601;

import java.util.Scanner;

/*
내림차순 정렬 학생 점수는 10개 가 최대
0이면 종료
 */
public class Exam_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        int save, num, conut;
        for (int i = 0; i < 10; i++) {
            System.out.println("점수 : ");
            num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            arr[i] = num;
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length - 1; j++) {
                if(arr[j]==0) break;
                if (arr[i] < arr[j]) {
                    save = arr[j];
                    arr[j] = arr[i];
                    arr[i] = save;
                }
            }
        }
        for (int i : arr) {
            if(i ==0) break;
            System.out.print(i + "       ");
        }


    }

}
