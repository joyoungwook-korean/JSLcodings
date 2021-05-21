package com.company.Day0521;

import java.util.Scanner;

public class Test_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextLine().equals("blue")) {
            System.out.println("건너기");
        } else System.out.println("기다리기");
    }

}
