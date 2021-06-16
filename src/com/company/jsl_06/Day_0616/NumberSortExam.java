package com.company.jsl_06.Day_0616;

public class NumberSortExam extends NumberSort{


    public NumberSortExam(int[] num, int cnt) {
        super(num,cnt);
    }


    @Override
    void AscSort() {
        int temp;
        for(int i=0; i<cnt;i++){
            for(int y=0; y<cnt-1; y++){
                if(num[y]>num[y+1]){
                    temp = num[y+1];
                    num[y+1] = num[y];
                    num[y] = temp;
                }
            }

        }
        sortPrint();
    }

    @Override
    void DescSort() {
        int temp;
        for(int i=0; i<cnt;i++){
            for(int y=0; y<cnt-1; y++){
                if(num[y]<num[y+1]){
                    temp = num[y];
                    num[y] = num[y+1];
                    num[y+1] = temp;
                }
            }

        }
        sortPrint();
    }

    @Override
    void add() {
        int temp;
        temp = num[0]-num[cnt-1];

        System.out.println(temp);
    }
}
