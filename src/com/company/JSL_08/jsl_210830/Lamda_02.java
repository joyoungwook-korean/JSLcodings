package com.company.JSL_08.jsl_210830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

@FunctionalInterface
interface Score{
    public int sum(int[] score);
}

public class Lamda_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] score1 = {scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
        Score s;
        s = (score)->{
            IntStream a = Arrays.stream(score).sorted();
            OptionalInt min = a.min();
            int mins=min.getAsInt();
            int sum = 0;
            for(int i=0; i<score.length; i++){
                if(score[i]!=mins) sum+=score[i];
            }
          return sum;
        };
        System.out.println(s.sum(score1));
    }
}
