package com.company.jsl_07.Day_0706.Test;

public class Score {
    private int kor,eng,mat,tot,ave;
    private String panjeng;

    public Score(int kor, int eng, int mat) {
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.tot = kor+eng+mat;
        this.panjeng=getPanjeng();
    }

    public Score() {
    }

    public String getPanjeng(){
        ave = tot/3;
        panjeng="가";
        if(ave>=90){
            panjeng="수";
        }else if(ave>=80){
            panjeng="우";
        }else if(ave>=70){
            panjeng="미";
        }else if(ave>=60){
            panjeng="양";
        }
        return panjeng;
    }

    @Override
    public String toString() {
        return "Score{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                ", tot=" + tot +
                ", ave=" + ave +
                ", panjeng='" + panjeng + '\'' +
                '}';
    }
}
