package com.company.jsl_06.Day_0608;

import java.util.Scanner;

class Sequence{

    void sosu(){ // 소수 문제
        int arr[] = new int[50];
        int cnt=0;
        for(int i=2; i <=50; i++){
            if(!(i%2==0) && !(i==2) && !(i%3==0)){
                arr[cnt] = i;
                cnt++;
            }
        }
        for (int i=0; i<cnt; i++){
            if(i%5 ==0 && i!=0) System.out.println();
            System.out.print(arr[i] + " ");
        }
    } // 소수 2~50까지

    String jinsu(int a){
        if(a<2 || a>100) return "0";
        int arr[] = new int[10];
        int cnt=0,na,mok;
        String ab = "";
        while(true){
            mok = a/2;
            if(a%2 ==0){
                na=1;
            }else{
                na=0;
            }
            a=mok;
            arr[cnt] = na;
            cnt++;
            if(a==0){

                for(int i=0; i<cnt; i++){
                    ab += arr[i];
                }
                break;
            }
        }
        return ab;
    } // 정수 받아서 변환해서 출력메소드

    int[] jjak(){
        int arr[]= new int[5];
        int cnt=0;
        for(int i=1;i<=10;i++){
            if(i%2==0 && !(i==1)){
                arr[cnt] = i;
                cnt++;
            }
        }
        return arr;
    } // 짝수 출력

}

public class Exam_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[5];
        Sequence sequence = new Sequence();
        sequence.sosu();
        System.out.println();
        String a = sequence.jinsu(scanner.nextInt());
        if(a.equals("0")){
            System.out.println("잘못 출력");
        }else{
            System.out.println(a);
        }
        System.out.println();
        arr= sequence.jjak();
        for(int i=0; i<5; i++){
            System.out.print(arr[i] + "  ");
        }




    }
}
