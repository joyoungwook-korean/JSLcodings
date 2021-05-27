package com.company.Day_0527;
/*
왼좌 출력
 */
public class Exam06 {
    public static void main(String[] args) {
        int cnt=0;
        int bo=0;
        int save=0;
        for(int x=0; x<5; x++){
            if(bo ==0){
                cnt=save;
                cnt +=1;
                save=cnt;
                for(int y=0; y<5; y++){
                    System.out.print(" "+cnt);
                    cnt++;
                }
                bo=1;
                System.out.println();
                continue;
            }
            if(bo==1){
                cnt=save;
                cnt+=9;
                save=cnt;
                for(int i=5; i>0; i--){
                    System.out.print(" "+cnt);
                    cnt--;
                }
                bo=0;
                System.out.println();
            }
        }
    }
}
