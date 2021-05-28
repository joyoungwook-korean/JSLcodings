package com.company.jsl_05.Day_0528;

/*
구구단 예제 2 가로 출력
 */
public class Exam_02 {
    public static void main(String[] args) {
        int cnt=1;
        for(int j=2; j<=10; j++){

            if(j==2){
                for(int i=2; i<=9; i++){
                    System.out.print(i + "단 ");
                }
            }else{
                for(int i=2; i<=9; i++){
                    System.out.printf( "%d * %d = %d ",i,cnt,i*cnt);

                }
            }
            cnt++;

            System.out.println();

        }
        System.out.println();

        /*
        for(int i =2; i<=9; i++){
            System.out.println(i + "단");

            for(int j = 2; j<=9; j++){
                if(cnt%8==0 && !(cnt==0)) System.out.println();
                System.out.printf("%d * %d = %d\n",i,j,i*j);
                cnt++;
            }

        }*/
    }
}
