package com.company.jsl_06.Day_0602;

public class Exam_01 {
    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        int num=1;
        for(int i =0; i<arr.length;i++){
            if(i%2==0){
                for(int j=0; j<arr.length;j++){
                    arr[i][j] = num;
                    num++;
                }
            }else{
                for (int j = 4; j>=0; j--){
                    arr[i][j] = num;
                    num++;
                }
            }
        }
        for(int i = 0; i<arr.length;i++){
            for(int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
        for(int i = 0; i<arr.length;i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j]=0;

            }

        }
        System.out.println();
        int cnt1 = -1, cnt2 = 0;
        num=1;
        int k = 5, a = 1;

        for (int o = 0; o < arr.length; o++) {
            for (int i = 0; i < k; i++) {
                cnt1 += a;
                arr[cnt2][cnt1] = num;
                num++;
            }
            k--;
            if (k == 0) break;
            for (int j = 0; j < k; j++) {
                cnt2 += a;
                arr[cnt2][cnt1] = num;
                num++;
            }
            a = a * -1;
        }

        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
