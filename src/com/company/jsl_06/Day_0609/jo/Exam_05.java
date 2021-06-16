package com.company.jsl_06.Day_0609.jo;

import java.util.Scanner;

public class Exam_05 {

    public static int a = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, jum;
        String name;
        AStudent student1[] = new AStudent[50];
        Score score;
        int cnt = 0;

        int nnnn[] = new int[1000];

        while (true) {
            System.out.print("번호 입력 : ");
            num = scanner.nextInt();
            if (num == -1) break;
            System.out.print("이름 입력 : ");
            name = scanner.next();
            System.out.println("-------------");

            while (true) {
                System.out.print("점수 입력 : ");
                int na = scanner.nextInt();
                nnnn[cnt] = na;
                if (nnnn[cnt] == 0) break;
                cnt++;
            }

            score = new Score(nnnn);
            student1[a] = new AStudent(num, name, score);
            a++;
            nnnn = new int[100];
            cnt=0;
        }



        for(int i=0; i<a; i++){
            student1[i].psps();
        }



        /*
        while (true){
            student = new AStudent();



            System.out.print("번호 : ");
            num= scanner.nextInt();
            if(num == -1) break;
            student.setNum(num);
            System.out.print("이름 : ");
            student.setName(scanner.next());
            System.out.print("폰 번호 : ");
            student.setPhone_num(scanner.nextInt());
            while (true){
                jum = scanner.nextInt();
                if(jum == -1) break;
                student.setArr_j(jum);
            }
        }
        student.printddd();
        */

    }
}
