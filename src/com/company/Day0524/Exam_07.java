package com.company.Day0524;
/*
키보드로 이름, 국어, 영어 , 수학을 입력받아서
이름, 총점, 평균, 학점, 판정 출력

출력예시
이름 :
총점 :
평균 :
학점 :
판정 :
1. 학점은 100
 */

import java.util.Scanner;

public class Exam_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int kor, eng, ma;
        kor = scanner.nextInt();
        eng = scanner.nextInt();
        ma = scanner.nextInt();

        int tot = kor + eng + ma; // 총점 합계
        double avg = (float) tot / 3; // 평균값 계산을 위해 tot를 float 로 형변환
        int avg2 = (int) avg / 10; // switch 값 입력을 위해 int 로 형변환 뒤 10으로 나눔


        switch (avg2) {
            case 10:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : A\n판정 : 합격", name, tot, avg);
                break;
            case 9:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : A\n판정 : 합격", name, tot, avg);
                break;
            case 8:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : B\n판정 : 합격", name, tot, avg);
                break;
            case 7:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : C\n판정 : 합격", name, tot, avg);
                break;
            case 6:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : D\n판정 : 불합격", name, tot, avg);
                break;
            default:
                System.out.printf("이름 : %s\n총점 : %d\n평균 : %.1f\n학점 : F\n판정 : 불합격", name, tot, avg);
                break;

        }


    }
}
