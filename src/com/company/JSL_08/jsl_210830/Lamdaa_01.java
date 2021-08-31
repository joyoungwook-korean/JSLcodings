package com.company.JSL_08.jsl_210830;

import java.util.Scanner;

@FunctionalInterface
interface Myfunc3{
    int aa(int a);
}

public class Lamdaa_01 {
    public static void main(String[] args) {
        Myfunc3 fi;
        Scanner scanner = new Scanner(System.in);
        fi=(a)-> {
            int cnt = 0;
            int temp=0;
            boolean bl = false;
            if(a==2) {
                System.out.println("소수입니다.");
                return a;
            }else{
                for(int i=3; i<=a; i++){
                    for(int y=2; y<i;y++){
                        if(i%y==0){
                            bl = false;
                            break;
                        }
                        temp=i;
                        bl=true;
                    }
                    if(bl==true){
                        cnt++;
                        System.out.print(temp+ " ");
                    }
                }
            }
            return cnt;
        };

        System.out.println(fi.aa(20));
    }
}
