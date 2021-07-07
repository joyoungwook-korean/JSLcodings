package com.company.jsl_07.Day_0707;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam_02 {
    public static void main(String[] arg) {
        Scanner scanner =new Scanner(System.in);
        String s = scanner.next();
        Map<String,Integer> args = new HashMap<>();
        args.put("Alice", 23);
        args.put("Peter", 19);
        args.put("Andy", 25);
        args.put("Tom", 22);
        args.put("Bob", 31);
        args.put("Paul", 25);
        args.put("Karen", 40);
        args.put("Cindy", 30);
        args.put("Sally", 28);
        args.put("Sue", 32);

        int a=args.get(s);
        System.out.println("Enter Name : " + s);
        System.out.println(s+" is "+a+" years old");


    }
}
