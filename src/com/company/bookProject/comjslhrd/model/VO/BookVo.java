package com.company.bookProject.comjslhrd.model.VO;

public class BookVo {
    private int userno;
    private String name;
    private String phone1;
    private String phone2;
    private String phone3;
    private String gender;
    private String birthday;
    private String regdate;
    private int lentno;
    private int bookno;
    private String outdate;
    private String indate;
    private String bookname;
    private String amount;
    private String code_regdate;
    private String phone_all;

    public String getPhone_all() {
        return phone_all;
    }

    public void setPhone_all(String phone_all) {
        this.phone_all = phone_all;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getLentno() {
        return lentno;
    }

    public void setLentno(int lentno) {
        this.lentno = lentno;
    }

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCode_regdate() {
        return code_regdate;
    }

    public void setCode_regdate(String code_regdate) {
        this.code_regdate = code_regdate;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "userno=" + userno +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", regdate='" + regdate + '\'' +
                ", phone_all='" + phone_all + '\'' +
                '}';
    }
}
