package com.company.jsl_06.Day_0623.exam;

import java.util.Scanner;

public class MemberExam {
    public static void main(String[] args) {
        String s[];
        String num;
        Member member[] = new Member[10];
        Scanner scanner = new Scanner(System.in);
        int cnt=0;
        while (cnt<10){
            num = scanner.next();
            if(num.equals("end")) break;
            s = num.split(",");
            member[cnt] = new Member(s[0],s[1],s[2]);
            cnt++;
        }

        System.out.println("이름 전화 \t 성별 나이");
        for(int i = 0 ; i <cnt; i++){
            System.out.println(member[i].toString());
        }
    }
}
