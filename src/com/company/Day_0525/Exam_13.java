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
        String save ="";
        if(zin==2){ // 2진수 출력 구문
            save = gugu(num,zin);
        }else if(zin==8){ // 8진수 출력구문
            save = gugu(num,zin);
        }else if( zin==16){ //  16진수 출력구문
            save = gugu(num,zin);
        }else{
            System.out.println("진수가 잘못되었습니다");
        }

        System.out.println(save);
    }

    public static String gugu(int num, int zin){
        int imsi = num;
        int mok, na;
        String save="";
        do {
            mok = imsi/zin;
            na = imsi%zin;
            imsi=mok;
            save = na+save;
            if(zin==16){
                switch (save){
                    case "10": save="A"; break;
                    case "11": save="B"; break;
                    case "12": save="C"; break;
                    case "13": save="D"; break;
                    case "14": save="E"; break;
                    case "15": save="F"; break;
                }
            }
        }while (!(mok==0));

        return  save;
    }
}
