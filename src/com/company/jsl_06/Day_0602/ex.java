package com.company.jsl_06.Day_0602;

public class ex {
    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        int cnt=0;
        int k=5;
        int c=1;
        int a=0, b=-1;
        while (true){
            for(int i=0; i<k;i++){ // B코드
                b= b+c;
                cnt++;
                arr[a][b]=cnt;
            }

            k--;
            if(k==0) break;

            for(int i=0; i<k; i++){ // A코드
                a=a+c;
                cnt++;
                arr[a][b]= cnt;
            }
            c=c*-1;
        } // 종료 문장

        for(int i=0; i<arr.length; i++){
            for(int y =0; y<arr.length; y++){
                System.out.print(arr[i][y] + " ");
            }
            System.out.println();
        }

    }
}
