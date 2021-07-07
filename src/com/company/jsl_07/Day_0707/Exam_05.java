package com.company.jsl_07.Day_0707;

import java.util.Scanner;

public class Exam_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        System.out.println(uncompress(a));
    }
    public static String uncompress(String a){
        char[] arr = a.toCharArray();
        String sl = "";
        for(int i=0; i<arr.length; i++){
            int v=(int) arr[i];
            if(v<=57 && v>=49){
                v= v-48;
                for(int y=0; y<v;y++){
                    sl += arr[i+1];
                }
            }
            i++;
        }
        return sl;
    }
}
