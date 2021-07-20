package com.company.jsl_07.ShopProject.model;

public class MemberVO {
    private int custno;
    private String custname;
    private String phone;
    private String gender;
    private String joindate;
    private String grade;
    private String city;

    public int getCustno() {
        return custno;
    }

    public void setCustno(int custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return
                custno + "\t" +
                        custname + "\t" +
                        phone
                        + "\t" +
                        gender
                        + "\t\t" +
                        joindate
                        + "\t" +
                        grade
                        + "\t\t" +
                        city;
    }
}
