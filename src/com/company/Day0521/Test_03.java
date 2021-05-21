package com.company.Day0521;
/*
문자 한개를 입력받아서
T : 문자 한개출력
F : 에러 출력
 */

import com.sun.javaws.exceptions.ErrorCodeResponseException;

import java.util.Scanner;

public class Test_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character ch = scanner.next().charAt(0);

        if((ch>=65) && (ch<=122)){
            System.out.println(ch);
        }else{
            Error exception =new Error();
            exception.printStackTrace();
        }
    }
}
