package com.company.TopPro.Level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int mok, na,temp,tot;
        int N = scanner.nextInt();
        temp = N;
        int cnt=0;
        while (true){
            if(N<10){
                na=N;
                N=N*10;
                N=N+na;

            }else{
                mok= N/10;
                na=N%10;
                N=mok+na;
                N=N%10;
                N=(na*10)+N;
            }
            cnt++;
            if(N==temp){
                System.out.println(cnt);
                break;
            }


        }

    }
}
