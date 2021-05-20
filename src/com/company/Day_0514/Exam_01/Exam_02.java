package com.company.Day_0514.Exam_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {
    public static void main(String[] args) {

        Double tot=0.0;
       Double avg1 = 0.0;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Double> integers = new ArrayList<>();

        System.out.println("이름을 입력하세요");
        String name = scanner.nextLine();
        System.out.println("번호을 입력하세요");
        int num = scanner.nextInt();
        System.out.println("국어 수학 영어 컴퓨터 점수를 입력하세요");
        integers.add(scanner.nextDouble());
        integers.add(scanner.nextDouble());
        integers.add(scanner.nextDouble());
        integers.add(scanner.nextDouble());

        for(Double i : integers) tot += i;
        avg1 = tot/integers.size();

        integers.add(tot);
        integers.add(avg1);
        System.out.print("이름\t번호\t국어\t영어\t수학\t컴퓨터\t합계\t평균\n");
        System.out.print(name+ "\t" + num + "\t");
        for(Double i : integers)    System.out.print(i +"\t");



    }
}
