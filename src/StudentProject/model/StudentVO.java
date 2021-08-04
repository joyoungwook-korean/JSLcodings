package StudentProject.model;

import java.text.DecimalFormat;

public class StudentVO {
    private String syear;
    private String sclass;
    private String sno;
    private String birth;
    private String gender;
    private String tel1;
    private String tel2;
    private String tel3;
    private String sname;
    private String phone;
    private int kor,eng,mat;
    private int tot;
    private String avg;
    private String full_num;
    private String sensei;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSensei() {
        return sensei;
    }

    public void setSensei(String sensei) {
        this.sensei = sensei;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getFull_num() {
        return full_num;
    }

    public void setFull_num(String full_num) {
        this.full_num = full_num;
    }

    public int getTot() {
        return kor+eng+mat;
    }

    public int setTot(int kor, int eng, int mat){
        return kor+eng+mat;
    }
    public void setTot(int tot) {
        this.tot = tot;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(){
        double avg = tot/(float)3.0;
        DecimalFormat format = new DecimalFormat("0.0");
        this.avg = format.format(avg);
    }



    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    @Override
    public String toString() {
        return
                syear + '\t' +
                        sclass + '\t' +
                        sno + '\t' +
                        sname + '\t' +
                        birth + '\t' +
                        gender + '\t' +
                        phone;
    }
}
