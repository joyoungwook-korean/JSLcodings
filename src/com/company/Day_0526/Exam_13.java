package com.company.Day_0526;
/*
1~100의 정수 중 홀수 이면서 3의 배수를 출력
 */
public class Exam_13 {
    public static void main(String[] args) {
        int a=0;
        int cnt=0;
        for(int i=1; i<=100; i++){
            if(!(i%2==0) && (i%3==0)) {
                if(cnt%5==0) System.out.println();
                cnt++;
                System.out.print(i + " ");

            }
        }
    }
}
