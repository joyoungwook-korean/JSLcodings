package com.company.jsl_07.Day_0707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exam_01 {
    public static void main(String[] args) {
        Integer[] arr = {89,84,90,77,95,90,65,100,90,84};
        List<Integer> list= new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        list.addAll(Arrays.asList(arr));

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        int temp = 0;
        int cnt=0;
        while (true){
            int b = list.indexOf(a);
            temp=b;
            if(b==-1) {
                break;
            }else{
                list.remove(b);
                list2.add(temp+cnt);
                cnt++;
            }
        }
        for(int i : list2){
            System.out.println(i);
        }
    }



}

