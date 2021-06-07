package com.company.jsl_06.Day_0607;

import java.util.Scanner;

public class Exam_10 {
    public static void main(String[] args) {
        int num,ko,math,eng;
        int cnt=0;
        Hak[] haks= new Hak[10];
        Scanner scanner = new Scanner(System.in);
        while (cnt<10){
            num = scanner.nextInt();
            String name = scanner.next();
            ko = scanner.nextInt();
            eng = scanner.nextInt();
            math = scanner.nextInt();

            if(num==0) break;

            haks[cnt]=new Hak(num,name,ko,eng,math);

            cnt++;
        }
        System.out.println("번호 이름 국어 영어 수학 총점 평균");
        for(int i=0; i<cnt;i++) haks[i].naSprint();
    }
}

class Hak{
    int num,ko,math,eng;
    String name;
    int tot, avg;
    Hak(int num,String name, int ko,int eng, int math){
        this.num = num;
        this.name = name;
        this.ko = ko;
        this.eng = eng;
        this.math = math;
        tot = ko+eng+math;
        avg = tot/3;
    }

    void naSprint(){
        System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %d\n",num,name,ko,eng,math,tot,avg);
    }


}