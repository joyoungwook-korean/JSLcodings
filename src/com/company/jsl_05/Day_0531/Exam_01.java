package com.company.jsl_05.Day_0531;

public class Exam_01 {
    public static void main(String[] args) {

        int[] arr = new int[5];
        System.out.println(arr[1]);
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        for (int i : arr){
            System.out.println(i);
        }
    }
}
