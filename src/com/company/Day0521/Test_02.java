package com.company.Day0521;

/*
키보드를 정수 2개를 입력받아서
두 수를 더하여 170 이상이면
T : 합계를 출력하고 차이값을 출력
F : 두수의 차이값을 출력
 */

import java.util.Scanner;

public class Test_02 {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt(); // 두수를 입력받음

        if(a+b>=170){
            System.out.printf("합게 : %d\n", a+b);
            System.out.printf("차이 : %d\n", a-b);
        }else System.out.printf("차이 : %d\n",a-b);

    }
}
