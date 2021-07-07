package com.company.jsl_07.Day_0706;

import java.util.Objects;

public class Student {
    private int hakbun;
    private String name;
    private int kor,eng,mat,tot;
    int ave;
    public String panjeng;

    public Student(int hakbun, String name, int kor, int eng, int mat) {
        this.hakbun = hakbun;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public Student() {
    }

    int totAve(){
        int tot = kor+eng+mat;
        ave = (int)Math.round(tot/3.);
        panjeng = "가";
        if(ave>=90) panjeng = "수";
        if(ave>=80) panjeng = "우";
        if(ave>=70) panjeng = "미";
        if(ave>=60) panjeng = "양";
        return ave;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student student = (Student) o;
            return hakbun == student.hakbun;
        }else{
            return false;
        }

    }

    @Override
    public int hashCode() {
        return hakbun;
    }
}
