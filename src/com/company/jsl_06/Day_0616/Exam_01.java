package com.company.jsl_06.Day_0616;


import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        int[] num = new int[100];
        Scanner scanner = new Scanner(System.in);
        NumberSort numberSort;
        int i,cnt =0;

        while(true){
            i = scanner.nextInt();
            if(i==0) break;
            num[cnt] = i;
            cnt++;
        }
        numberSort = new NumberSortExam(num, cnt);
        numberSort.AscSort();
        numberSort.DescSort();
        numberSort.add();

    }

}
