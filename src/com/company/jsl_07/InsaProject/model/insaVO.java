package com.company.jsl_07.InsaProject.model;

public class insaVO {

    private int sawon;
    private String name;
    private String duty;
    private String phone;
    private String indate;
    private String outdate;
    private String dcode;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getInwon() {
        return inwon;
    }

    public void setInwon(int inwon) {
        this.inwon = inwon;
    }

    private String dname;
    private int inwon;


    public int getSawon() {
        return sawon;
    }

    public void setSawon(int sawon) {
        this.sawon = sawon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    @Override
    public String toString() {
        return
                sawon +
                " \t" + name  +
                        " \t" + duty +
                        " \t" + phone +
                        " \t" + indate +
                        " \t" + outdate +
                        " \t" + dcode ;
    }
}
