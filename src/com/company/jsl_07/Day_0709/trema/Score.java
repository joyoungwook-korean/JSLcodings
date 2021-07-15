package com.company.jsl_07.Day_0709.trema;

public class Score {

    private int kor,eng,mat,sie,tot;

    public int getTot() {
        return tot;
    }

    private double ave;

    public Score(int kor, int eng, int mat, int sie) {
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.sie = sie;
        setTot();
        setAve();
    }

    public void setTot() {
        this.tot = kor+sie+eng+mat;
    }

    public void setAve() {
        this.ave = tot/(float)4;
    }

    @Override
    public String toString() {
        return "Score{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                ", sie=" + sie +
                ", tot=" + tot +
                ", ave=" + ave +
                '}';
    }
}
