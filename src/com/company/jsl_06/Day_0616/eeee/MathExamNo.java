package com.company.jsl_06.Day_0616.eeee;

public class MathExamNo extends MathExam{
    int temp;
    @Override
    public int max(int a, int b) {

        return a>b ? a :b;
    }

    @Override
    public int min(int a, int b) {
        return a<b ? a : b;
    }

    @Override
    public int max(int... a) {

        temp=a[0];
        for(int i=0;i<a.length-1; i++){
            if(temp<a[i+1]) temp=a[i+1];
        }
        return temp;
    }

    @Override
    public int min(int... a) {

        temp=a[0];
        for(int i=0;i<a.length-1; i++){
            if(temp>a[i+1]) temp=a[i+1];
        }
        return temp;
    }
}
