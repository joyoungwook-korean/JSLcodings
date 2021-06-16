package com.company.jsl_06.Day_0616.eeee;

public class Exam_05 {
    public static void main(String[] args) {
        MathExam mathExam = new MathExamNo();
        int max = mathExam.max(10,20,30,40,50,60);
        System.out.println(max);
        int min = mathExam.min(20,30,40,50,10,20);
        System.out.println(min);
    }
}
