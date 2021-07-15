package com.company.jsl_07.Day_0709.test.Day_0709_test;

import java.util.Scanner;
import java.util.TreeSet;

public class SawonExam {
    public static void main(String[] args) {
        TreeSet<Sawon> treeSet = new TreeSet<>();
        int num;
        String name, gender, birth;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            num = scanner.nextInt();
            if (num == 0000) break;
            if (num < 1000) {
                System.out.println("사원 입력 오류");
                continue;
            }
            name = scanner.next();
            gender = scanner.next();
            birth = scanner.next();
            Sawon sawon = new Sawon(num, name, gender, birth);
            if (treeSet.contains(sawon)) {
                System.out.println("이미 등록된 사원 입니다.");
            } else {
                treeSet.add(sawon);
            }

        }
        System.out.print("사번\t\t이름\t\t성별\t\t생년월일\t\t나이\n");
        for(Sawon sa : treeSet){
            System.out.println(sa);
        }

    }
}
