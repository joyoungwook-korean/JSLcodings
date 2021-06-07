package com.company.jsl_06.Day_0607.Cl;

import java.util.Scanner;

class Sawon {
    int sabun;
    String name;
    int age;

    Sawon(int sabun, String name, int age) {
        this.sabun = sabun;
        this.name = name;
        this.age = age;
    }

    void dataPrint() {
        System.out.printf(sabun + "\t" + name + "\t" + age + "\n");
    }
}

public class Mouse {
    public static void main(String[] args) {
        Sawon sawon[] = new Sawon[10];
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        while (cnt < 10) {
            int sabun = scanner.nextInt();
            String name = scanner.next();
            int age = scanner.nextInt();
            if(sabun==0) break;
            sawon[cnt] = new Sawon(sabun, name, age);
            cnt++;
        }
        for (int i=0; i<cnt; i++){
            sawon[i].dataPrint();
        }

    }


}
