package com.company.jsl_06.Day_0609;

public class Student {
    int bun;
    String name;
    int kor, eng, mat, tot;
    double ave;
    String pangeng;
    String quest;

    public Student(int bun, String name, int kor, int eng, int mat) {
        this.bun = bun;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    void getTot( int kor, int eng, int mat){
        tot= kor+eng+mat;
    }
    void getAve(int tot){
        ave = tot/(3.*100+0.5)/100.;
    }
    void setPangeng(){
        if(ave>=60 && kor>=40 && eng>=40 && mat>=40) {
            pangeng = "합격";
        }else{
            pangeng="불합격";
            quest = "평균 미만";
            if(ave>60){
                quest ="과락";
            }

        }

    }

}
