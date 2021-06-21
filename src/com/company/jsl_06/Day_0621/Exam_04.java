package com.company.jsl_06.Day_0621;

import java.util.Scanner;

public class Exam_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int zin;


        while (true){
            System.out.print("10진수 : ");
            num= scanner.nextInt();
            if (num == 0) break;
            if(num<1){
                System.out.println("오류");
                continue;
            }else{
                System.out.print("변환 진수 : ");
                zin = scanner.nextInt();
                cnum2(num, zin);
            }

        }



    }

    public static void cnum2(int num, int zin){
        String save ="";
        if(!(zin==2) && !(zin==8) && !(zin==16)) System.out.println("오류");
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
