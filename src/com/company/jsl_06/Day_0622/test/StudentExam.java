package com.company.jsl_06.Day_0622.test;
/*
키보드로 번호, 이름, 국어, 영어 수학 , 입력 출력 형식에 맞게 출력
입력 형식
등록 : 1 김학생 90 88 89
이미 등록된 학생 입니다.

등록 : 0 또는 10명 입력시 출력

 */

import java.util.Scanner;

public class StudentExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int bun, kor,eng,math;
        int cnt=0;
        Student student[] = new Student[10];
        while (cnt<10){
            bun = scanner.nextInt();
            if(bun ==0) break;
            name = scanner.next();
            kor = scanner.nextInt();
            math = scanner.nextInt();
            eng = scanner.nextInt();

            student[cnt] = new Student(bun,name,kor,math,eng);
            for(int i=0; i<cnt-1; i++){
                if(student[cnt].hashCode() ==student[i].hashCode()){
                    System.out.println("이미 등록된 학생입니다.");
                    cnt--;
                    break;
                }
            }
            cnt++;
        }
        for(int i=0; i<cnt; i++){
            System.out.println(student[i].toString());
        }
    }
}
