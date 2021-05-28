package com.company.Day_0525;

import java.util.Scanner;

public class Exam_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int zin;


        while (true){
            System.out.print("10진수 : ");
            num= scanner.nextInt();
            System.out.print("\n");
            System.out.print("변환 진수 : ");
            zin = scanner.nextInt();
            System.out.print("\n");
            if (num == 0) break;
            cnum2(num, zin);
        }



    }

    public static void cnum2(int num, int zin){
        String save ="";
        if(!(zin==2) && !(zin==8) && !(zin==16)) System.out.println("진수가 잘못 되었습니다.");
        else save = gugu(num,zin);
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
