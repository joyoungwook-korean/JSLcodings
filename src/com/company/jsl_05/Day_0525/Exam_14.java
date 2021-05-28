package com.company.Day_0525;

import java.util.Scanner;

/*
키보드로 급여를 입력 받아서 화폐 단위별로 매수를 구하여 출력
 */
public class Exam_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("급여 입력 : ");
        int num =0;
        num = scanner.nextInt();
        int mok,na,save;
        int a = 1;
        int oo = 50000;
        int ii = 10000;


        do {
            if(a ==1){
                mok = num/oo;
                na= num%oo;
                a=0;
                System.out.printf("%d : %d\n",oo,mok);
                oo=oo/10;
                num=na;
            }else{
                mok = num/ii;
                na= num%ii;
                a=1;
                System.out.printf("%d : %d\n",ii,mok);
                ii=ii/10;
                num=na;
            }
        }while (!(na==0));

        /*
        강사님이 한거
        do {
            if(a ==1){
                mok = num/oo;
                na= num%oo;
                a=0;
                System.out.printf("%d : %d\n",oo,mok);
                oo= oo/5
                num=na;
            }else{
                mok = num/oo;
                na= num%oo;
                a=1;
                oo/2;
                System.out.printf("%d : %d\n",ii,mok);
                num=na;
            }
        }while (!(na==0));
         */
    }
}
