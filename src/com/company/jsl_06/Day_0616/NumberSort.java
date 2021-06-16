package com.company.jsl_06.Day_0616;

abstract public class NumberSort {
    int num[];
    int cnt;

    public NumberSort(int[] num,int cnt) {
        this.num = num;
        this.cnt = cnt;
    }


    public void sortPrint(){
        for(int i =0; i<cnt; i++){
            System.out.print(num[i] + "  ");
        }
        System.out.println();
    }

    abstract void AscSort();

    abstract void DescSort();

    abstract void add();
}
