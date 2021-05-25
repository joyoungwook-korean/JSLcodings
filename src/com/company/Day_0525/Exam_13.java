package com.company.Day_0525;

import java.util.Scanner;

public class Exam_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        int zin=0;

        do{
            System.out.print("10진수 : ");
            num = scanner.nextInt();
            System.out.print("\n");
            System.out.print("변환 진수 : ");
            zin = scanner.nextInt();
            System.out.print("\n");

            cnum2(num, zin);

        }while (num==0);
    }

    public static void cnum2(int num, int zin){
        int mok;
        int na;
        int imsi = num;
        String save ="";
        if(zin==2){ // 2진수 출력 구문

            do {

                mok = imsi/zin;
                na = imsi%zin;

                imsi=mok;

                save = na + save;
            }while (!(mok==0));
        }else if(zin==8){ // 8진수 출력구문
            do {

                mok = imsi/zin;
                na = imsi%zin;

                imsi=mok;

                save = na + save;
            }while (!(mok==0));
        }else if( zin==16){ //  16진수 출력구문
            do {
                mok = imsi/zin;
                na = imsi%zin;
                imsi=mok;
                save = na + save;
            }while (!(mok==0));

            switch (save){
                case "10": save="A"; break;
                case "11": save="B"; break;
                case "12": save="C"; break;
                case "13": save="D"; break;
                case "14": save="E"; break;
                case "15": save="F"; break;
            }
            save = na+save;

        }else{
            System.out.println("진수가 잘못되었습니다");
        }

        System.out.println(save);
    }
}
